package lists

/**
  * Rotate a list N places to the left.
  * Created by domesc on 21/10/17.
  */
object Rotate {

  def rotate[A](n: Int, l: List[A]): List[A] = {
    if(n <= l.length) {
      l.takeRight(l.length - n) ::: l.take(n)
    } else {
      throw new IllegalArgumentException("n is bigger than the length of the list")
    }
  }

  def rotateFold[A](n: Int, l: List[A]): List[A] = {
    def rotateInternal: List[A] = {
      val (right, left) = (0 until l.length).zip(l).foldLeft((List.empty[A], List.empty[A])) { case ((right, left), (i, element)) =>
        i match {
          case index if (index < n) => (right :+ element, left)
          case _ => (right, left :+ element)
        }
      }

      left ::: right
    }

    if(n > l.length) {
      throw new IllegalArgumentException("n is bigger than the length of the list")
    } else {
      rotateInternal
    }
  }

}
