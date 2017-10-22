package numerical

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 22/10/17.
  */
class PowerTests extends FlatSpec with Matchers {

  behavior of "Power"

  it should "give the right power result" in {
    Power.power(2, 8) shouldEqual 256
    Power.powerTailRec(2, 8) shouldEqual 256

    Power.power(2, 9) shouldEqual 512
    Power.powerTailRec(2, 9) shouldEqual 512
  }
}
