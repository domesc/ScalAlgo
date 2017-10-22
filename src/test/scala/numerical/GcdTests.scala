package numerical

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 22/10/17.
  */
class GcdTests extends FlatSpec with Matchers {

  behavior of "Gcd"

  it should "correctly compute the gcd" in {
    Gcd.imperativeGcd(60, 24) shouldEqual 12
    Gcd.recGcd(60, 24) shouldEqual 12
  }

}
