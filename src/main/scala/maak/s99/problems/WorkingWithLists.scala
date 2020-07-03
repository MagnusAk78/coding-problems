package maak.s99.problems

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

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
  // encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) =>
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

  // P12: Decode a run-length encoded list.
  // Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
  // decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) =>
  // List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  def decode[A](list: List[(Int, A)]): List[A] = {
    list.flatMap(element => List.fill(element._1)(element._2))
  }

  // P13: Run-length encoding of a list (direct solution).
  // Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've
  // written (like P09's pack); do all the work directly.
  // List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e) => List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  def encodeDirect[A](ls: List[A]): List[(Int, A)] = {

    // The code becomes much shorter without internal function but then is cannot be tail recursive.
    // I used Vector instead of list because the need to append, while using a List all the way results
    // in prettier code.
    @tailrec
    def encodeDirectInt[A](ls: List[A], result: Vector[(Int, A)]): List[(Int, A)] = {
      if (ls.isEmpty) {
        result.toList
      } else {
        val (spanList, restList) = ls.span(_ == ls.head)
        encodeDirectInt(restList, result :+ (spanList.length, spanList.head))
      }
    }
    encodeDirectInt(ls, Vector())
  }

  // P14: Duplicate the elements of a list.
  //duplicate(List('a, 'b, 'c, 'c, 'd)) => List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  def duplicate[A](ls: List[A]): List[A] = ls flatMap { e => List(e, e) }

  // P15: Duplicate the elements of a list a given number of times.
  // duplicateN(3, List('a, 'b, 'c, 'c, 'd)) => List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  def duplicateN[A](n: Int, ls: List[A]): List[A] = ls flatMap { e => List.fill(n)(e) }

  // P16: Drop every Nth element from a list.
  // drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) => List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  def drop[A](n: Int, ls: List[A]): List[A] = {
    @tailrec
    def dropInt[A](n: Int, ls: List[A], result: ListBuffer[A]): List[A] = {
      if(ls.length < n) {
        result.appendAll(ls)
        result.toList
      } else {
        val (ls1, ls2) = ls.splitAt(n-1)
        dropInt(n, ls2.tail, result.appendAll(ls1))
      }
    }
    dropInt(n, ls, ListBuffer.empty)
  }
  // 'Better' solution => ls.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map { _._1 }

  // P17: Split a list into two parts.
  //The length of the first part is given. Use a Tuple for your result.
  // split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) =>
  // (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  // Built in => ls.splitAt(n)
  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = {
    @tailrec
    def splitInt[A](n: Int, rest: List[A], firstList: List[A]): (List[A], List[A]) = {
      (n, rest) match {
        case (_, Nil) => (firstList.reverse, List())
        case (0, x :: xs) => (firstList.reverse, rest)
        case (_, x :: xs) => splitInt(n - 1, xs, x :: firstList)
      }
    }
    splitInt(n, ls, List())
  }

  // P18: Extract a slice from a list.
  // Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up
  // to but not including the Kth element of the original list. Start counting the elements with 0.
  // slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) => List('d, 'e, 'f, 'g)
  // Built in => ls.slice(i, k)
  def slice[A](i: Int, k: Int, ls: List[A]): List[A] = {
    @tailrec
    def sliceInt[A](i: Int, k: Int, rest: List[A]): List[A] = {
      (i, rest) match {
        case (_, Nil) => List()
        case (0, x :: xs) => rest.take(k)
        case (_, x :: xs) => sliceInt(i - 1, k - 1, xs)
      }
    }
    sliceInt(i, k, ls)
  }
}
