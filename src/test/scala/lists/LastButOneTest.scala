package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 23/10/16.
  */
class LastButOneTest extends FlatSpec with Matchers {

  it should "find last but one element in a non empty list" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val last = LastButOne.find(list)
    last shouldEqual Some(5)
  }

  it should "find last but one element in a empty list" in {
    val list = List()
    val last = LastButOne.find(list)
    last shouldEqual None
  }

  it should "find last but one element in a list with one" in {
    val list = List(5)
    val last = LastButOne.find(list)
    last shouldEqual None
  }

  it should "find last but one element in a non empty list with standard library" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val last = LastButOne.findBuiltIn(list)
    last shouldEqual Some(5)
  }

  it should "find last element in a empty list with standard library" in {
    val list = List()
    val last = LastButOne.findBuiltIn(list)
    last shouldEqual None
  }

  it should "find last element in a list with one element with standard library" in {
    val list = List(5)
    val last = LastButOne.findBuiltIn(list)
    last shouldEqual None
  }

  it should "find last but one element in a non empty list with recursion" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val last = LastButOne.findLastNthElement(list, 2)
    last shouldEqual Some(5)
  }

  it should "find last element in a empty list with recursion" in {
    val list = List()
    val last = LastButOne.findLastNthElement(list, 2)
    last shouldEqual None
  }

  it should "find last element in a list with one element with recursion" in {
    val list = List(5)
    val last = LastButOne.findLastNthElement(list, 2)
    last shouldEqual None
  }

}
