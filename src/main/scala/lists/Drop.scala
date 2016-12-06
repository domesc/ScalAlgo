package lists

/**
  * Drop every Nth element from a list
  * Created by dscarmozzino on 12/6/16.
  */
object Drop {

  def drop[A](n: Int, list: List[A]): List[A] = {
    list.foldLeft((1, List.empty[A])) {
      case ((counter, acc), element)=>
        if(counter % n == 0)
          (counter + 1,acc)
        else {
          (counter + 1, acc :+ element)
        }
    }._2
  }

  def dropBuiltIn[A](n: Int, list: List[A]): List[A] = list.zip(Stream from 1).filter{ case (e, i) => i % n != 0}.map(e => e._1)

}
