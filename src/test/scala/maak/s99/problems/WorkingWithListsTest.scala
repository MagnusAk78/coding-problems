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

  "P10 - encode" should "return List((4, 1), (1, 2), (2, 3), (2, 1), (1, 4)) for input List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)" in {
    assert(encode(List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)) == List((4, 1), (1, 2), (2, 3), (2, 1), (1, 4)))
  }

  "P11 - encodeModified" should "return List((4, 1), 2, (2, 3), (1, 1), 4) for input List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)" in {
    assert(encodeModified(List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4)) == List((4, 1), 2, (2, 3), (2, 1), 4))
  }

  "P12 - decode" should "return List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4) for input List((4, 1), (1, 2), (2, 3), (1, 1), (1, 4))" in {
    assert(decode(List((4, 1), (1, 2), (2, 3), (1, 1), (1, 4))) == List(1, 1, 1, 1, 2, 3, 3, 1, 4))
  }

  "P13 - encodeDirect" should "return List((4, 1), (1, 2), (2, 3), (2, 1), (2, 4)) for input List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4, 4)" in {
    assert(encodeDirect(List(1, 1, 1, 1, 2, 3, 3, 1, 1, 4, 4)) == List((4, 1), (1, 2), (2, 3), (2, 1), (2, 4)))
  }

  "P14 - duplicate" should "return List(1, 1, 4, 4) for input List(1, 4)" in {
    assert(duplicate(List(1, 4)) == List(1, 1, 4, 4))
  }

  "P15 - duplicateN" should "return List(1, 1, 1, 4, 4, 4) for input (3, List(1, 4))" in {
    assert(duplicateN(3, List(1, 4)) == List(1, 1, 1, 4, 4, 4))
  }

  "P16 - drop" should "return List(1, 2, 4, 5, 7, 8) for input (3, List.range(1, 10))" in {
    assert(drop(3, List.range(1, 10)) == List(1, 2, 4, 5, 7, 8))
    assert(drop(3, List.range(1, 11)) == List(1, 2, 4, 5, 7, 8, 10))
  }

  "P17 - split" should "return (List(1, 2, 3), List(4, 5, 6)) for input (3, List.range(1, 7))" in {
    assert(split(3, List.range(1, 7)) == (List(1, 2, 3), List(4, 5, 6)))
    assert(split(2, List.range(1, 7)) == (List(1, 2), List(3, 4, 5, 6)))
  }

  "P18 - slice" should "return ls.slice(i, k) for input slice(i, k, ls)" in {
    val ls = List.range(1, 50)
    val (i, k) = (5, 62)
    assert(slice(i, k, ls) == ls.slice(i, k))
  }
}
