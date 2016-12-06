package trees

/**
  * All possible binary balanced trees given the number of nodes
  * Created by dscarmozzino on 12/6/16.
  */
object BinaryBalanced {

  def buildTree[T](nNodes: Int, value: T): List[Tree[T]] = nNodes match {
    case n if n < 1 => List(End)
    case n if n % 2 == 0 =>
      val lesserSubtrees = buildTree((n - 1) / 2, value)
      val greaterSubtrees = buildTree((n - 1) / 2 + 1, value)
      lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, g, l), Node(value, l, g))))
    case n if n % 2 != 0 =>
      val subtrees = buildTree((n - 1) / 2, value)
      subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
  }

}
