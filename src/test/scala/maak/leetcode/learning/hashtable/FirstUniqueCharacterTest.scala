package maak.leetcode.learning.hashtable

class FirstUniqueCharacterTest extends org.scalatest.FlatSpec {
  import FirstUniqueCharacter.firstUniqChar

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
}
