package maak.leetcode.problems.algorithms

/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
(16 => true, 5 => false)

Follow up: Could you solve it without loops/recursion?
*/
object E_342_PowerOfFour {
  def isPowerOfFour(num: Int): Boolean = {
    (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num)
  }
}
