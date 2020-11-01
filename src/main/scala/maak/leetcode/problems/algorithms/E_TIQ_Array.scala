package maak.leetcode.problems.algorithms

/*
Top Interview Questions: Array
 */
object E_TIQ_Array {

  /* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one. */
  def singleNumber(nums: Array[Int]): Int = {
    nums.reduce((x, y) => x ^ y)
  }

  /* Given an array, rotate the array to the right by k steps, where k is non-negative. */
  def rotate(nums: Array[Int], k: Int): Unit = {
    if (nums.length > 1) {
      val shift = k % nums.length
      val origin = nums.clone()
      for (i <- nums.indices) {
        if (i < nums.length - shift) {
          nums(i + shift) = origin(i)
        } else {
          nums(i - (nums.length - shift)) = origin(i)
        }
      }
    }
  }

  /* Given two arrays, write a function to compute their intersection. */
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val (shortArray, longArray) = if (nums1.length > nums2.length) {
      (nums2.sorted, nums1.sorted)
    } else {
      (nums1.sorted, nums2.sorted)
    }

    val intersection: scala.collection.mutable.ArrayBuffer[Int] = scala.collection.mutable.ArrayBuffer.empty
    var a, b = 0

    while (a <= shortArray.length - 1 && b <= longArray.length - 1) {
      if (shortArray(a) == longArray(b)) {
        intersection.append(shortArray(a))
        a += 1
        b += 1
      }
      else if (longArray(b) < shortArray(a)) {
        b += 1
      } else {
        a += 1
      }
    }

    intersection.toArray
  }
}
