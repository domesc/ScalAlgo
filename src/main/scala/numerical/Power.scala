package numerical

import scala.annotation.tailrec

/**
  * Raise a number to a certain power reducing the number of multiplications. It useful for big exponents.
  * Created by domesc on 22/10/17.
  */
object Power {

  /**
    * The algorithm is base on two facts
    * 1. A^(2 * M) = (A^M)^2
    * 2. A^(M + N) = A^M * A^N
    */
  def power(base: Int, exponent: Int): Int = {
    if(exponent == 0) 1
    else {
      val x = power(base, exponent/2)

      if(exponent % 2 == 0) x*x
      else base*x*x
    }
  }

  @tailrec
  def powerTailRec(base: Int, exponent: Int, aux: Int = 1): Int = {
    if(exponent == 0) 1
    else if(exponent == 1) base * aux
    else if(exponent % 2 == 0) powerTailRec(base * base, exponent/2, aux)
    else powerTailRec(base * base, exponent/2, aux * base)
  }

}
