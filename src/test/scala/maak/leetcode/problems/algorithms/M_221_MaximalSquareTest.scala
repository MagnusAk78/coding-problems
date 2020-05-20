package maak.leetcode.problems.algorithms

class M_221_MaximalSquareTest extends org.scalatest.FlatSpec {
  import M_221_MaximalSquare._

  "maximalSquare" should "return 4 for input 3 x 5 matrix" in {
    val input = Array(Array(one, zero, one, zero, zero),
                      Array(one, zero, one, one, one),
                      Array(one, one, one, one, one),
                      Array(one, zero, zero, one, zero))

    assert(maximalSquare(input) == 4)
  }

  "maximalSquare" should "return 4 for input 1 x 2 matrix" in {
    val input = Array(Array(one, one))

    assert(maximalSquare(input) == 1)
  }

  "maximalSquare" should "return 1 for input 1 x 1 matrix" in {
    val input = Array(Array(one))

    assert(maximalSquare(input) == 1)
  }

  "maximalSquare" should "return 1 for input [[0,1],[0,1]]" in {
    val input = Array(Array(zero, one), Array(zero, one))

    assert(maximalSquare(input) == 1)
  }
}
