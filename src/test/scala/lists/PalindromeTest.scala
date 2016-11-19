package lists

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by domesc on 19/11/16.
  */
class PalindromeTest extends FlatSpec with Matchers {

  "isPalidrome" should "return true when passing an empty list" in {
    val list = List.empty

    val result = Palindrome.isPalindrome(list)

    result shouldEqual true
  }

  "isPalidrome" should "return true when list(with odd number of elements) is palindrome" in {
    val list = List('a', 'h', 'r', 'h', 'a')

    val result = Palindrome.isPalindrome(list)

    result shouldEqual true
  }

  "isPalidrome" should "return true when list(with even number of elements) is palindrome" in {
    val list = List('a', 'h', 'r', 'r', 'h', 'a')

    val result = Palindrome.isPalindrome(list)

    result shouldEqual true
  }

  "isPalidrome" should "return false when list is not palindrome" in {
    val list = List('a', 'h', 'l', 'r', 'h', 'a')

    val result = Palindrome.isPalindrome(list)

    result shouldEqual false
  }

}
