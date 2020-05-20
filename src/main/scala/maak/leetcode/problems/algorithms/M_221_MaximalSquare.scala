package maak.leetcode.problems.algorithms

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
object M_221_MaximalSquare {

  final val zero = '0'
  final val one = '1'

  // Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
  def maximalSquare(matrix: Array[Array[Char]]): Int = {

    // Does this position start a square of ones with 'at least' the specific size of side * side
    def squareOnesExists(matrix: Array[Array[Char]], row: Int, column: Int, side: Int): Boolean = {
      matrix(row)(column) match {
        case '1' => {
          if(matrix.length < row + side) {
            false
          } else {
            var nonOneFound = false
            var y = 0
            while(!nonOneFound && y < side) {
              if(matrix(row + y).drop(column).takeWhile(_ == one).length < side) {
                nonOneFound = true
              }
              y += 1
            }
            !nonOneFound
          }
        }
        case _ => false
      }
    }

    // Return size of the 'one' square starting at specific row and column
    def sizeSquareOnes(matrix: Array[Array[Char]], row: Int, column: Int): Int = matrix(row)(column) match {
      case '1' => {
        var side = 1
        while (squareOnesExists(matrix, row, column, side + 1)) {
          side += 1
        }
        side * side
      }
      case _ => 0
    }

    var largestSquare = 0
    for(row <- matrix.indices) {
      for(column <- matrix(row).indices) {
        largestSquare = math.max(largestSquare, sizeSquareOnes(matrix, row, column))
      }
    }
    largestSquare
  }
}
