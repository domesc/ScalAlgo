package lists

/**
  * Check if list is palindrome
  * Created by domesc on 19/11/16.
  */
object Palindrome {

  def isPalindrome[A](list: List[A]): Boolean = list.reverse == list

}
