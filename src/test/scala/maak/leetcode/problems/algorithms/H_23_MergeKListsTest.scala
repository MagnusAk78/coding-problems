package maak.leetcode.problems.algorithms

import scala.annotation.tailrec

class H_23_MergeKListsTest extends org.scalatest.FlatSpec {
  import H_23_MergeKLists._

  @tailrec
  private def stringify(ln: ListNode, str: String = ""): String = if(ln.next != null) {
    stringify(ln.next, str + ln.x + "->")
  } else {
    str + ln.x.toString
  }

  private def fromString(listNodeString: String): ListNode = {
    var arrayOfNumbers = listNodeString.split("->").map(_.toInt)
    var currentNode: ListNode = null
    var nextNode: ListNode = null
    for(i <- arrayOfNumbers.indices.reverse) {
      currentNode = new ListNode(arrayOfNumbers(i), nextNode)
      nextNode = currentNode
    }
    currentNode
  }

  "mergeKLists" should "return 1->1->2->3->4->4->5->6 for input [1->4->5,1->3->4,2->6]" in {
    val result = mergeKLists(Array(fromString("1->4->5"), fromString("1->3->4"), fromString("2->6")))
    assert(stringify(result) == "1->1->2->3->4->4->5->6")
  }

  "mergeKLists" should "return handle empty imput" in {
    val result = mergeKLists(Array())
    assert(result == null)
  }
}
