object SlidingWindow {

  def lengthOfLongestSubstring(s: String): Int = {
    val seen = scala.collection.mutable.Map[Char, Int]()
    var left = 0
    var maxLen = 0

    for (right <- s.indices) {
      val c = s(right)

      if (seen.contains(c) && seen(c) >= left) {
        left = seen(c) + 1
      }

      seen(c) = right
      maxLen = Math.max(maxLen, right - left + 1)
    }

    maxLen
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
  }
}
