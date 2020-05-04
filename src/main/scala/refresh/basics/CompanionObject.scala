package refresh.basics

object CompanionObject extends App {

  //kind of static in java but scala dont have static keyword,
  //jv can have static and object methods in a class but in scala all the static reference exists in object class
  //these are all singleton objects, mostly we will write factory methods
  //if both objects and class have same name they are called companion objects
  //usually in scala, class builder and static methods related to that class are kept in companion object
  //companion obj has access to each others private members
  object clsObj {

    val a = 10

    //Accessing private method of clsObj - companion object
    def printByCallingPrivateClassMethod = new clsObj(4).clsPrivateMethod

  }

  class clsObj(c: Int) {

    val b = 20

    def getBSquare = b ^ 2

    private def clsPrivateMethod = "from private clsObject"
  }

  val clsObject = new clsObj(10)
  println(clsObject getBSquare)
  println(clsObj.printByCallingPrivateClassMethod)
}
