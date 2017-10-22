package numerical

import scala.annotation.tailrec

/**
  * Compute the great common divisor with Euclid's method
  * Created by domesc on 22/10/17.
  */
object Gcd {

  def imperativeGcd(n1: Int, n2: Int): Int = {
    var a = n1
    var b = n2
    while(b != 0) {
      val remaining = a % b
      a = b
      b = remaining
    }
    a
  }

  @tailrec
  def recGcd(n1: Int, n2: Int): Int = {
    if(n2 == 0) n1
    else {
      recGcd(n2, n1 % n2)
    }
  }

}
