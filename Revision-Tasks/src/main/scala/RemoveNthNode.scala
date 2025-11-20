object RemoveNthNode {

  class ListNode(var x: Int = 0) {
    var next: ListNode = null
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val dummy = new ListNode(0)
    dummy.next = head

    var fast = dummy
    var slow = dummy

    // Move fast n+1 steps
    for (_ <- 0 to n) {
      fast = fast.next
    }

    // Move both until fast reaches end
    while (fast != null) {
      fast = fast.next
      slow = slow.next
    }

    // Remove the node
    slow.next = slow.next.next

    dummy.next
  }

  // Helper to build a list from Array
  def buildList(arr: Array[Int]): ListNode = {
    val dummy = new ListNode(0)
    var curr = dummy
    for (x <- arr) {
      curr.next = new ListNode(x)
      curr = curr.next
    }
    dummy.next
  }

  // Helper to print list
  def toList(head: ListNode): List[Int] = {
    var curr = head
    val buff = scala.collection.mutable.ListBuffer[Int]()
    while (curr != null) {
      buff += curr.x
      curr = curr.next
    }
    buff.toList
  }

  def main(args: Array[String]): Unit = {
    val ex1 = removeNthFromEnd(buildList(Array(1,2,3,4,5)), 2)
    println(toList(ex1))    // [1,2,3,5]

    val ex2 = removeNthFromEnd(buildList(Array(1)), 1)
    println(toList(ex2))    // []

    val ex3 = removeNthFromEnd(buildList(Array(1,2)), 1)
    println(toList(ex3))    // [1]
  }
}
