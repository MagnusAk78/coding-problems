package maak.leetcode.problems.algorithms

class E_7_ReverseIntTest extends org.scalatest.FlatSpec {
  import E_7_ReverseInt._

  "reverseInt" should "return 21 for input 120" in {
    assert(reverseInt(120) == 21)
  }

  "reverseInt" should "return 123 for input 321" in {
    assert(reverseInt(321) == 123)
  }

  "reverseInt" should "return -123 for input -321" in {
    assert(reverseInt(-321) == -123)
  }

  "reverseInt" should "return 0 for input 1534236469" in {
    assert(reverseInt(1534236469) == 0)
  }
}
