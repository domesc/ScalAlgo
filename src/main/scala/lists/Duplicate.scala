package lists

/**
  * Duplicate the elements of a list
  */
object Duplicate {
  def dup[A](list: List[A]): List[A] = {
    list.foldLeft(List.empty[A]) {
      case (acc, element) => acc :+ element :+ element
    }
  }

  def dup2[A](list: List[A]): List[A] = list.flatMap(e => List(e, e))

  def dupTimes[A](list: List[A], times: Int): List[A] = list.flatMap(e => List.fill(times)(e))

}
