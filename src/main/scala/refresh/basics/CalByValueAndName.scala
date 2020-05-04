package refresh.basics

object CalByValueAndName extends App{

  def print(v: Int) = {
    println("printing ", v)
    v
  }
 //second param is considered as  expression if we use => also called funtion
  def printFirstArgAlone(v1:Int, v2: => Int):Unit = println("only first param is printed so second param is not at all evaluated", v1)
  def printBothArg(v1:Int, v2: => Int):Unit = println("both param are printed so second param is  evaluated", v1,v2)

  printFirstArgAlone(print(10),print(20))
  printBothArg(print(10),print(20))
}
