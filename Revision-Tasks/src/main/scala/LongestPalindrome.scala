object LongestPalindrome {

  def longestPalindrome(s: String): String = {
    if (s.length < 2) return s

    var start = 0
    var end = 0

    def expand(left: Int, right: Int): Unit = {
      var l = left
      var r = right

      while (l >= 0 && r < s.length && s(l) == s(r)) {
        l -= 1
        r += 1
      }

      if (r - l - 1 > end - start) {
        start = l + 1
        end = r - 1
      }
    }

    for (i <- s.indices) {
      expand(i, i)
      expand(i, i + 1)
    }

    s.substring(start, end + 1)
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
    println(longestPalindrome("a"))
  }
}
