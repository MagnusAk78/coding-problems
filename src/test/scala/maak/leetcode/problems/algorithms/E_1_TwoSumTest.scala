package maak.leetcode.problems.algorithms

class E_1_TwoSumTest extends org.scalatest.FlatSpec {
  import E_1_TwoSum._

  "twoSum" should "return Array(1,2) on input Array(3,2,4) and target 6" in {
    val result = twoSum(Array(3,2,4), 6)
    assert(result.length == 2)
    assert(result.contains(1))
    assert(result.contains(2))
  }

  "twoSum" should "return Array(0,1) on input Array(2,7,11,15) and target 9" in {
    val result = twoSum(Array(2,7,11,15), 9)
    assert(result.length == 2)
    assert(result.contains(0))
    assert(result.contains(1))
  }

  "twoSum" should "return Array(999,1000) on input Array.range(0, 1001) and target 1999" in {
    val result = twoSum(Array.range(0, 1001), 1999)
    assert(result.length == 2)
    assert(result.contains(999))
    assert(result.contains(1000))
  }

  "twoSum" should "return Array(99999,100000) on input Array.range(0, 100001) and target 199999 (and not be slow)" in {
    val timeStart = System.currentTimeMillis()
    val result = E_1_TwoSum.twoSum(Array.range(0, 100001), 199999)
    val time = System.currentTimeMillis() - timeStart
    assert(result.length == 2)
    assert(result.contains(99999))
    assert(result.contains(100000))
    assert(time < 100)
  }
}
