package maak.leetcode.problems.algorithms

class H_1326_GardenTapsTest extends org.scalatest.FlatSpec {
  import H_1326_GardenTaps._

  "minTaps" should "return 1 on input n = 5, ranges = [3,4,1,1,0,0]" in {
    assert(minTaps(5, Array(3,4,1,1,0,0)) == 1)
  }

  "minTaps" should "return -1 on input n = 3, ranges = [0,0,0,0]" in {
    assert(minTaps(3, Array(0,0,0,0)) == -1)
  }

  "minTaps" should "return 3 on input n = 7, ranges = [1,2,1,0,2,1,0,1]" in {
    assert(minTaps(7, Array(1,2,1,0,2,1,0,1)) == 3)
  }

  "minTaps" should "return 1 on input n = 8, ranges = [4,0,0,0,4,0,0,0,4]" in {
    assert(minTaps(8, Array(4,0,0,0,4,0,0,0,4)) == 1)
  }

  "minTaps" should "return 1 on input n = 9, ranges = [0,5,0,3,3,3,1,4,0,4]" in {
    assert(minTaps(9, Array(0,5,0,3,3,3,1,4,0,4)) == 2)
  }
}
