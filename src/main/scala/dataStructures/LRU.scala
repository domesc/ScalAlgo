package dataStructures

import scala.collection.mutable

/**
  * An implementation of a LRU cache
  * Created by domesc on 22/10/17.
  */
case class Node[KEY, VALUE](
  key: KEY,
  value: VALUE,
  var prev: Option[Node[KEY, VALUE]] = None,
  var next: Option[Node[KEY, VALUE]] = None)

case class LRU[KEY, VALUE](capacity: Int) {

  private val map = mutable.HashMap.empty[KEY, Node[KEY, VALUE]]
  private var head: Option[Node[KEY, VALUE]] = None
  private var end: Option[Node[KEY, VALUE]] = None

  def get(key: KEY): Option[VALUE] = {
    if(map.contains(key)) {
      var node = map.get(key)
      node.foreach{n =>
        remove(node.get)
        setHead(node.get)
      }

      node.map(_.value)
    } else None
  }

  def set(key: KEY, value: VALUE): Unit = {
    if(map.contains(key)) {
      var old = map.get(key)
      old.foreach{o =>
        remove(o)
        setHead(o)
      }

    } else {
      var newNode = Node(key, value)
      if(map.size >= capacity) {
        end.foreach { e =>
          map.remove(e.key)
          remove(e)
        }
        setHead(newNode)
      } else {
        setHead(newNode)
      }
      map.put(key, newNode)
    }
  }

  private def remove(node: Node[KEY, VALUE]): Unit = {
    if(node.prev.isEmpty) {
      head = node.next
    } else {
      node.prev.foreach(prev => prev.next = node.next)
    }

    if(node.next.isEmpty) {
      end = node.prev
    } else {
      node.next.foreach(next => next.prev = node.prev)
    }
  }

  private def setHead(node: Node[KEY, VALUE]): Unit = {
    node.next = head
    node.prev = None

    if(head.isDefined) {
      head.foreach(h => h.prev = Option(node))
    }

    head = Option(node)

    if(end.isEmpty) {
      end = head
    }
  }
}
