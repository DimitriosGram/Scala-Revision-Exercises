object PalindromeNumber {

  def isPalindrome(x: Int): Boolean = {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false

    var num = x
    var rev = 0

    while (num > rev) {
      rev = rev * 10 + num % 10
      num /= 10
    }

    num == rev || num == rev / 10
  }

  def main(args: Array[String]): Unit = {
    println(isPalindrome(121))    // true
    println(isPalindrome(-121))   // false
    println(isPalindrome(10))     // false
    println(isPalindrome(-101))   // false
  }
}
