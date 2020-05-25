package maak.leetcode.problems.algorithms

class H_135_CandyTest extends org.scalatest.FlatSpec {
  import H_135_Candy._

  "candy" should "return 0 for input Array()" in {
    val result = candy(Array())
    assert(result == 0)
  }

  "candy" should "return 1 for input [45]" in {
    val result = candy(Array(45))
    assert(result == 1)
  }

  "candy" should "return 5 for input [1, 0, 2]" in {
    val result = candy(Array(1, 0, 2))
    assert(result == 5)
  }

  "candy" should "return 4 for input [1, 2, 2]" in {
    val result = candy(Array(1, 2, 2))
    assert(result == 4)
  }

  "candy" should "return 50 for input [1,0,2,4,5,6,7,4,3,2,2,2,2,0,0,0,9,8,6,1,1,1,1,1]" in {
    val result = candy(Array(1,0,2,4,5,6,7,4,3,2,2,2,2,0,0,0,9,8,6,1,1,1,1,1))
    assert(result == 50)
  }
}
