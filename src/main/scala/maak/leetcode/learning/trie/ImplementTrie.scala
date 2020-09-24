package maak.leetcode.learning.trie

/**
 * Implement a trie with insert, search, and startsWith methods.
 */
object ImplementTrie {

  import scala.collection.mutable

  class Trie() {

    /** Initialize your data structure here. */
    class TrieNode() {
      // HashMap solution, not the fastest but probably the easiest.
      val hashMap = new mutable.HashMap[Char, TrieNode]();
      var isWord: Boolean = false;
    }

    val rootNode = new TrieNode();

    /** Inserts a word into the trie. */
    def insert(word: String) {
      var current = rootNode;
      for(c <- word) {
        if(current.hashMap.get(c).isEmpty) {
          current.hashMap.addOne(c, new TrieNode());
        }
        current = current.hashMap(c);
      }
      current.isWord = true;
    }

    /** Returns if the word is in the trie. */
    def search(word: String): Boolean = {
      var current: Option[TrieNode] = Some(rootNode);
      var index = 0;
      while(current.nonEmpty && index < word.length) {
        val c = word.charAt(index);
        current = current.get.hashMap.get(c);
        index+=1;
      }
      current.nonEmpty && current.get.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    def startsWith(prefix: String): Boolean = {
      var current: Option[TrieNode] = Some(rootNode);
      var index = 0;
      while(current.nonEmpty && index < prefix.length) {
        current = current.get.hashMap.get(prefix.charAt(index));
        index+=1;
      }
      current.nonEmpty;
    }
  }
}
