package maak.leetcode.problems.algorithms

class M_98_ValidateBinaryTreeTest extends org.scalatest.FlatSpec {
  import M_98_ValidateBinaryTree._

  "isValidBST" should "return true for input [0,-1]" in {
    val root = new TreeNode(0, new TreeNode(-1))
    assert(isValidBST(root))
  }

  "isValidBST" should "return false for input [2,1,3]" in {
    val root = new TreeNode(2, new TreeNode(1), new TreeNode(3))
    assert(isValidBST(root))
  }

  "isValidBST" should "return false for input [5,1,4,null,null,3,6]" in {
    val root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))
    assert(!isValidBST(root))
  }

  "isValidBST" should "return false for input [5,1,6,null,null,4,7]" in {
    val root = new TreeNode(5, new TreeNode(1), new TreeNode(6, new TreeNode(7), new TreeNode(7)))
    assert(!isValidBST(root))
  }

  "isValidBST" should "return true for input [-2147483648, null, 2147483647]" in {
    val root = new TreeNode(-2147483648, null, new TreeNode(2147483647))
    assert(isValidBST(root))
  }
}
