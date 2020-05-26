package maak.leetcode.problems.algorithms

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.
 */
object H_4_MedianTwoSortedArrays {

  import scala.annotation.tailrec
  import scala.collection.mutable.ArrayBuffer

  /*
  The limitation that it should be of log(X) complexity hints us towards a binary search algorithm. However, finding
  median of one array is very simple (just get the middle value/values). This suggests that the real problem here is
  to merge to two sorted arrays in a more efficient way than (nums1 ++ nums2).sorted (which will also work).
   */

  private def mergeSortedArrays(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    @tailrec
    def mergeSortedArraysInt(nums1: Array[Int], n: Int, nums2: Array[Int], m: Int,
                             result: ArrayBuffer[Int]): Array[Int] = {
      if(n < nums1.length && m < nums2.length) {
        if(nums1(n) < nums2(m)) {
          mergeSortedArraysInt(nums1, n + 1, nums2, m, result.append(nums1(n)))
        } else {
          mergeSortedArraysInt(nums1, n, nums2, m + 1, result.append(nums2(m)))
        }
      } else if(m < nums2.length) {
        mergeSortedArraysInt(nums1, n, nums2, m + 1, result.append(nums2(m)))
      } else if(n < nums1.length) {
        mergeSortedArraysInt(nums1, n + 1, nums2, m, result.append(nums1(n)))
      } else {
        result.toArray
      }
    }
    mergeSortedArraysInt(nums1, 0, nums2, 0, ArrayBuffer.empty[Int])
  }

  private def findMedianSortedArray(array: Array[Int]): Double = {
    if(array.length == 0) {
      0
    } else if(array.length % 2 == 0) {
      (array(math.floor(array.length / 2.0).toInt - 1) + array(math.floor(array.length / 2.0).toInt)) / 2.0
    } else {
      array(math.floor(array.length / 2.0).toInt).toDouble
    }
  }

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    findMedianSortedArray(mergeSortedArrays(nums1, nums2))
  }
}
