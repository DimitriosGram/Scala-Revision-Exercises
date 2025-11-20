object TwoSum {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = scala.collection.mutable.Map[Int, Int]()

    for (i <- nums.indices) {
      val needed = target - nums(i)
      if (map.contains(needed)) {
        return Array(map(needed), i)
      }
      map(nums(i)) = i
    }

    Array()
  }

  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2,7,11,15), 9).toList)
    println(twoSum(Array(3,2,4), 6).toList)
    println(twoSum(Array(3,3), 6).toList)
  }
}
