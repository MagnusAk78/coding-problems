package maak.leetcode.problems.algorithms


/*
A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y). Given a starting
point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform
the point (sx, sy) to (tx, ty). Otherwise, return False.

sx, sy, tx, ty will all be integers in the range [1, 10^9].
 */
object H_780_ReachingPoints {

  case class Pos(x:Int, y: Int) {
    def fromClosestTo(pos: Pos): Option[Pos] = {
      if(this == pos) {
        Some(this.copy())
      } else if(pos.x > x || pos.y > y) {
        None
      } else {
        val diffX = x - pos.x
        val diffY = y - pos.y
        if(diffX > diffY) {
          val n = diffX / y
          val newPos = Pos(x - n * y, y)
          if(newPos != this) {
            Some(newPos)
          } else {
            None
          }
        } else {
          val n = diffY / x
          val newPos = Pos(x, y - n * x)
          if(newPos != this) {
            Some(newPos)
          } else {
            None
          }
        }
      }
    }
  }

  def reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean = {
    val start = Pos(sx, sy)
    val target = Pos(tx, ty)
    var from = target.fromClosestTo(start)
    while (from.nonEmpty && from.get != start) {
      from = from.get.fromClosestTo(start)
    }
    from.nonEmpty && from.get == start
  }
}
