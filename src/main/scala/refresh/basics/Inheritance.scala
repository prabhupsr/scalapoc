package refresh.basics

object Inheritance extends App {


  val car:Vehicle = new Car("Golf","VW")
  val bike = new Bike("Africa Twin","Bike","Honda")

  car.drive
  car.vehicleName
  bike.vehicleName
  bike.drive


  new Cls().abstractMethod("")
}


//trait is similar to interface but can have both abstract and proper methods
//trait dont have constructor where abstract class can
trait SinglePlayerGame{
  def play(player:String)

  def otherPlayer = println("system")
}

trait MultiPlayerGame{
  def play(player:String,player2:String)
}

//class can extent multiple trait using with keyword like -  with trait1 with trait2
class Cricket extends SinglePlayerGame with MultiPlayerGame {
  override def play(player: String): Unit = println("play against system")

  override def play(player: String, player2: String): Unit = println("p1 vs p2")
}
//sealed is like final but allows to extended in the same file
//final in class and method has the same behaviour as java
//In Scala, methods and variable can be overridden, both are considered similarly
sealed class Vehicle(name: String, vType: String = "car") {

  def vehicleName = println(name)
  def drive = println("driving vehicle")
}

  //like java base class constructor is called before subclass constructor
  //dynamic dispatch is applicable here also
class Car(name: String, make: String) extends Vehicle(name){
    override def drive: Unit = {
      super.drive
      println("driving car")
    }
  }

class Bike(name: String, vType: String, make: String) extends Vehicle(name, vType){
  override def drive: Unit = println("driving bike")
}

abstract class abstractCls{
  def abstractMethod(arg:String)
}

class Cls extends abstractCls {
  override def abstractMethod(arg: String): Unit = println("from impl")
}
