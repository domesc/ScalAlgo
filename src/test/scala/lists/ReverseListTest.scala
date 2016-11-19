package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 19/11/16.
  */
class ReverseListTest extends FlatSpec with Matchers {

  "reverseListNonFunctional" should "reverse correctly an empty list" in {
    val emptyList = List()

    val reversed = ReverseList.reverseListNonFunctional(emptyList)

    reversed shouldEqual emptyList
  }

  "reverseListNonFunctional" should "reverse correctly a non empty list" in {
    val emptyList = List(1, 2, 3, 4, 6)

    val reversed = ReverseList.reverseListNonFunctional(emptyList)

    reversed shouldEqual List(6, 4, 3, 2, 1)
  }

  "reverseListRecursive" should "reverse correctly an empty list" in {
    val emptyList = List()

    val reversed = ReverseList.reverseListRecursive(emptyList)

    reversed shouldEqual emptyList
  }

  "reverseListRecursive" should "reverse correctly a non empty list" in {
    val emptyList = List(1, 2, 3, 4, 6)

    val reversed = ReverseList.reverseListRecursive(emptyList)

    reversed shouldEqual List(6, 4, 3, 2, 1)
  }

  "reverseListBuiltIn" should "reverse correctly an empty list" in {
    val emptyList = List()

    val reversed = ReverseList.reverseListBuiltIn(emptyList)

    reversed shouldEqual emptyList
  }

  "reverseListBuiltIn" should "reverse correctly a non empty list" in {
    val emptyList = List(1, 2, 3, 4, 6)

    val reversed = ReverseList.reverseListBuiltIn(emptyList)

    reversed shouldEqual List(6, 4, 3, 2, 1)
  }

  "reverseListFunctional" should "reverse correctly an empty list" in {
    val emptyList = List()

    val reversed = ReverseList.reverseListFunctional(emptyList)

    reversed shouldEqual emptyList
  }

  "reverseListFunctional" should "reverse correctly a non empty list" in {
    val emptyList = List(1, 2, 3, 4, 6)

    val reversed = ReverseList.reverseListFunctional(emptyList)

    reversed shouldEqual List(6, 4, 3, 2, 1)
  }

}
