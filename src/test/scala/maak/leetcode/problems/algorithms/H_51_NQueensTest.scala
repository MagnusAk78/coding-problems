package maak.leetcode.problems.algorithms

class H_51_NQueensTest extends org.scalatest.FlatSpec {
  import H_51_NQueens._

  "solveNQueens" should "return 0 distinct solutions for input 0" in {
    val result = solveNQueens(0)
    assert(result.isEmpty)
  }

  "solveNQueens" should "return 1 distinct solutions for input 1" in {
    val result = solveNQueens(1)
    assert(result.length == 1)
    assert(testNQueens(result(0)))
  }

  "solveNQueens" should "return 0 distinct solutions for input 2" in {
    val result = solveNQueens(2)
    assert(result.isEmpty)
  }

  "solveNQueens" should "return 0 distinct solutions for input 3" in {
    val result = solveNQueens(3)
    assert(result.isEmpty)
  }

  "solveNQueens" should "return 2 distinct solutions for input 4" in {
    val result = solveNQueens(4)
    assert(result.length == 2)
    assert(result(0) != result(1))
    assert(testNQueens(result(0)))
    assert(testNQueens(result(1)))
  }

  "solveNQueens" should "return 41 distinct solutions for input 7" in {
    val result = solveNQueens(7)
    assert(result.length == 40)
  }

  "solveNQueens" should "return a specific solution solutions for input 8" in {
    val result = solveNQueens(8)
    //assert(result.length == 4)
    assert(result.contains(List(
      "...Q....",
      "......Q.",
      "..Q.....",
      ".......Q",
      ".Q......",
      "....Q...",
      "Q.......",
      ".....Q.."
    )))
  }

    "solveNQueens" should "return 0 solutions for input 9" in {
      val result = solveNQueens(9)
      assert(result.length == 352)
      assert(result.contains(List(
        "Q........",
        "..Q......",
        ".....Q...",
        ".......Q.",
        ".Q.......",
        "...Q.....",
        "........Q",
        "......Q..",
        "....Q...."
      )))
      assert(result.contains(List(
        ".Q.......",
        "...Q.....",
        ".......Q.",
        "..Q......",
        "........Q",
        ".....Q...",
        "Q........",
        "....Q....",
        "......Q.."
      )))
    }
}

