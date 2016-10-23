package lists

/**
  * Created by domesc on 23/10/16.
  */
object LastElement {

  @annotation.tailrec
  def find[A](list: List[A]): Option[A] = list match {
    case Nil => None
    case head::Nil => Option(head)
    case head:: tail => find(tail)
  }

  def findBuiltInt[A](list: List[A]): Option[A] = list.lastOption
}
