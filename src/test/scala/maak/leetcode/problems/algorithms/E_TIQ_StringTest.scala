package maak.leetcode.problems.algorithms

import maak.leetcode.problems.algorithms.E_TIQ_Array.rotate

class E_TIQ_StringTest extends org.scalatest.FlatSpec {
  import E_TIQ_String._

  "reverseString" should "return olleh for input hello" in {
    val helloString = "Hello"
    val stringArray = helloString.toArray
    val reversedStringArray = helloString.reverse.toArray
    reverseString(stringArray)
    assert(stringArray sameElements reversedStringArray)
  }

  "firstUniqChar" should "return 0 for input 'leetcode'" in {
    assert(firstUniqChar("leetcode") == 0)
  }

  "firstUniqChar" should "return 2 for input 'loveleetcode'" in {
    assert(firstUniqChar("loveleetcode") == 2)
  }

  "firstUniqChar" should "return -1 for input 'cc'" in {
    assert(firstUniqChar("cc") == -1)
  }

  "firstUniqChar" should "return 0 for input 'z'" in {
    assert(firstUniqChar("z") == 0)
  }

  "firstUniqChar" should "return -1 for input 'aadadaad'" in {
    assert(firstUniqChar("aadadaad") == -1)
  }

  "myAtoi" should "return 4193 for input '4193 with words'" in {
    assert(myAtoi("4193 with words") == 4193)
  }

  "myAtoi" should "return 0 for input 'words and 987'" in {
    assert(myAtoi("words and 987") == 0)
  }

  "myAtoi" should "return -42 for input '   -42'" in {
    assert(myAtoi("   -42") == -42)
  }

  "myAtoi" should "return -2147483648 for input '-91283472332'" in {
    assert(myAtoi("-91283472332") == -2147483648)
  }

  "myAtoi" should "return 2147483647 for input '9223372036854775808'" in {
    assert(myAtoi("9223372036854775808") == 2147483647)
  }

  ""
}
