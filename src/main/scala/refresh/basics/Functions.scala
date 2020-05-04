package refresh.basics

import scala.annotation.tailrec

object Functions extends App {

  def add(a: Int, b: Int) = a + b //return type is not mandatory and no explicit return is needed -> type inference
  def printAbc() = println("Abc")

  println(add(1, 3))
  println(add(5, 3))
  printAbc()
  printAbc // no arg functions can be without this

  //try to use recursive instead of loops in functional programing

  def factorial(a: Int): Int = {
    if (a <= 1) a else a * factorial(a - 1)
  }

  //function inside a function
  def isPrime(a: Int) = {
    @tailrec
    def isPrime(n: Int, itr: Int): Boolean = {
      if (a <= 3) true
      else if (itr <= n / itr) n % itr != 0 && isPrime(n, itr + 1) else true
    }

    isPrime(a, 2)
  }


  def strConcatN(inputStr: String, num: Int): String = {
    @tailrec
    def strConcatTailRec(str: String, n: Int): String = if (n <= 1) str else strConcatTailRec(str + inputStr, n - 1)

    strConcatTailRec(inputStr, num)
  }

  println("factorial ", factorial(6))
  println("is Prime", isPrime(4))
  println("is Prime", isPrime(101))
  println(strConcatN("Abc ", 1))


  //function with default value
  @tailrec
  def isPrimeWithDefaultVal(n: Int, itr: Int = 2): Boolean = {
    if (n <= 3) true
    else if (itr <= n / itr) n % itr != 0 && isPrimeWithDefaultVal(n, itr + 1) else true
  }

  println("isPrimeWithDefaultVal", isPrimeWithDefaultVal(11))
  println("isPrimeWithDefaultVal", isPrimeWithDefaultVal(10))

}



