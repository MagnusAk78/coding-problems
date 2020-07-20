package maak.leetcode.problems.algorithms

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:
* s could be empty and contains only lowercase letters a-z.
* p could be empty and contains only lowercase letters a-z, and characters like . or *.
 */
object H_10_RegularExpressionMatching {

  def isMatch(s: String, p: String): Boolean = {
    def isMatchInt(s: List[Char], p: List[Char]): Boolean = {
      (s, p) match {
        case (Nil, Nil) => true
        case (string, Nil) => false
        case (Nil, ph :: pt) => pt.nonEmpty && pt.head == '*' && isMatchInt(s, pt.drop(1))
        case (sh :: st, ph :: pt) => {
          if(pt.nonEmpty && pt.head == '*') {
            var found = false
            var newString = s
            while (newString.nonEmpty && (newString.head == ph || ph == '.') && !found) {
              newString = newString.tail
              found = isMatchInt(newString, pt.tail)
            }
            found || isMatchInt(s, pt.tail)
          } else if(sh == ph || ph == '.') {
            isMatchInt(st, pt)
          } else {
            false
          }
        }
      }
    }
    isMatchInt(s.toList, p.toList)
  }
}
