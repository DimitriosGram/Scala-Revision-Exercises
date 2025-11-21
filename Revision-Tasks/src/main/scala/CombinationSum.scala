object CombinationSum {

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val result = scala.collection.mutable.ListBuffer[List[Int]]()

    def backtrack(start: Int, remain: Int, combination: List[Int]): Unit = {
      if (remain == 0) {
        result += combination
        return
      }

      if (remain < 0) return

      for (i <- start until candidates.length) {
        backtrack(i, remain - candidates(i), combination :+ candidates(i))
      }
    }

    backtrack(0, target, List())
    result.toList
  }

  def main(args: Array[String]): Unit = {
    println(combinationSum(Array(2,3,6,7), 7))   // [[2,2,3],[7]]
    println(combinationSum(Array(2,3,5), 8))     // [[2,2,2,2],[2,3,3],[3,5]]
    println(combinationSum(Array(2), 1))         // []
    println(combinationSum(Array(1), 1))         // [[1]]
    println(combinationSum(Array(1), 2))         // [[1,1]]
  }
}
