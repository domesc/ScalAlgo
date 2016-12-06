package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dscarmozzino on 12/5/16.
  */
class DuplicateTests extends FlatSpec with Matchers {

  it should "duplicate all elements with dup" in {
    val list = List('a, 'b, 'c, 'c, 'd)
    val result = Duplicate.dup(list)

    result shouldEqual List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  }

  it should "duplicate all elements with dup2" in {
    val list = List('a, 'b, 'c, 'c, 'd)
    val result = Duplicate.dup2(list)

    result shouldEqual List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  }

  it should "duplicate all elements the given times" in {
    val list = List('a, 'b, 'c, 'c, 'd)
    val result = Duplicate.dupTimes(list, 3)

    result shouldEqual List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  }

}
