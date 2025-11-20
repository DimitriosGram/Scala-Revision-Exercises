object ReverseInteger {

  def reverse(x: Int): Int = {
    var num = x
    var rev = 0

    while (num != 0) {
      val pop = num % 10
      num /= 10

      if (rev > Int.MaxValue / 10 || rev < Int.MinValue / 10) return 0

      rev = rev * 10 + pop
    }

    rev
  }
  def main(args: Array[String]): Unit = {
    println(reverse(123))
    println(reverse(-123))
    println(reverse(120))

  }
}
