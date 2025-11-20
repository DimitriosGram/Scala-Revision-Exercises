object ZigZagConversion {

  def convert(s: String, numRows: Int): String = {
    if (numRows == 1 || s.length <= numRows) return s

    val rows = Array.fill(numRows)(new StringBuilder)
    var currRow = 0
    var goingDown = false

    for (c <- s) {
      rows(currRow).append(c)

      if (currRow == 0 || currRow == numRows - 1)
        goingDown = !goingDown

      currRow += (if (goingDown) 1 else -1)
    }

    rows.mkString
  }

  def main(args: Array[String]): Unit = {
    println(convert("PAYPALISHIRING", 3))
    println(convert("PAYPALISHIRING", 4))
    println(convert("A", 1))
  }
}
