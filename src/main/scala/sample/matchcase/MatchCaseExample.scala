package sample.matchcase

import java.time.Instant
import java.util.Date

class MatchCaseExample {

  def oddOrEven(num: Int): String = {

    val seqMatch: (Int, Int) => Boolean = (sn: Int, n: Int) => n % sn == 0

    num match {
      case 0 => "number is Zero"
      case x if seqMatch(2, x) => s"$x divisible by 2"
      case y if seqMatch(3, y) && !seqMatch(5, y) => s"$y divisible by 3"
      case z if seqMatch(5, z) => "%d divisible by 5".format(z)
      case n => s"$n not divisible by 2 or 3 or 5"
    }
  }

  def fnTypeMatch[S, T](v: S)(fn: S => T): Either[T, String] = {
    v match {
      //As after checking for type respective type is expected so v is used instead of new variable in case
      case _: String => Right(s"${fn(v)}")
      case _: Number | _: Date => Left(fn(v))
      case _ => Right("No Match")
    }
  }

  List

}


object MatchCaseExample {
  def main(args: Array[String]): Unit = {
    val matchCaseExample = new MatchCaseExample()
    println(matchCaseExample.oddOrEven(0))
    println(matchCaseExample.oddOrEven(75))
    println(matchCaseExample.oddOrEven(92))
    println(matchCaseExample.oddOrEven(99))
    println(matchCaseExample.oddOrEven(101))

    println()

    println(matchCaseExample.fnTypeMatch(5d) {
      _ + 5
    })
    println(matchCaseExample.fnTypeMatch(50) {
      _ + 10
    })
    println(matchCaseExample.fnTypeMatch("ABC") {
      _.concat("bcd")
    })
    println(matchCaseExample.fnTypeMatch(new Date()) {
      _.toInstant
    })
    println(matchCaseExample.fnTypeMatch(Instant.now()) {
      _.getEpochSecond
    })
  }
}
