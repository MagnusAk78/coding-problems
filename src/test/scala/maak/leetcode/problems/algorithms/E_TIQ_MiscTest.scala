package maak.leetcode.problems.algorithms

class E_TIQ_MiscTest extends org.scalatest.FlatSpec {
  import E_TIQ_Misc._

  "climbStairs" should "return 2 for input 2" in {
    assert(climbStairs(2) == 2)
  }

  "climbStairs" should "return 3 for input 3" in {
    assert(climbStairs(3) == 3)
  }

  "climbStairs" should "return 5 for input 4" in {
    assert(climbStairs(4) == 5)
  }

  "climbStairs" should "return 8 for input 5" in {
    assert(climbStairs(5) == 8)
  }
}
