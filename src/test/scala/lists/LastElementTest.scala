package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 23/10/16.
  */
class LastElementTest extends FlatSpec with Matchers {
  behavior of "LastElementTest"

  it should "find last element in a non empty list" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val last = LastElement.find(list)
    last shouldEqual Some(8)
  }

  it should "find last element in a empty list" in {
    val list = List()
    val last = LastElement.find(list)
    last shouldEqual None
  }

  it should "find last element in a non empty list with standard library" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val last = LastElement.findBuiltInt(list)
    last shouldEqual Some(8)
  }

  it should "find last element in a empty list with standard library" in {
    val list = List()
    val last = LastElement.findBuiltInt(list)
    last shouldEqual None
  }

}
