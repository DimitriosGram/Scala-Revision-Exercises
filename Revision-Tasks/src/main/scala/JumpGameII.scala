object JumpGameII {

  def jump(nums: Array[Int]): Int = {
    var jumps = 0
    var currentEnd = 0
    var farthest = 0

    for (i <- 0 until nums.length - 1) {
      farthest = Math.max(farthest, i + nums(i))

      if (i == currentEnd) {
        jumps += 1
        currentEnd = farthest
      }
    }

    jumps
  }

  def main(args: Array[String]): Unit = {
    println(jump(Array(2,3,1,1,4)))  // 2
    println(jump(Array(2,3,0,1,4)))  // 2
  }
}
