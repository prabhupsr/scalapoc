package refresh.basics

object ClassSamples extends App {

  val employee = new Employee(1,"prabhu","Mani",100)
  println(employee.getNameFullName())
 // println(employee.name)//not possible
  println(employee.getNameFullName())
  println(employee.salary)
  employee.salary = 500
  println("employee.salary after change")
  println(employee.salary)
  //employee.name = "prabu" // not allowed
  new Employee("Mani")
}

//this kind of constructor param are private can be accessed only inside the class
//if you use val or var it can be accessed out side
class Employee(id:Int, val name:String, val secondName:String,var salary:Int, var country:String = "india"){

  def getNameFullName() = name + secondName

  //constructor over loading
  def this(name:String, secondName:String)= this(Math.random().toInt,name,secondName,0)

  //constructor over loading
  def this(name:String)= {
    //println(name) // not possible to add code in first line of overloaded constructor other than this(..)
    this(Math.random().toInt,name,"",0)
    println("name-----", name)
  }



  trait applyClsTrait{
    def apply(v:Int): applyClsTrait
  }

  case class applyCls(value:Int) extends applyClsTrait {
  //  def apply =
    override def apply(v: Int): applyClsTrait = {
      println("abccc")
      new applyCls(5)
    }
  }

  case object applyCls{
    def apply(v:Int) = new applyCls(v)
  }


  val objCls = applyCls(15)
  println(objCls) // applyCls(15)
  println(objCls(10)) // applyCls(5)


}
