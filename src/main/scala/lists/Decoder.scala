package lists

/**
  * Created by dscarmozzino on 12/5/16.
  */
object Decoder {

  def decode[A](list: List[(Int, A)]): List[A] = {
    list.foldLeft(List.empty[A]) {
      case (acc, element) => acc ::: List.fill(element._1)(element._2)
    }
  }

}
