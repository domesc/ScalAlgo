package lists

/**
  * Flatten a nested list structure
  *
  * Created by domesc on 19/11/16.
  */
object Flatten {

  def flattenRecursive(list: List[Any]): List[Any] = list match {
    case (head: List[_]) :: tail => flattenRecursive(head) ::: flattenRecursive(tail)
    case head :: tail => head :: flattenRecursive(tail)
    case _ => Nil
  }

}
