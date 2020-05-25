package maak.leetcode.problems.algorithms

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:
* Each child must have at least one candy.
* Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?
 */
object H_135_Candy {

  import scala.collection.mutable.ListBuffer

  def candy(ratings: Array[Int]): Int = {
    /* Folding into a list (or a list buffer) its possible to look at the previous values during iteration, this
    looks very similar to a recursive solution. A while loop would be more efficient here but I wanted to solve this
    in a more functional style. */
    ratings.zipWithIndex.foldLeft(ListBuffer.empty[(Int, Int, Int, Int, Int)]) {
      (buffer, valueWithIndex) => {
        buffer.lastOption match {
          case None => {
            buffer.append((valueWithIndex._1, valueWithIndex._2, valueWithIndex._2, 0, 1))
          }
          case Some((previous, minIndex, maxIndex, peak, _)) => {
            val newMinIndex = if (valueWithIndex._1 <= previous) valueWithIndex._2 else minIndex
            val newMaxIndex = if (valueWithIndex._1 >= previous) valueWithIndex._2 else maxIndex
            val newPeak = if (valueWithIndex._1 >= previous) valueWithIndex._2 - newMinIndex + 1 else peak

            val candies = if (valueWithIndex._1 >= previous) {
              valueWithIndex._2 - newMinIndex + 1
            } else {
              if (newPeak > (valueWithIndex._2 - newMaxIndex)) {
                valueWithIndex._2 - newMaxIndex
              } else {
                valueWithIndex._2 - newMaxIndex + 1
              }
            }
            //This shows the what the resulting list buffer looks like. It's the fifth value 'candies' that is the
            //important one.
            buffer.append((valueWithIndex._1, newMinIndex, newMaxIndex, newPeak, candies))
          }
        }
      }
    }.map(_._5).sum //Map to only the fifth value and return the sum (again, this is not very efficient)
  }
}
