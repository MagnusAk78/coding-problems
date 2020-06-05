package maak.s99.problems

import scala.annotation.tailrec

// Working with lists from http://aperiodic.net/phil/scala/s-99/
object WorkingWithLists {

  // P01: Find the last element of a list. last(List(1, 1, 2, 3, 5, 8)) => 8
  // Trivial solution => list.last
  @tailrec
  def last[A](list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException
    case head :: Nil => head
    case _ :: tail => last(tail)
  }

  // P02: Find the last but one element of a list. penultimate(List(1, 1, 2, 3, 5, 8)) => 5
  @tailrec
  def penultimate[A](list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException
    case _ :: Nil => throw new NoSuchElementException
    case head :: _ :: Nil => head
    case _ :: _ :: tail => penultimate(tail)
  }

  // P03: Find the Kth element of a list. nth(2, List(1, 1, 2, 3, 5, 8)) => 2
  @tailrec
  def nth[A](n: Int, list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException
    case head :: tail => n match {
      case 0 => head
      case _ => nth(n - 1, tail)
    }
  }

  // P04: Find the number of elements of a list. length(List(1, 1, 2, 3, 5, 8)) => 6
  // Trivial solution => list.length || list.size
  def length[A](list: List[A]): Int = {
    @tailrec
    def lengthInt[A](list: List[A], length: Int): Int = list match {
      case Nil => length
      case _ :: tail => lengthInt(tail, length + 1)
    }
    lengthInt(list, 0)
  }

  // P05: Reverse a list. reverse(List(1, 1, 2, 3, 5, 8)) => List(8, 5, 3, 2, 1, 1)
  // Trivial solution => list.reverse
  def reverse[A](list: List[A]): List[A] = list.foldLeft(List.empty[A])((rList, element) => element :: rList)

  // P06: Find out whether a list is a palindrome. isPalindrome(List(1, 2, 3, 2, 1)) => true
  // Trivial solution => list == list.reverse
  @tailrec
  def isPalindrome[A](list: List[A]): Boolean = list match {
    case Nil => true
    case head :: tail => tail.lastOption match {
      case None => true
      case Some(last) => head == last && isPalindrome(list.take(1).takeRight(1))
    }
  }

  // P07: Flatten a nested list structure. flatten(List(List(1, 1), 2, List(3, List(5, 8)))) => List(1, 1, 2, 3, 5, 8)
  def flatten(list: List[Any]): List[Any] = list flatMap {
    case ls: List[_] => flatten(ls)
    case e => List(e)
  }

  // P08: Eliminate consecutive duplicates of list elements.
  // compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) => List('a, 'b, 'c, 'a, 'd, 'e)
  def compress[A](list: List[A]): List[A] = {
    list.foldRight(List[A]())((head, tail) => if(tail.nonEmpty && tail.head == head) {
      head :: tail.tail
    } else {
      head :: tail
    })
  }

  // P09: Pack consecutive duplicates of list elements into sublists.
  // pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) =>
  // List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  def pack[A](list: List[A]): List[List[A]] = {
    list.foldRight(List[List[A]]()) {
      (head: A, result: List[List[A]]) =>
        if (result.nonEmpty && result.head.nonEmpty && result.head.head == head) {
          List(head :: result.head) ::: result.tail
        } else {
          List(List(head)) ::: result
        }
    }
  }

  // P10: Run-length encoding of a list.
  // Use the result of problem P09 to implement the so-called run-length encoding data compression method.
  // Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the
  // element E.
  // encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) =>
  // List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  def encode[A](list: List[A]): List[(Int, A)] = {
    pack(list).foldRight(List[(Int, A)]())((packed, resultList) => (packed.length, packed.head) :: resultList)
  }

  // P11: Modified run-length encoding.
  // Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the
  // result list. Only elements with duplicates are transferred as (N, E) terms.
  // encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  // List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  def encodeModified[A](list: List[A]): List[Any] = {
    encode(list).foldRight(List[Any]())((encoded: (Int, A), resultList: List[Any]) => {
      if(encoded._1 == 1) {
        encoded._2 :: resultList
      } else {
        encoded :: resultList
      }
    })
  }
}
