package maak.leetcode.problems.algorithms

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each
other. Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
queen and an empty space respectively.
*/
object H_51_NQueens {

  import scala.annotation.tailrec

  val FREE = '.'
  val QUEEN = 'Q'

  def testNQueens(board: List[String]): Boolean = countQueens(board) == board.length && noAttacks(board)

  def countQueens(board: List[String]): Int = board.map(row => row.count(_ == QUEEN)).sum

  // Test if there are no attacks between the queens
  def noAttacks(board: List[String]): Boolean = {
    var columns: List[Int] = List()
    var row = 0
    var valid = true
    while (row < board.length && valid) {
      // Check row
      if (board(row).filter(_ == QUEEN).length > 1) {
        valid = false
      }

      // Check column
      val queenIndex = board(row).indexOf(QUEEN)
      if (queenIndex == -1 || columns.contains(queenIndex)) {
        valid = false
      }

      // Check diagonal
      var otherRow = 0
      while (otherRow < board.length && valid) {
        val diff = math.abs(otherRow - row)
        if (diff > 0) {
          if (queenIndex - diff > 0 && board(otherRow)(queenIndex - diff) == QUEEN) {
            valid = false
          }
          if (queenIndex + diff < board(otherRow).length && board(otherRow)(queenIndex + diff) == QUEEN) {
            valid = false
          }
        }
        otherRow += 1
      }

      // Add column
      columns = queenIndex :: columns
      // next row
      row += 1
    }
    valid
  }

  def createRowWithQueen(n: Int, column: Int): String = {
    FREE.toString * column + QUEEN + FREE.toString * (n - 1 - column)
  }

  def createSolutions(n: Int): List[List[String]] = {
    @tailrec
    def createSolutionsInt(n: Int, boardsToTest: List[List[String]],
                           solutions: List[List[String]]): List[List[String]] = {
      boardsToTest match {
        case Nil => solutions // No more to test, return the accumulated results
        case board :: theRest => {
          // Create all valid possible new rows => max n rows but probably much fewer
          val moreToTest = List.range(0, n).map(col => createRowWithQueen(n, col)).map(_ :: board).filter(noAttacks)
          if(board.length == n - 1) {
            // This was the last row, add to solutions
            createSolutionsInt(n, theRest, moreToTest ::: solutions)
          } else {
            // This was not the last row, add to 'boards to test'
            createSolutionsInt(n, moreToTest ::: theRest, solutions)
          }
        }
      }
    }

    if(n == 1) {
      // Special case, just one square with a queen on it
      List(List(createRowWithQueen(n, 0)))
    } else {
      // Create a list of all possible first rows => a queen on every column
      val startList = List.range(0, n).map(col => List(createRowWithQueen(n, col)))
      createSolutionsInt(n, startList, List())
    }
  }

  def solveNQueens(n: Int): List[List[String]] = n match {
    case 0 => List()
    case _ => createSolutions(n)
  }
}
