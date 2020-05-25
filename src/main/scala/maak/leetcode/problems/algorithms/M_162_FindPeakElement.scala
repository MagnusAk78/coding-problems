package maak.leetcode.problems.algorithms

/*
A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
Note: Your solution should be in logarithmic complexity.
 */
object M_162_FindPeakElement {

  sealed abstract class BinaryTree {
    def getMax(compareTuple: (Int, Int)): (Int, Int) = compareTuple
  }

  case object EmptyNode extends BinaryTree

  case class BinaryNode(index: Int, value: Int, left: BinaryTree = EmptyNode, right: BinaryTree = EmptyNode)
    extends BinaryTree {
    override def getMax(compareTuple: (Int, Int)): (Int, Int) = {
      right.getMax(
        left.getMax(if (value > compareTuple._2 || compareTuple._2 == Int.MinValue) (index, value) else compareTuple))
    }
  }

  def findPeakElement(nums: Array[Int]): Int = {

    def arrayToBinaryTree(nums: Array[Int], indexStart: Int): BinaryTree = {
      if (nums.size > 3) {
        val i = nums.size / 2
        val arrayTuple = nums.splitAt(i)
        BinaryNode(indexStart + i, nums(i),
          left = arrayToBinaryTree(arrayTuple._1, indexStart),
          right = arrayToBinaryTree(arrayTuple._2.drop(1), indexStart + i + 1))
      } else if (nums.size == 3) {
        BinaryNode(indexStart + 1, nums(1),
          left = BinaryNode(indexStart, nums(0)),
          right = BinaryNode(indexStart + 2, nums(2)))
      } else if (nums.size == 2) {
        BinaryNode(indexStart, nums(0),
          left = EmptyNode,
          right = BinaryNode(indexStart + 1, nums(1)))
      } else if (nums.size == 1) {
        BinaryNode(indexStart + 0, nums(0))
      } else {
        EmptyNode
      }
    }

    val binTree = arrayToBinaryTree(nums, 0)
    binTree.getMax((-1, Int.MinValue))._1
  }
}
