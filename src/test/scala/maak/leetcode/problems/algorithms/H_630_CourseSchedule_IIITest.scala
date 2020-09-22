package maak.leetcode.problems.algorithms

class H_630_CourseSchedule_IIITest extends org.scalatest.FlatSpec {
  import H_630_CourseSchedule_III._

  "scheduleCourse" should "return 0 for input []" in {
    assert(scheduleCourse(Array()) == 0)
  }

  "scheduleCourse" should "return 2 for input [[1, 2], [2, 3]]" in {
    assert(scheduleCourse(Array(Array(1, 2), Array(2, 3))) == 2)
  }

  "scheduleCourse" should "return 3 for input [[9,14],[7,12],[1,11],[4,7]]" in {
    assert(scheduleCourse(Array(Array(9,14), Array(7,12), Array(1, 11), Array(4, 7))) == 3)
  }

  "scheduleCourse" should "return 3 for input [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]" in {
    assert(scheduleCourse(Array(Array(100, 200), Array(200, 1300), Array(1000, 1250), Array(2000, 3200))) == 3)
  }
}
