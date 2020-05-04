package refresh.basics

object CaseClasses {


  //automatically implements hashcode,equals,toString
  //provides copy method for cloning
  //can be instantiated with out new
  //serializable
  //automatic companion object is available
  case class A(param1: Int, param2: Int)

  val a = A(1, 2) //with out using new keyword created
  a.param1 //class param are accessible like fields( val)

  println(a == A(1, 2)) // True - because of equals method

  val a5 = a.copy(param1 = 5) // creating new instance using copy\


  case object A{
    def printerName = println("A")
  }


  //almost all properties of case classes  are applicable case objects also
  case object B{
    def printName= println("B")
  }


}
