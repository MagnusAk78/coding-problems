package maak.leetcode.problems.algorithms

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
  The left subtree of a node contains only nodes with keys less than the node's key.
  The right subtree of a node contains only nodes with keys greater than the node's key.
  Both the left and right subtrees must also be binary search trees.
 */
object M_98_ValidateBinaryTree {

  // Definition for a binary tree node (given by LC).
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  // This case class is a way to separate each validation into its own entity, that way it is possible to
  // iterate them using a tail recursive function, which is normally not possible in binary tree since
  // you need to check both left and right nodes.
  case class NodeValidation(treeNode: TreeNode, minLimit: Long, maxLimit: Long) {
    lazy val leftValid: Boolean = treeNode.left match {
      case null => true
      case left => left.value < treeNode.value && left.value > minLimit
    }

    lazy val rightValid: Boolean = treeNode.right match {
      case null => true
      case right => right.value > treeNode.value && right.value < maxLimit
    }

    lazy val isValid: Boolean = leftValid && rightValid
  }

  @scala.annotation.tailrec
  private def isValidBST(nodeValidations: List[NodeValidation]): Boolean = nodeValidations match {
    case Nil => true
    case nodeValidation :: nodeValidationsLeft => {
      if(nodeValidation.isValid) {
        var newList = nodeValidationsLeft
        newList = if(nodeValidation.treeNode.left != null) {
          NodeValidation(nodeValidation.treeNode.left, nodeValidation.minLimit,
            math.min(nodeValidation.maxLimit, nodeValidation.treeNode.value)) :: newList
        } else {
          newList
        }
        newList = if(nodeValidation.treeNode.right != null) {
          NodeValidation(nodeValidation.treeNode.right, math.max(nodeValidation.minLimit,
            nodeValidation.treeNode.value), nodeValidation.maxLimit) :: newList
        } else {
          newList
        }
        isValidBST(newList)
      } else {
        false
      }
    }
  }

  def isValidBST(root: TreeNode): Boolean = root match {
    case null => true
    case treeNode => isValidBST(List(NodeValidation(treeNode, Long.MinValue, Long.MaxValue)))
  }
}
