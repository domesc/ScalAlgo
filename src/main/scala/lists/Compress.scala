package lists

/**
  * Eliminate consecutive duplicates of list elements
  * Created by dscarmozzino on 11/22/16.
  */
object Compress {

  def compressRecursive[A](list: List[A]): List[A] = {
    @annotation.tailrec
    def compressInternal(acc: List[A], l: List[A]): List[A] = {
      if(l.isEmpty) {
        acc
      } else {
        acc.lastOption match {
          case None => compressInternal(acc :+ l.head, l.tail)
          case Some(last) =>
            if (last != l.head)
              compressInternal(acc :+ l.head, l.tail)
            else
              compressInternal(acc, l.tail)
        }
      }
    }
    compressInternal(List.empty[A], list)
  }

  def compressRecursive2[A](list: List[A]): List[A] = {
    @annotation.tailrec
    def compressInternal(acc: List[A], l: List[A]): List[A] = l match {
      case Nil =>  acc
      case head :: tail => compressInternal(acc :+ head, tail.dropWhile(_ == head))
    }
    compressInternal(List.empty[A], list)
  }

  def compressFunctional[A](list: List[A]): List[A] = {
    list.foldLeft(List.empty[A]) {
      case (acc, el) => acc.lastOption match {
        case None => acc :+ el
        case Some(last) => if (last != el) acc :+ el else acc
      }
    }
  }

}
