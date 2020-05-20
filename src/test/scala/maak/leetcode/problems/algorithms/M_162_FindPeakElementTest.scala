package maak.leetcode.problems.algorithms

class M_162_FindPeakElementTest extends org.scalatest.FlatSpec {
  import M_162_FindPeakElement._

  "findPeakElement" should "return 2 for input (1,2,3,1)" in {
    val result = findPeakElement(Array(1,2,3,1))
    assert(result == 2)
  }

  "findPeakElement" should "return 1 or 5 for input (1,2,1,3,5,6,4)" in {
    val result = findPeakElement(Array(1,2,1,3,5,6,4))
    assert(result == 1 || result == 5)
  }

  "findPeakElement" should "return 0 for input (-2147483648)" in {
    val result = findPeakElement(Array(-2147483648))
    assert(result == 0)
  }
}