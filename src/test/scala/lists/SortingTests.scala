package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 21/10/17.
  */
class SortingTests extends FlatSpec with Matchers {

  behavior of "Sorting"

  it should "sort the lists by length" in {
    val l = List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))
    val result = List(1, 2, 2, 2, 3, 3, 4)

    Sorting.sortByLength(l).map(_.length) shouldEqual result
    Sorting.sortByLength1(l).map(_.length) shouldEqual result
    Sorting.sortByLength2(l).map(_.length) shouldEqual result
    Sorting.sortByLength3(l).map(_.length) shouldEqual result
  }

}
