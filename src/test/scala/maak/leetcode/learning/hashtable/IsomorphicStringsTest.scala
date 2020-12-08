package maak.leetcode.learning.hashtable

class IsomorphicStringsTest extends org.scalatest.FlatSpec {
  import IsomorphicStrings._

  "isIsomorphic" should "return true on input 'egg' and 'add'" in {
    assert(isIsomorphic("egg", "add"))
  }

  "isIsomorphic" should "return false on input 'foo' and 'bar'" in {
    assert(!isIsomorphic("foo", "bar"))
  }

  "isIsomorphic" should "return true on input 'paper' and 'title'" in {
    assert(isIsomorphic("paper", "title"))
  }

  "isIsomorphic" should "return false on input 'ab' and 'aa'" in {
    assert(!isIsomorphic("ab", "aa"))
  }
}
