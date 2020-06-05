package maak.s99.problems

class WorkingWithListsTest extends org.scalatest.FlatSpec {
  import WorkingWithLists._

  "P01 - last" should "return 8 for input List(1, 1, 2, 3, 5, 8)" in {
    assert(last(List(1, 1, 2, 3, 5, 8)) == 8)
  }

  "P02 - penultimate" should "return 5 for input List(1, 1, 2, 3, 5, 8)" in {
    assert(penultimate(List(1, 1, 2, 3, 5, 8)) == 5)
  }

  "P03 - nth" should "return 2 for input 2, List(1, 1, 2, 3, 5, 8)" in {
    assert(nth(2, List(1, 1, 2, 3, 5, 8)) == 2)
  }

  "P04 - length" should "return 6 for input 2, List(1, 1, 2, 3, 5, 8)" in {
    assert(length(List(1, 1, 2, 3, 5, 8)) == 6)
  }

  "P05 - reverse" should "return List(8, 5, 3, 2, 1, 1) for input List(1, 1, 2, 3, 5, 8)" in {
    assert(reverse(List(1, 1, 2, 3, 5, 8)) == List(8, 5, 3, 2, 1, 1))
  }

  "P06 - isPalindrome" should "return true for input List(1, 2, 3, 2, 1)" in {
    assert(isPalindrome(List(1, 2, 3, 2, 1)))
  }

  "P06 - isPalindrome" should "return false for input List(1, 2, 3, 2, 3)" in {
    assert(!isPalindrome(List(1, 2, 3, 2, 3)))
  }

  "P07 - flatten" should "return List(1, 1, 2, 3, 5, 8) for input List(List(1, 1), 2, List(3, List(5, 8)))" in {
    assert(flatten(List(List(1, 1), 2, List(3, List(5, 8)))) == List(1, 1, 2, 3, 5, 8))
  }

  "P08 - compress" should "return List(1, 2, 3, 1, 4, 5) for input List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4, 5, 5, 5, 5)" in {
    assert(compress(List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4, 5, 5, 5, 5)) == List(1, 2, 3, 1, 4, 5))
  }

  "P09 - pack" should "return List(List(1, 1, 1, 1), List(2), List(3, 3), List(1, 1), List(4)) for input List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)" in {
    assert(pack(List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)) == List(List(1, 1, 1, 1), List(2), List(3, 3), List(1, 1), List(4)))
  }

  "P10 - encode" should "return List((4, 1), (1, 2), (2, 3), (1, 1), (1, 4)) for input List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)" in {
    assert(encode(List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)) == List((4, 1), (1, 2), (2, 3), (2, 1), (1, 4)))
  }

  "P11 - encodeModified" should "return List((4, 1), 2, (2, 3), (1, 1), 4) for input List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)" in {
    assert(encodeModified(List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)) == List((4, 1), 2, (2, 3), (2, 1), 4))
  }
}
