object ValidParentheses {

  def isValid(s: String): Boolean = {
    val stack = scala.collection.mutable.Stack[Char]()
    val pairs = Map(')' -> '(', ']' -> '[', '}' -> '{')

    for (c <- s) {
      if (pairs.contains(c)) {
        if (stack.isEmpty || stack.pop() != pairs(c)) return false
      } else {
        stack.push(c)
      }
    }

    stack.isEmpty
  }

  def main(args: Array[String]): Unit = {
    println(isValid("()"))        // true
    println(isValid("()[]{}"))    // true
    println(isValid("(]"))        // false
    println(isValid("([)]"))      // false
    println(isValid("{[]}"))      // true
  }
}
