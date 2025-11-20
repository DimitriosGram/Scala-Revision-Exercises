object ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    scala.util.Sorting.quickSort(nums)
    val result = scala.collection.mutable.ListBuffer[List[Int]]()

    for (i <- nums.indices) {
      if (i == 0 || nums(i) != nums(i - 1)) {
        var left = i + 1
        var right = nums.length - 1

        while (left < right) {
          val sum = nums(i) + nums(left) + nums(right)

          if (sum == 0) {
            result += List(nums(i), nums(left), nums(right))
            left += 1
            right -= 1

            while (left < right && nums(left) == nums(left - 1)) left += 1
            while (left < right && nums(right) == nums(right + 1)) right -= 1
          }
          else if (sum < 0) left += 1
          else right -= 1
        }
      }
    }

    result.toList
  }

  def main(args: Array[String]): Unit = {
    println(threeSum(Array(-1,0,1,2,-1,-4)))
    println(threeSum(Array()))
    println(threeSum(Array(0)))
  }
}
  