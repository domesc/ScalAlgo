package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 21/10/17.
  */
class RotateTests extends FlatSpec with Matchers {

  behavior of "Rotate"

  it should "rotate a list N places to the left" in {
    val l = List(1,2,3,4,5,6,7)

    Rotate.rotate(4, l) shouldEqual List(5,6,7,1,2,3,4)
    Rotate.rotateFold(4, l) shouldEqual List(5,6,7,1,2,3,4)
  }

  it should "fail as n is bigger than the list length itself" in {
    val l = List(1,2,3,4,5,6,7)

    intercept[IllegalArgumentException](Rotate.rotate(20, l) shouldEqual List(5,6,7,1,2,3,4))
    intercept[IllegalArgumentException](Rotate.rotateFold(20, l) shouldEqual List(5,6,7,1,2,3,4))
  }

}
