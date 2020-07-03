package maak.leetcode.problems.algorithms

class H_10_RegularExpressionMatchingTest extends org.scalatest.FlatSpec {
  import H_10_RegularExpressionMatching.isMatch

  "isMatch" should "return false for input s='aa' and p='a'" in {
    assert(!isMatch("aa", "a"))
  }

  "isMatch" should "return true for input s='aa' and p='.a'" in {
    assert(isMatch("aa", ".a"))
  }

  "isMatch" should "return true for input s='aa' and p='a*'" in {
    assert(isMatch("aa", "a*"))
  }

  "isMatch" should "return true for input s='' and p='c*c*'" in {
    assert(isMatch("", "c*c*"))
  }

  "isMatch" should "return false for input s='ab' and p='.*c" in {
    assert(!isMatch("ab", ".*c"))
  }

  "isMatch" should "return false for input s='a' and p='ab*a" in {
    assert(!isMatch("a", "ab*a"))
  }

  "isMatch" should "return true for input s='aaaaa' and p='a*'" in {
    assert(isMatch("aaaaa", "a*"))
  }

  "isMatch" should "return true for input s='' and p='a*'" in {
    assert(isMatch("", "a*"))
  }

  "isMatch" should "return true for input s='ab' and p='.*'" in {
    assert(isMatch("ab", ".*"))
  }

  "isMatch" should "return true for input s='aab' and p='c*a*b'" in {
    assert(isMatch("aab", "c*a*b"))
  }

  "isMatch" should "return true for input s='mississippi' and p='mi.si.si.pi'" in {
    assert(isMatch("mississippi", "mi.si.si.pi"))
  }

  "isMatch" should "return true for input s='mississippi' and p='mis*is*ip*.'" in {
    assert(isMatch("mississippi", "mis*is*ip*."))
  }

  "isMatch" should "return false for input s='mississippi' and p='mis*is*p*.'" in {
    assert(!isMatch("mississippi", "mis*is*p*."))
  }
}
