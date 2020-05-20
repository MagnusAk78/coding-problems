package maak.leetcode.problems.algorithms

class E_100_IsSameTreeTest extends org.scalatest.FlatSpec {
  import E_100_IsSameTree._

  "isSameTree" should "return true for same tree" in {
    val b = new TreeNode(_value = 2)
    val c = new TreeNode(_value = 3)
    val a = new TreeNode(_value = 1, _left = b, _right = c)
    val q = new TreeNode(_value = 1, _left = b, _right = c)
    assert(isSameTree(a, q))
  }

  "isSameTree" should "return false for different tree 1" in {
    val b = new TreeNode(_value = 2)
    val c = new TreeNode(_value = 3)
    val a = new TreeNode(_value = 1, _left = b, _right = c)
    val q = new TreeNode(_value = 1, _left = c)
    assert(!isSameTree(a, q))
  }

  "isSameTree" should "return false for different tree 2" in {
    val b = new TreeNode(_value = 2)
    val a = new TreeNode(_value = 1, _left = b)
    val q = new TreeNode(_value = 1, _right = b)
    assert(!isSameTree(a, q))
  }
}
