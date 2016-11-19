package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 19/11/16.
  */
class FlattenTest extends FlatSpec with Matchers {

  "flattenRecursive1" should "correctly flatten a complex nested list" in {
    val list = List(List(1, 1), 2, List(3, List(5, 8)))
    val result = Flatten.flattenRecursive(list)

    result shouldEqual List(1, 1, 2, 3, 5, 8)
  }

}
