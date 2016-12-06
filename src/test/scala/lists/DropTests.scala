package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dscarmozzino on 12/6/16.
  */
class DropTests extends FlatSpec with Matchers {

  it should "drop the nth element from the list with drop function" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val result = Drop.drop(3, list)

    result shouldEqual List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  }

  it should "drop the nth element from the list with dropBuiltIn function" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val result = Drop.dropBuiltIn(3, list)

    result shouldEqual List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  }

}
