package trees

/**
  * Created by dscarmozzino on 12/6/16.
  */
sealed abstract class Tree[+T] {
  def addValue[U >: T <% Ordered[U]](x: U): Tree[U]
  def isMirrorOf[V](tree: Tree[V]): Boolean
  def isSymmetric: Boolean
}
case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  override def isMirrorOf[V](tree: Tree[V]): Boolean = tree match {
    case Node(v, l, r) => left.isMirrorOf(l) && right.isMirrorOf(r)
    case _ => false
  }

  override def isSymmetric: Boolean = left.isMirrorOf(right)

  override def addValue[U >: T <% Ordered[U]](x: U): Tree[U] = {
    if(x < value) {
      Node(value, left.addValue(x), right)
    } else {
      Node(value, left, right.addValue(x))
    }
  }
}
case object End extends Tree[Nothing] {
  override def toString = "."

  override def isMirrorOf[V](tree: Tree[V]): Boolean = tree == End

  override def isSymmetric: Boolean = true

  override def addValue[U >: Nothing <% Ordered[U]](x: U): Tree[U] = Node(x)
}
object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object Tree {
  def fromList[T <% Ordered[T]](list: List[T]): Tree[T] = {
    list.foldLeft(End: Tree[T]) {
      case (acc, element) => acc.addValue(element)
    }
  }
}
