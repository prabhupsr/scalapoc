package refresh.basics

object Generics extends App {

  //Co-variance

  def acceptAll[A](value: A): Unit = println(value)

  acceptAll(Chennai("abc"))
  acceptAll(Banglore("abc"))
  acceptAll(Delhi("abc"))

  val intContainer = new CovariantContainer[Int](5)
  println(intContainer.getValue())

  val longContainer = new CovariantContainer[Long](5)
  println(longContainer.getValue())

 // covariance can be assigned with any subtypes also
  val covariantContainer:CovariantContainer[State] = new CovariantContainer[Chennai](Chennai("namma chennai"))

  //not allowed in variant types, can take only single straight assignment
  //val InvariantContainer1:InvariantContainer[State] = new InvariantContainer[Chennai](Chennai("madras"))
  val InvariantContainer:InvariantContainer[State] = new InvariantContainer[State](Chennai("madras"))

  //Contravariant can assign only same or super class
  val ContravarianContainer:ContravariantContainer[Chennai,State] = new ContravariantContainer[Chennai,State](Banglore("garden city"))


  //similar java generics extends
  class upperBoundedContainer[A<:State](value:A)

  new upperBoundedContainer(Chennai("namma chennai"))

  //similar to super in java generics
  class lowerBoundContainer[A>:Chennai](value: A)

  new lowerBoundContainer[Chennai](Chennai(""))
  new lowerBoundContainer[State](Banglore(""))



}

class State(val tagline: String)

case class Chennai(tagLine: String) extends State(tagLine)

case class Banglore(tagLine: String) extends State(tagLine)

case class Delhi(tagLine: String) extends State(tagLine)

class CovariantContainer[+A](value: A) {

  def getValue(): A = value
}

case class InvariantContainer[A](value: A)

case class ContravariantContainer[-A,B >:A](value: B)


