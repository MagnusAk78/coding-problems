package maak.leetcode.problems.algorithms

import scala.annotation.tailrec

/*
Minimum Number of Taps to Open to Water a Garden

There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n.
(i.e The length of the garden is n).

There are n + 1 taps located at points [0, 1, ..., n] in the garden. Given an integer n and an integer array ranges
of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if
it was open. Return the minimum number of taps that should be open to water the whole garden, if the garden cannot
be watered return -1.

Constraints:
1 <= n <= 10^4
ranges.length == n + 1
0 <= ranges[i] <= 100
 */
object H_1326_GardenTaps {

  case class Tap(pos: Int, min: Int, max: Int) extends Ordered[Tap] {
    def compare(that: Tap): Int = {
      if (this.min != that.min) {
        this.min - that.min
      } else {
        that.size - this.size
      }
    }

    lazy val size = max - min
  }

  case class Garden(min: Int, max: Int) {
    lazy val size = max - min
  }

  def waterGarden(garden: Garden, tap: Tap): Option[Garden] = {
    if (garden.min < tap.min) {
      None
    } else {
      if (garden.max <= tap.max) {
        Some(Garden(0, 0))
      } else {
        Some(Garden(math.max(garden.min, tap.max), garden.max))
      }
    }
  }

  def minTaps(n: Int, ranges: Array[Int]): Int = {
    var garden = Garden(0, n)
    var taps = Array.range(0, n + 1).map(tap => Tap(tap, math.max(0, tap - ranges(tap)), tap + ranges(tap))).
      filter(_.size > 0).sorted
    var abort = false
    var tapsUsed = 0
    while (taps.nonEmpty && garden.size > 0 && !abort) {
      var max = Int.MinValue
      taps.foreach(tap => if (tap.min <= garden.min && tap.max > max) max = tap.max)

      taps.find(tap => tap.min <= garden.min && tap.max == max) match {
        case None => abort = true
        case Some(tap) => {
          waterGarden(garden, tap) match {
            case None => abort = true
            case Some(newGarden) => {
              if (garden.size != newGarden.size) {
                tapsUsed += 1
                garden = newGarden
                taps = taps.filter(_.max > garden.min)
              }
            }
          }
        }
      }
    }
    if (garden.size == 0) {
      tapsUsed
    } else {
      -1
    }
  }
}
