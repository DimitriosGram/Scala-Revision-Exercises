object MedianOfTwoSortedArrays {

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val (a, b) = if (nums1.length <= nums2.length) (nums1, nums2) else (nums2, nums1)
    val m = a.length
    val n = b.length

    var left = 0
    var right = m

    while (left <= right) {
      val i = (left + right) / 2
      val j = (m + n + 1) / 2 - i

      val aLeft  = if (i == 0) Int.MinValue else a(i - 1)
      val aRight = if (i == m) Int.MaxValue else a(i)
      val bLeft  = if (j == 0) Int.MinValue else b(j - 1)
      val bRight = if (j == n) Int.MaxValue else b(j)

      if (aLeft <= bRight && bLeft <= aRight) {
        if ((m + n) % 2 == 0)
          return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0
        else
          return Math.max(aLeft, bLeft).toDouble
      }
      else if (aLeft > bRight) right = i - 1
      else left = i + 1
    }

    0.0
  }

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1,3), Array(2)))
    println(findMedianSortedArrays(Array(1,2), Array(3,4)))
  }
}
