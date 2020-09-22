package maak.leetcode.problems.algorithms

/*
There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on
dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start
at the 1st day.

Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.

Note: The integer 1 <= d, t, n <= 10,000. You can't take two courses simultaneously.
 */
object H_630_CourseSchedule_III {

  import scala.collection.mutable.PriorityQueue

  def scheduleCourse(courses: Array[Array[Int]]): Int = {
    // Sort courses by closing day
    val sortedCourses = courses.sortBy(_(1))

    // The schedule is a PriorityQueue (the priority will be based on course length)
    val schedule = PriorityQueue[Int]()

    var days = 0
    for(course <- sortedCourses) {
      days += course(0)
      // Add the course to the queue
      schedule.enqueue(course(0))

      if(days > course(1)) {
        // If the course was too long, remove the longest course
        days -= schedule.dequeue
      }
    }
    schedule.size
  }
}
