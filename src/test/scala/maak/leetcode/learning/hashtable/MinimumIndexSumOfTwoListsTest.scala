package maak.leetcode.learning.hashtable

class MinimumIndexSumOfTwoListsTest extends org.scalatest.FlatSpec {
  import MinimumIndexSumOfTwoLists._

  "findRestaurant" should
    """return ["Shogun"] on input ["Shogun","Tapioca Express","Burger King","KFC"] and
      |["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]""".stripMargin in {
    assert(findRestaurant(Array("Shogun", "Tapioca Express", "Burger King", "KFC"),
      Array("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun")) sameElements Array("Shogun"))
  }

  "findRestaurant" should
    """return ["Shogun"] on input ["Shogun","Tapioca Express","Burger King","KFC"] and
      |["KFC","Shogun","Burger King"]""".stripMargin in {
    assert(findRestaurant(Array("Shogun", "Tapioca Express", "Burger King", "KFC"),
      Array("KFC", "Shogun", "Burger King")) sameElements Array("Shogun"))
  }

  "findRestaurant" should
    """return [KFC","Burger King","Tapioca Express","Shogun] on input ["Shogun","Tapioca Express","Burger King","KFC"] and
      |["KFC","Burger King","Tapioca Express","Shogun"]""".stripMargin in {
    assert(findRestaurant(Array("Shogun", "Tapioca Express", "Burger King", "KFC"),
      Array("KFC","Burger King","Tapioca Express","Shogun")).sorted sameElements Array("KFC","Burger King","Tapioca Express","Shogun").sorted)
  }

  "findRestaurant" should
    """return ["KFC","Burger King","Tapioca Express","Shogun"] on input ["Shogun","Tapioca Express","Burger King","KFC"] and
      |["KNN","KFC","Burger King","Tapioca Express","Shogun"]""".stripMargin in {
    assert(findRestaurant(Array("Shogun", "Tapioca Express", "Burger King", "KFC"),
      Array("KNN","KFC","Burger King","Tapioca Express","Shogun")).sorted sameElements Array("KFC","Burger King","Tapioca Express","Shogun").sorted)
  }

  "findRestaurant" should """return ["KFC"] on input ["KFC"] and ["KFC"]""".stripMargin in {
    assert(findRestaurant(Array("KFC"), Array("KFC")) sameElements Array("KFC"))
  }
}
