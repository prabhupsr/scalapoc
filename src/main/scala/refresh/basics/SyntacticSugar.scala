package refresh.basics

object MethodOperators extends App {

  val num = new Num(10)
  //method with single or  arg can be called like that (infix method)
  println(num pow 2)
  println(num.pow(2))
  println(num plus 5)
  println(num + 5)
  println(!num) //prefix can be called like this
  println(num()) // will call the apply method

}


class Num(a: Int) {
  def pow(pow: Int) = a ^ 2

  def plus(v: Int) = a + v

  //in scala operators are also functions
  def +(v: Int) = a + v

  //can be called as prefix notation
  def unary_! = "pre fix method" // + , -, * possible

  //post fix notation, can be called as new Num(10)() object()
  def apply() =  "apply method called"
}