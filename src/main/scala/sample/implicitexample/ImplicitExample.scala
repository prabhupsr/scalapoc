package sample.implicitexample

class ImplicitExample(var value:Int) {

  implicit def smeStr(sme:ImplicitExample): String = sme.value.toString
  implicit def smeInt(int:Int): ImplicitExample = new ImplicitExample(int)
  implicit def smeInt(intToString: Int => String): String = intToString.apply(5)

  def fnImplicitParam(str:String)(implicit num:Int) = str+num

  //implicit val ss:ImplicitExample = 6 //-- not working need to check

  implicit val number:Int=5

  def c(s: String) = s+1;

  def invokeC(sme: ImplicitExample) = c(sme);

  def implicitTarget(i:Int) = invokeC(i)

  def sourceImplicit(i:Int) = i c new ImplicitExample(i)

  def cr(sr:String) = sr.trim

  def cc(i:Int) = cr((s:Int)=>"abc"+s)

  def fnImplicit(str:String) = fnImplicitParam(str)

}

object ImplicitExample {
  def main(args: Array[String]): Unit = {
    val sme: ImplicitExample = new ImplicitExample(5)
    println(sme.c("abc"))
    println(sme.invokeC(sme))
    println("source implicit "+sme.sourceImplicit(9))
    println("target implicit "+sme.implicitTarget(11))
    println(sme.cc(5))
    println("fn implicit param "+sme.fnImplicit("abc"))
    print(sme.value)
  }
}
