package maak.leetcode.learning.hashtable

// Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
object FirstUniqueCharacter {
  def firstUniqChar(s: String): Int = {
    import scala.collection.mutable

    val hmap = mutable.HashMap[Char, (Int, Int)]()
    for(ci <- s.zipWithIndex) {
      hmap.get(ci._1) match {
        case None => hmap.put(ci._1, (ci._2, 1))
        case Some(value) => hmap.put(ci._1, (ci._2, value._2 + 1))
      }
    }
    for(c <- s) {
      val result = hmap.getOrElse(c, (-1, -1))
      if(result._2 == 1) {
        return result._1
      }
    }
    return -1
  }
}
