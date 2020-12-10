package maak.misc.relations

/**
 * Problem: Model people and their relations. Create function that can return that specific relation.
 * Relation: mother, father, brother, sister, son, daughter.
 */

abstract class Human

trait Male extends Human

trait Female extends Human

class Person(
              val name: String,
              val mother: Option[Person with Female] = None,
              val father: Option[Person with Male] = None) extends Human {

  def isMotherTo(other: Person): Boolean = other.mother.contains(this)

  def isFatherTo(other: Person): Boolean = other.father.contains(this)

  def isChildOf(other: Person): Boolean = mother.contains(other) || father.contains(other)

  def hasSameMotherAs(other: Person): Boolean = (mother, other.mother) match {
    case (Some(myMother), Some(otherMother)) if myMother == otherMother => true
    case _ => false
  }

  def hasSameFatherAs(other: Person): Boolean = (father, other.father) match {
    case (Some(myFather), Some(otherFather)) if myFather == otherFather => true
    case _ => false
  }
}

object Person {

  sealed trait Relation

  case object NO_RELATION extends Relation

  case object MOTHER extends Relation

  case object FATHER extends Relation

  case object BROTHER extends Relation

  case object SISTER extends Relation

  case object SIBLING extends Relation

  case object SON extends Relation

  case object DAUGHTER extends Relation

  case object CHILD extends Relation

  /**
   * Returns the relation that defines the relation between person 1 and person 2
   *
   * @param person1 The person who the relation refers to
   * @param person2 The person who the relation refers from
   * @return Relation
   */
  def relation(person1: Person, person2: Person): Relation = {
    if (person1 isMotherTo person2) {
      MOTHER
    } else if (person1 isFatherTo person2) {
      FATHER
    } else if (person1 isChildOf person2) {
      person1 match {
        case _: Male => SON
        case _: Female => DAUGHTER
        case _ => CHILD
      }
    } else if ((person1 hasSameMotherAs person2) || (person1 hasSameFatherAs person2)) {
      person1 match {
        case _: Male => BROTHER
        case _: Female => SISTER
        case _ => SIBLING
      }
    } else {
      NO_RELATION
    }
  }
}