package maak.leetcode.problems.algorithms

import scala.annotation.tailrec

/* Merge k sorted linked lists and return it as one sorted list. */
object H_23_MergeKLists {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    mergeKListsTR(lists.filterNot(_ == null), null, null)
  }

  @tailrec
  def mergeKListsTR(lists: Array[ListNode], head: ListNode, last: ListNode): ListNode = {
    if(lists.isEmpty) {
      head
    } else {
      val sortedLists = lists.sortBy(_.x)
      val nextNode = sortedLists.head
      sortedLists(0) = nextNode.next
      val newLists = sortedLists.filterNot(_ == null)
      if(last != null) {
        last.next = nextNode
      }
      if(head == null) {
        mergeKListsTR(newLists, nextNode, nextNode)
      } else {
        mergeKListsTR(newLists, head, nextNode)
      }
    }
  }
}
