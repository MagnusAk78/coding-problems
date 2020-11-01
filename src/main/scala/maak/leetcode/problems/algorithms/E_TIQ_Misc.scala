package maak.leetcode.problems.algorithms

object E_TIQ_Misc {
  /* You are climbing a stair case. It takes n steps to reach to the top.
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? */
  def climbStairs(n: Int): Int = {
    var climbs = 0
    val array = Array.fill(n+1) {0}
    var sum = 0
    for(i <- array.indices) {
      if(i == 0) {
        array(i) = 0
      } else if(i == 1) {
        array(i) = 1
      } else if(i == 2) {
        array(i) = 2
      } else if(n == 3) {
        array(i) = 3
      } else {
        array(i) = array(i-1) + array(i-2)
      }
    }
    array.last
  }
}
