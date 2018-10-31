package sample.higherorderfunctions

class HigherOrderFunctionExample {

  def fun1(i: Int) = i + 1

  val fnVar = (i: Int) => i * 3

  implicit val fnVarInt = (i: Int) => i*10d

  implicit val fnVarStr = (d: Double) => "final value is " + d

  def funCombine(fnSeq: (Int => Int)*)
                (implicit implicitFn1: Int => Double, implicitFn2: Double => String) =
  {
    fnSeq.fold(fun1(_)) { (fn1, fn2) => fn1 andThen fn2 } andThen implicitFn1 andThen implicitFn2
  }

  def fnInit(i: Int) = funCombine(fnVar, fnVar).apply(i)


}

object HigherOrderFunctionExample {
  def main(args: Array[String]): Unit = {
    println(new HigherOrderFunctionExample().fnInit(1)) //180 - > (1 + 1) * 3 * 3 * 10
  }
}
