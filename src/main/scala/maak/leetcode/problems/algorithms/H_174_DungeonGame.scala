package maak.leetcode.problems.algorithms

import scala.annotation.tailrec

/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the
top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0
or below, he dies immediately. Some of the rooms are guarded by demons, so the knight loses health (negative integers)
upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health
(positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each
step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 */
object H_174_DungeonGame {

  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
    calculateMinimumBottomUpApproach(dungeon)
  }

  private def calculateMinimumBottomUpApproach(dungeon: Array[Array[Int]]): Int = {

    // Create a clone dungeon where each room corresponds to how much health is needed to go inside.
    val healthNeededDungeon = Array.ofDim[Int](dungeon.length, dungeon(0).length)

    // Loop through all the rooms from bottom right to decide how much health is needed backwards.
    for (x <- dungeon(0).indices.reverse) {
      for (y <- dungeon.indices.reverse) {

        // Look how much health is needed to step right (if possible)
        val healthNeededToStepRight = if (x < dungeon(0).length - 1) {
          Some(healthNeededDungeon(y)(x + 1))
        } else {
          None
        }

        // Look how much health is needed to step down (if possible)
        val healthNeededToStepDown = if (y < dungeon.length - 1) {
          Some(healthNeededDungeon(y + 1)(x))
        } else {
          None
        }

        val rightOrDown = healthNeededToStepRight match {
          case Some(stepRight) => healthNeededToStepDown match {
            case Some(stepDown) => Some(math.min(stepRight, stepDown))
            case None => Some(stepRight)
          }
          case None => healthNeededToStepDown match {
            case Some(stepDown) => Some(stepDown)
            case None => None
          }
        }

        // Take the least needed health (down or right) and compare it to the current room. Save the difference or 1
        // if it's a net gain (because you need one health to survive).
        healthNeededDungeon(y)(x) = math.max(rightOrDown.getOrElse(1) - dungeon(y)(x), 1)
      }
    }

    printDungeons(dungeon, healthNeededDungeon)

    healthNeededDungeon(0)(0)
  }

  private def printDungeons(dungeon: Array[Array[Int]], healthNeededDungeon: Array[Array[Int]]): Unit = {
    for (y <- dungeon.indices) {
      print("[")
      print(dungeon(y).mkString(" "))
      print("]\t\t[")
      print(healthNeededDungeon(y).mkString(" "))
      println("]")
    }
  }
}
