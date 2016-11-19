package lists

/**
  * Reverse a list
  */
object ReverseList {

  def reverseListRecursive[A](list: List[A]): List[A] = {
    @annotation.tailrec
    def reverseRec(l: List[A], acc: List[A]): List[A] = l match {
      case Nil => acc
      case x :: xs => reverseRec(xs, x +: acc)
    }

    reverseRec(list, Nil)
  }

  def reverseListNonFunctional[A](list: List[A]): List[A] = {
    var result = List.empty[A]
    list.foreach(el => {
      result = el +: result
    })

    result
  }

  def reverseListBuiltIn[A](list: List[A]): List[A] = list.reverse

  def reverseListFunctional[A](list: List[A]): List[A] = list.foldLeft(List.empty[A])((acc, el) => el +: acc)
}
