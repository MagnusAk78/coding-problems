package maak.leetcode.problems.algorithms

/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
object E_100_IsSameTree {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    import scala.collection._
    def check(a: TreeNode, b: TreeNode): Boolean = (a == null && b == null) ||
      (a != null && b != null && a.value == b.value)

    val toCheck = mutable.Queue[(TreeNode, TreeNode)]((p, q))
    var mismatch = false

    while(toCheck.nonEmpty && mismatch == false) {
      val t = toCheck.dequeue()
      if(check(t._1, t._2)) {
        if(t._1 != null && t._2 != null) {
          toCheck.enqueue((t._1.left, t._2.left))
          toCheck.enqueue((t._1.right, t._2.right))
        }
      } else {
        mismatch = true
      }
    }
    mismatch == false
  }
}
