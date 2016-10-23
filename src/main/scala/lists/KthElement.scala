package lists

/**
  * Created by domesc on 23/10/16.
  */
object KthElement {

  def find[A](list: List[A], k: Int): Option[A] = {
    @annotation.tailrec
    def findRec(list: List[A], k: Int): Option[A] = {
      if (k == 0) {
        list.headOption
      } else {
        findRec(list.tail, k - 1)
      }
    }

    if (list.isEmpty || list.size < k) {
      None
    } else {
      findRec(list, k)
    }
  }

  def findBuiltInt[A](list: List[A], k: Int): Option[A] = {
    if (list.isEmpty) {
      None
    } else {
      Option(list(k))
    }
  }

  @annotation.tailrec
  def findPatternMatching[A](list: List[A], k: Int): Option[A] = (k, list) match {
    case (n, l) if n > l.size  => None
    case (n, head::tail) if n == 0 => Option(head)
    case (n, head::tail) => findPatternMatching(tail, n-1)
  }


}
