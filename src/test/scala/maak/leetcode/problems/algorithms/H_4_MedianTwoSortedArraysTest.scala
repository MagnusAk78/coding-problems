package maak.leetcode.problems.algorithms

class H_4_MedianTwoSortedArraysTest extends org.scalatest.FlatSpec {
  import H_4_MedianTwoSortedArrays._

  "findMedianSortedArrays" should "return 2.0 for input [1, 3], [2]" in {
    assert(findMedianSortedArrays(Array(1, 3), Array(2)) == 2.0)
  }

  "findMedianSortedArrays" should "return 2.5 for input [1, 2], [3, 4]" in {
    assert(findMedianSortedArrays(Array(1, 2), Array(3, 4)) == 2.5)
  }

  "findMedianSortedArrays" should "return 7.0 for input [1,3,7,9,156,456,458], [2,4,5,6,7,8,9]" in {
    assert(findMedianSortedArrays(Array(1,3,7,9,156,456,458), Array(2,4,5,6,7,8,9)) == 7.0)
  }

  //The meaning of total time N should be of O(log(n)) is that N grows linear while n grows exponentially
  "findMedianSortedArrays" should "have a run time complexity of O(log (m+n))" in {
    //Warm up
    for(i <- 1 to 30) findMedianSortedArrays(Array.range(0, 500), Array.range(500, 1000))

    val time1 = System.currentTimeMillis()
    findMedianSortedArrays(Array.range(0, 500000), Array.range(500000, 1000000)) // m + n == 1000000
    val time2 = System.currentTimeMillis()
    findMedianSortedArrays(Array.range(0, 500000), Array.range(5000000, 10000000)) // m + n == 10000000
    val time3 = System.currentTimeMillis()
    findMedianSortedArrays(Array.range(0, 5000000), Array.range(50000000, 100000000)) // m + n == 100000000
    val time4 = System.currentTimeMillis()

    val diffTime1 = time2 - time1
    val diffTime2 = time3 - time2
    val diffTime3 = time4 - time3

    val ratio1 = diffTime2 / diffTime1
    val ratio2 = diffTime3 / diffTime2

    // make sure diffTime1, is about half the time of diffTime2.
    assert(ratio2 < ratio1 * 2.1)
  }
}
