package maak.leetcode.problems.algorithms

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
object E_1_TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    import scala.collection.mutable

    val hmap = mutable.HashMap[Int, Int]()
    for(i1 <- nums.indices) {
      hmap.get(target - nums(i1)) match {
        case Some(i2) => return Array(i1, i2)
        case None =>
      }
      hmap.addOne((nums(i1), i1))
    }
    Array()
  }
}
