package maak.leetcode.problems.algorithms

object E_TIQ_String {
  /* Write a function that reverses a string. The input string is given as an array of characters char[]. Do not
  allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra
  memory. */
  def reverseString(s: Array[Char]): Unit = {
    for(i <- 0 until s.length/2) {
      val tmpChar = s(i)
      s(i) = s(s.length-1-i)
      s(s.length-1-i) = tmpChar
    }
  }

  /* Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
   */
  def firstUniqChar(s: String): Int = {
    var found = false
    var stringLeft = s
    var nextChar: Char = Char.MinValue

    while(stringLeft.nonEmpty && !found) {
      nextChar = stringLeft.head
      if(stringLeft.tail.contains(nextChar)) {
        stringLeft = stringLeft.filterNot(_ == nextChar)
      } else {
        found = true
      }
    }

    if(found) {
      s.indexOf(nextChar)
    } else {
      -1
    }
  }

  /* Implement atoi which converts a string to an integer. */
  def myAtoi(str: String): Int = {
    val trimmedString = str.trim
    if(trimmedString.isEmpty) {
      0
    } else {
      val validChars = Array.range('0'.toInt, '9'.toInt).map(_.toChar)
      var i = 0
      var negative = trimmedString.head == '-'
      var value: Long = 0L
      if(trimmedString.head == '+' || trimmedString.head == '-') {
        i+=1
      }
      while(i < trimmedString.length && trimmedString(i).isDigit && value < Int.MaxValue.toLong) {
        val digit = trimmedString(i).asDigit
        value *= 10L
        value += digit.toLong
        i += 1
      }
      if(negative) {
        math.max(-value, Int.MinValue.toLong).toInt
      } else {
        math.min(value, Int.MaxValue.toLong).toInt
      }
    }
  }
}
