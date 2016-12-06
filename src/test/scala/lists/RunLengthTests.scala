package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dscarmozzino on 11/22/16.
  */
class RunLengthTests extends FlatSpec with Matchers {
  it should "encode correctly" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val result = RunLength.encode(list)

    result shouldEqual List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  }

  it should "encode correctly without encoding the non duplicated elements" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val result = RunLength.encodeModified(list)

    result shouldEqual List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  }

  it should "decode correctly" in {
    val list: List[(Int, Symbol)] = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    val result = Decoder.decode(list)

    result shouldEqual List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  }

  it should "encode2 correctly" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val result = RunLength.encode2(list)

    result shouldEqual List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  }

  it should "encode directly" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val result = RunLength.encodedirectly(list)

    result shouldEqual List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  }

}
