package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dscarmozzino on 11/22/16.
  */
class PackTests extends FlatSpec with Matchers {

  "pack" should "place duplicates elements in sublists" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val result = Pack.pack(list)

    result shouldEqual  List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  }

  "packFunctional" should "place duplicates elements in sublists" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val result = Pack.packFunctional(list)

    result shouldEqual  List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  }
}
