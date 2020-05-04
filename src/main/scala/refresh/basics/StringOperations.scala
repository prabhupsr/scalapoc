package refresh.basics

object StringOperations extends App{


  val str1:String = "abc"
  val intVal = 5
  //s for string formator
  println(s"str1 value is $str1 and int value plus 10 is $intVal")
  //f for numerical formater
  println(f"str1 value is $str1 and int value  is $intVal%2.3f")
  //raw is used print escape chars also
  println(raw"str1 value is /n/t1 and int value  is $intVal%2.3f")


  val tup=str1.->(12)

  println(tup)

}
