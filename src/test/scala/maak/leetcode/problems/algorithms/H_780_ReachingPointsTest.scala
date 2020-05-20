package maak.leetcode.problems.algorithms

class H_780_ReachingPointsTest extends org.scalatest.FlatSpec {
  import H_780_ReachingPoints._

  "reachingPoints" should "return true for input sx = 1, sy = 1, tx = 3, ty = 5" in {
    assert(reachingPoints(1, 1, 3, 5))
  }

  "reachingPoints" should "return false for input sx = 1, sy = 1, tx = 2, ty = 2" in {
    assert(!reachingPoints(1, 1, 2, 2))
  }

  "reachingPoints" should "return true for input sx = 1, sy = 1, tx = 1, ty = 1" in {
    assert(reachingPoints(1, 1, 1, 1))
  }

  "reachingPoints" should "return true for input sx = 6, sy = 3, tx = 6, ty = 15" in {
    assert(reachingPoints(6, 3, 6, 15))
  }

  "reachingPoints" should "return false for input sx = 35, sy = 13, tx = 455955547, ty = 420098884" in {
    assert(!reachingPoints(35, 13, 455955547, 420098884))
  }
}
