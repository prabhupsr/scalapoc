package refresh.basics

//extends App insert Main fn to the code so we can add the code directly
object Basics extends App {



  //val Immutable
  val x: String = "abc"
  val a:Boolean = false
  val aLong:Long = 20L //L is optional
  val afloat:Float = 2.0F //L is optional
  val aDouble:Double = 20.12D //L is optional
  val achar:Char = 'A'
  //var mutable
  var y: Int = 20
  val abcStr = "1234" // auto assigned as String
  println(abcStr)

  //Expressions - everything in scala is expression so any thing can be assigned
  // if can be assigned to a variable unlike Java
  val ifExpr= if(aLong % 2 == 0) "Even" else "Odd";
  val ifType = if(aLong == 0) // as it returns nothing ifType type is Unit(void in java)
  print(ifExpr)


  //Code block - also expression
  val codeBlock = {
    println("from code block")
    "ABCCCC" // last statement is the return value - no explicit return needed
  }
println(codeBlock)

}
