package lists

/**
  * Encode list with (number, element)
  * Created by dscarmozzino on 11/22/16.
  */
object RunLength {
  def encode[A](list: List[A]): List[(Int, A)] = {
    val packed = Pack.pack(list)
    packed.foldLeft(List.empty[(Int, A)]) {
      case (acc, element) => acc :+ (element.size, element.head)
    }
  }

  def encodeModified[A](list: List[A]): List[Any] = {
    val packed = Pack.pack(list)
    packed.foldLeft(List.empty[Any]) {
      case (acc, element) => acc :+ (if(element.size == 1) element.head else (element.size, element.head))
    }
  }

  def encode2[A](list: List[A]): List[(Int, A)] = {
    if(list.isEmpty) List.empty
    else {
      val previous = list.head
      val result = list.tail.foldLeft((1, previous, List.empty[(Int, A)])) {
        case ((counter, previous, acc), element) =>
          if (element != previous) {
            val oldCounter = counter
            val oldPrevious = previous
            (1, element, acc :+ (oldCounter, oldPrevious))
          } else {
            val newCounter = counter + 1
            (newCounter, previous, acc)
          }
      }

      result._3 :+ (result._1, list.last)
    }
  }

  def encodedirectly[A](list: List[A]): List[(Int, A)] = {
    if(list.isEmpty) {
      List.empty
    } else {
      val (packed, rest) = list.span(_ == list.head)
      (packed.size, packed.head) :: encodedirectly(rest)
    }
  }
}
