package dataStructures

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 22/10/17.
  */
class LRUTests extends FlatSpec with Matchers {
  behavior of "LRU"

  it should "be able to do simple operations on the cache" in {
    val cache = LRU[Int, Int](3)

    cache.set(1, 2)
    cache.set(2, 3)
    cache.set(3, 4)

    cache.get(3)
    cache.get(2)

    cache.set(4, 5)

    cache.get(1) shouldEqual None
  }

}
