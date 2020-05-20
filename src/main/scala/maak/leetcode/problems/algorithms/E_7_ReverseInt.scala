package maak.leetcode.problems.algorithms

/*
Given a 32-bit signed integer, reverse digits of an integer.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
range: [−2^31, 2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed
integer overflows.
 */
object E_7_ReverseInt {
  def reverseInt(x: Int): Int = {
    var left = x
    var reverse: Long = 0
    while(left != 0) {
      val reminder = left % 10
      left -= reminder
      reverse += reminder
      if(math.abs(left) > 9) {
        left /= 10
        reverse *= 10
      }
    }
    if(reverse > Int.MaxValue || reverse < Int.MinValue) {
      0
    } else {
      reverse.toInt
    }
  }
}
