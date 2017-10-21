package lists

import scala.collection.mutable
import scala.collection.mutable.PriorityQueue

/**
  * Sorting a list of lists according to length of sublists.
  * Created by domesc on 21/10/17.
  */
object Sorting {

  /**
    * We suppose that a list contains elements that are lists themselves. The objective is to sort the elements of the
    * list according to their length. E.g. short lists first, longer lists later, or vice versa.
    */
  def sortByLength[A](l: List[List[A]]): List[List[A]] = {
    implicit def orderingByLength: Ordering[List[A]] = Ordering.by(e => e.length)
    l.sorted
  }

  def sortByLength1[A](l: List[List[A]]): List[List[A]] = {
    l.map(el => (el, el.length)).sortBy(_._2).map(_._1)
  }

  def sortByLength2[A](l: List[List[A]]): IndexedSeq[List[A]] = {
    implicit def orderingByLength: Ordering[(List[A], Int)] = Ordering.by(e => -e._2)

    val heap = new mutable.PriorityQueue[(List[A], Int)]()
    l.foreach(subList => heap.enqueue((subList, subList.length)))

    heap.dequeueAll.map(_._1)

  }

  /** Not really better or simpler just to explore mutable Maps in scala */
  def sortByLength3[A](l: List[List[A]]): List[List[A]] = {
    val freqMap = mutable.Map[Int, List[List[A]]]()
    l.foreach {
      subList =>
        val value = freqMap.get(subList.length)
        value match {
          case Some(v) =>
            val newValue = v :+ subList
            freqMap += (subList.length -> newValue)
          case None => freqMap += (subList.length -> List(subList))
        }
    }
    freqMap.toList.sortBy(_._1).foldLeft(List.empty[List[A]]){case (acc, el) => acc ++ el._2}
  }
}
