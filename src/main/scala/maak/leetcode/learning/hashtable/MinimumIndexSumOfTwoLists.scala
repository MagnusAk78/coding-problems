package maak.leetcode.learning.hashtable

object MinimumIndexSumOfTwoLists {

  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
    import scala.collection.mutable

    val hmap = mutable.HashMap[String, Int]()
    for(i1 <- list1.indices) {
      val restaurant = list1(i1)
      val i2 = list2.indexOf(restaurant)
      if(i2 >= 0) {
        // Exists in both list
        hmap.put(restaurant, i1 + i2)
      }
    }
    val sorted = hmap.toArray.sortBy(_._2)
    val result = sorted.takeWhile(restaurantIndexsum => restaurantIndexsum._2 == sorted.head._2).map(_._1)
    result
  }
}
