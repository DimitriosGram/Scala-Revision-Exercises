object StringToIntAtoi {

  def myAtoi(s: String): Int = {
    if (s.isEmpty) return 0

    val n = s.length
    var i = 0

    while (i < n && s(i) == ' ') i += 1
    if (i >= n) return 0

    var sign = 1
    if (s(i) == '+') { i += 1 }
    else if (s(i) == '-') { sign = -1; i += 1 }

    var result = 0

    while (i < n && s(i).isDigit) {
      val digit = s(i) - '0'

      if (result > Int.MaxValue / 10 ||
        (result == Int.MaxValue / 10 && digit > 7))
        return if (sign == 1) Int.MaxValue else Int.MinValue

      result = result * 10 + digit
      i += 1
    }

    result * sign
  }

  def main(args: Array[String]): Unit = {
    println(myAtoi("42"))
    println(myAtoi("   -42"))
    println(myAtoi("4193 with words"))
    println(myAtoi("words and 987"))
  }
}
