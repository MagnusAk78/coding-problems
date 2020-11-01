package maak.leetcode.problems.algorithms

class E_342_PowerOfFourTest extends org.scalatest.FlatSpec {
  import E_342_PowerOfFour.isPowerOfFour

  "isPowerOfFour" should "return true for 1" in {
    assert(isPowerOfFour(1))
  }

  "isPowerOfFour" should "return true for 4" in {
    assert(isPowerOfFour(4))
  }

  "isPowerOfFour" should "return true for 16" in {
    assert(isPowerOfFour(16))
  }

  "isPowerOfFour" should "return false for 5" in {
    assert(!isPowerOfFour(5))
  }

  "isPowerOfFour" should "return true for 256" in {
    assert(isPowerOfFour(256))
  }

  "isPowerOfFour" should "return false for -240" in {
    assert(!isPowerOfFour(-240))
  }
}
