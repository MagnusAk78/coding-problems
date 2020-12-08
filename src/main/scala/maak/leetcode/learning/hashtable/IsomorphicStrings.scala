package maak.leetcode.learning.hashtable

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 */
object IsomorphicStrings {


  def isIsomorphic(s: String, t: String): Boolean = {
    import scala.collection.mutable

    if(s.length != t.length) {
      false
    } else {
      val hmap = mutable.HashMap[Char, Char]()
      val hset = mutable.HashSet[Char]()
      val zipped = s.zip(t)

      !zipped.exists(charsInZipped => {
        hmap.get(charsInZipped._1) match {
          case None => {
            hmap.put(charsInZipped._1, charsInZipped._2)
            if(hset.contains(charsInZipped._2)) {
              true
            } else {
              hset.add(charsInZipped._2)
              false
            }
          }
          case Some(charMapped) => charMapped != charsInZipped._2
        }
      })
    }
  }
}
