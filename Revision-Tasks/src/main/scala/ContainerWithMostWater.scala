object ContainerWithMostWater {

  def maxArea(height: Array[Int]): Int = {
    var left = 0
    var right = height.length - 1
    var maxA = 0

    while (left < right) {
      val h = Math.min(height(left), height(right))
      val w = right - left
      maxA = Math.max(maxA, h * w)

      if (height(left) < height(right)) left += 1
      else right -= 1
    }

    maxA
  }

  def main(args: Array[String]): Unit = {
    println(maxArea(Array(1,8,6,2,5,4,8,3,7)))  // 49
    println(maxArea(Array(1,1)))                // 1
    println(maxArea(Array(4,3,2,1,4)))          // 16
    println(maxArea(Array(1,2,1)))              // 2
  }
}
