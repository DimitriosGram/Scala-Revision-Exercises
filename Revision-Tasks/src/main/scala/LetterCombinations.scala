object LetterCombinations {

  val phone: Map[Char, String] = Map(
    '2' -> "abc",
    '3' -> "def",
    '4' -> "ghi",
    '5' -> "jkl",
    '6' -> "mno",
    '7' -> "pqrs",
    '8' -> "tuv",
    '9' -> "wxyz"
  )

  def letterCombinations(digits: String): List[String] = {
    if (digits.isEmpty) return List()

    val result = scala.collection.mutable.ListBuffer[String]()

    def backtrack(index: Int, path: StringBuilder): Unit = {
      if (index == digits.length) {
        result += path.toString()
        return
      }

      for (ch <- phone(digits(index))) {
        path.append(ch)
        backtrack(index + 1, path)
        path.deleteCharAt(path.length - 1)
      }
    }

    backtrack(0, new StringBuilder)
    result.toList
  }

  def main(args: Array[String]): Unit = {
    println(letterCombinations("23"))
    println(letterCombinations(""))
    println(letterCombinations("2"))
  }
}
