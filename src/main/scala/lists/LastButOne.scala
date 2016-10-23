package lists

/**
  * Created by domesc on 23/10/16.
  */
object LastButOne {

  @annotation.tailrec
  def find[A](list: List[A]): Option[A] = list match {
    case x::_::Nil => Option(x)
    case _::tail => find(tail)
    case _ => None
  }

  def findBuiltIn[A](list: List[A]): Option[A] = {
    if (list.isEmpty) {
      None
    } else {
      list.init.lastOption
    }
  }

  def findLastNthElement[A](list: List[A], n: Int): Option[A] = {
    def findLastRec(list: List[A], n: Int): Option[A] = {
      if (list.isEmpty) {
        None
      } else {
        (n, list) match {
          case (nth, head::tail) if nth == 0 => Option(head)
          case (nth, head::tail) if nth > 0 => findLastRec(tail, n-1)
        }
      }
    }

    if (list.size < n) None
    else findLastRec(list, list.size - n)
  }

}
