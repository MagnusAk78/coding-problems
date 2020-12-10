package maak.misc.relations

class PersonTest extends org.scalatest.FlatSpec {
  import Person._

  "relation" should "identify no relation at all" in {
    val person1 = new Person("Person1")
    val person2 = new Person("Person2")
    assert(Person.relation(person1, person2) == NO_RELATION)
  }

  "relation" should "identify mother and father to a child" in {
    val mother = new Person("Mother") with Female
    val father = new Person("Father") with Male
    val child = new Person("Child", mother = Some(mother), father = Some(father))
    assert(Person.relation(mother, child) == MOTHER)
    assert(Person.relation(father, child) == FATHER)
  }

  "relation" should "identify child to father and mother" in {
    val mother = new Person("Mother") with Female
    val father = new Person("Father") with Male
    val child = new Person("Child", mother = Some(mother), father = Some(father))
    assert(Person.relation(child, father) == CHILD)
    assert(Person.relation(child, mother) == CHILD)
  }

  "relation" should "identify son and daughter to mother and father" in {
    val mother = new Person("Mother") with Female
    val father = new Person("Father") with Male
    val son = new Person("Son", mother = Some(mother), father = Some(father)) with Male
    val daughter = new Person("Daughter", mother = Some(mother), father = Some(father)) with Female
    assert(Person.relation(son, mother) == SON)
    assert(Person.relation(son, father) == SON)
    assert(Person.relation(daughter, mother) == DAUGHTER)
    assert(Person.relation(daughter, father) == DAUGHTER)
  }

  "relation" should "identify brother, sister, and sibling" in {
    val mother = new Person("Mother") with Female
    val father = new Person("Father") with Male
    val son = new Person("Son", mother = Some(mother), father = Some(father)) with Male
    val daughter = new Person("Daughter", mother = Some(mother), father = Some(father)) with Female
    val child = new Person("Child", mother = Some(mother), father = Some(father))
    assert(Person.relation(son, daughter) == BROTHER)
    assert(Person.relation(daughter, son) == SISTER)
    assert(Person.relation(child, son) == SIBLING)
    assert(Person.relation(child, daughter) == SIBLING)
    assert(Person.relation(daughter, child) == SISTER)
    assert(Person.relation(son, child) == BROTHER)
  }
}


