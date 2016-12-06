package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dscarmozzino on 11/22/16.
  */
class CompressTests extends FlatSpec with Matchers {

  "compressFunctional" should "return an empty list if it tries to compress an empty list" in {
    val list = List.empty
    val compressed = Compress.compressFunctional(list)

    compressed shouldEqual List.empty
  }

  "compressFunctional" should "return a list without duplicated consecutive elements" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val compressed = Compress.compressFunctional(list)

    compressed shouldEqual List('a, 'b, 'c, 'a, 'd, 'e)
  }

  "compressRecursive" should "return an empty list if it tries to compress an empty list" in {
    val list = List.empty
    val compressed = Compress.compressRecursive(list)

    compressed shouldEqual List.empty
  }

  "compressRecursive" should "return a list without duplicated consecutive elements" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val compressed = Compress.compressRecursive(list)

    compressed shouldEqual List('a, 'b, 'c, 'a, 'd, 'e)
  }

  "compressRecursive2" should "return an empty list if it tries to compress an empty list" in {
    val list = List.empty
    val compressed = Compress.compressRecursive2(list)

    compressed shouldEqual List.empty
  }

  "compressRecursive2" should "return a list without duplicated consecutive elements" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val compressed = Compress.compressRecursive2(list)

    compressed shouldEqual List('a, 'b, 'c, 'a, 'd, 'e)
  }

}
