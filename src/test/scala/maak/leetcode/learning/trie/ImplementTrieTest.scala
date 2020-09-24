package maak.leetcode.learning.trie

class ImplementTrieTest extends org.scalatest.FlatSpec {
  import ImplementTrie.Trie

  "ImplementTrie.Trie" should "return true for inputs 'Hello'" in {
    var obj = new Trie()
    obj.insert("Hello")
    assert(obj.search("Hello"))
    assert(obj.startsWith("Hel"))
  }
}
