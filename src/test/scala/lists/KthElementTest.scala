package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 23/10/16.
  */
class KthElementTest extends FlatSpec with Matchers {
  behavior of "KthElement"

  it should "find nth element in a non empty list" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val last = KthElement.find(list, 3)
    last shouldEqual Some(3)
  }

  it should "find nth element in a empty list" in {
    val list = List()
    val last = KthElement.find(list, 5)
    last shouldEqual None
  }

  it should "find nth element in a non empty list with standard library" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val last = KthElement.findBuiltInt(list, 2)
    last shouldEqual Some(2)
  }

  it should "find nth element in a empty list with standard library" in {
    val list = List()
    val last = KthElement.findBuiltInt(list, 2)
    last shouldEqual None
  }

  it should "find nth element in a non empty list with pattern matching" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val last = KthElement.findPatternMatching(list, 2)
    last shouldEqual Some(2)
  }

  it should "find nth element in a empty list with pattern matching" in {
    val list = List()
    val last = KthElement.findPatternMatching(list, 2)
    last shouldEqual None
  }

}
