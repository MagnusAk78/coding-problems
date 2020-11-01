package maak.leetcode.problems.algorithms

class E_TIQ_ArrayTest extends org.scalatest.FlatSpec {
  import E_TIQ_Array._

  "singleNumber" should "return 1 for input [2,2,1]" in {
    assert(singleNumber(Array(2,2,1)) == 1)
  }

  "singleNumber" should "return 4 for input [4,1,2,1,2]" in {
    assert(singleNumber(Array(4,1,2,1,2)) == 4)
  }

  "rotate" should "change array into [5,6,7,1,2,3,4] for input [1,2,3,4,5,6,7], k = 3" in {
    val nums = Array(1,2,3,4,5,6,7)
    rotate(nums, 3)
    assert(nums sameElements Array(5, 6, 7, 1, 2, 3, 4))
  }

  "rotate" should "change array into [-1] for input [-1], k = 2" in {
    val nums = Array(-1)
    rotate(nums, 2)
    assert(nums sameElements Array(-1))
  }

  "intersect" should "return [2,2] for input [1,2,2,1], [2,2]" in {
    assert(intersect(Array(1,2,2,1), Array(2,2)) sameElements Array(2,2))
  }
}
