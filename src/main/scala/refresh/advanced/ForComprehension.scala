package refresh.advanced
import scala.util.Try

object ForComprehension extends App {

  OptionForComprehension
  listForComprehension
  tryComprehension

  private def tryComprehension = {
    def throwException(throwExp: Boolean): Try[Int] = Try {
      println(throwExp)
      if (throwExp) throw new RuntimeException else 5
    }

    for {
      try1 <- throwException(false)
      try2 <- throwException(false)
    } println(" response from try", try1 + try2) // ( response from try,10)

    for {
      try1 <- throwException(false)
      try2 <- throwException(true)
    } println(" response from try", try1 + try2) //will not be printed
  }


  //for comprehension
  //target object (values usen in comprehension) should implement map,flatMap,filter
  //this will be converted to map flat map in scala
  //much more frequently used as it is more readable
  //find all even number odd number combination
  private def listForComprehension = {
    val numList = List(1, 2, 3, 4, 5, 6)
    val evenOddCombination = for {
      evenNumber <- numList if evenNumber % 2 == 0
      oddNumber <- numList if oddNumber % 2 == 1
    } yield (evenNumber, oddNumber)

    println(evenOddCombination)
  }

  private def OptionForComprehension = {

    val firstNameMap: Map[Int, String] = Map(1 -> "Prabhu", 2 -> "Mani")

    val secondNameMap = Map((1, "Mani"), (3, "Ritu"))

    //for comprehension of  option
    val fullNameFn = (id: Int) => for {
      firstName <- firstNameMap.get(id)
      secondName <- secondNameMap.get(id)
    } yield firstName + " " + secondName

    println(fullNameFn(1)) //Some(PrabhuMani)
    println(fullNameFn(2)) //None
  }
}
