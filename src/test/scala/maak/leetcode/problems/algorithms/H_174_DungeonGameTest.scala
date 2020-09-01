package maak.leetcode.problems.algorithms

class H_174_DungeonGameTest extends org.scalatest.FlatSpec {
  import H_174_DungeonGame._

  "calculateMinimumHP" should "return 7 for input [[-2, -3, 3], [-5, -10, 1], [10, 30, -5]]" in {
    assert(calculateMinimumHP(Array(Array(-2, -3, 3), Array(-5, -10, 1), Array(10, 30, -5))) == 7)
  }

  "calculateMinimumHP" should "return 8 for input [[-2, -3, 3, -10], [-5, -10, 1, -10], [10, 30, -5, -10], [-3, 4, -5, -7]]" in {
    assert(calculateMinimumHP(Array(Array(-2, -3, 3, -10), Array(-5, -10, 1, -10), Array(10, 30, -5, -10),
      Array(-3, 4, -5, -7))) == 8)
  }
}
