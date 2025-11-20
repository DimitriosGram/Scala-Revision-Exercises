object RegularExpressionMatching {

  def isMatch(s: String, p: String): Boolean = {
    val m = s.length
    val n = p.length

    val dp = Array.ofDim[Boolean](m + 1, n + 1)
    dp(0)(0) = true

    for (j <- 2 to n if p(j - 1) == '*')
      dp(0)(j) = dp(0)(j - 2)

    for (i <- 1 to m; j <- 1 to n) {

      if (p(j - 1) == '.' || p(j - 1) == s(i - 1)) {
        dp(i)(j) = dp(i - 1)(j - 1)

      } else if (p(j - 1) == '*') {
        dp(i)(j) =
          dp(i)(j - 2) ||
            ((p(j - 2) == '.' || p(j - 2) == s(i - 1)) && dp(i - 1)(j))
      }
    }

    dp(m)(n)
  }

  def main(args: Array[String]): Unit = {
    println(isMatch("aa", "a"))         // false
    println(isMatch("aa", "a*"))        // true
    println(isMatch("ab", ".*"))        // true
    println(isMatch("aab", "c*a*b"))    // true
    println(isMatch("mississippi", "mis*is*p*.")) // false
  }
}
