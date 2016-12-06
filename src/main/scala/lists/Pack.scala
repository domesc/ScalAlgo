package lists

/**
  * Pack consecutive duplicates of list elements into sublists.
  * Created by dscarmozzino on 11/22/16.
  */
object Pack {

  def pack[A](list: List[A]): List[List[A]] = {
    if(list.isEmpty) {
      List(List())
    } else {
      val (packed, rest) = list.span(_ == list.head)
      rest match {
        case Nil => List(packed)
        case _ => packed :: pack(rest)
      }
    }
  }

  def packFunctional[A](list: List[A]): List[List[A]] = {
    list.foldLeft(List.empty[List[A]]) {
      case (acc: List[List[A]], element) => acc.lastOption match {
        case None => List(List(element))
        case Some(l) =>
          if(l.head == element) {
            val newList = acc.last :+ element
            acc.dropRight(1) :+ newList
          } else {
            acc :+ List(element)
          }
      }
    }
  }

}
