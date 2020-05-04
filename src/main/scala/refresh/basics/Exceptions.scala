package refresh.basics

import java.io.IOException


object Exceptions extends App {


  //exception follows java hierarchy
  //both runtime and compile time exception treated as runtime exception

  val elemt =
    try {

      throw new ArrayIndexOutOfBoundsException
    }
    catch {
      case e: ArrayIndexOutOfBoundsException => "ArrayIndexOutOfBoundsException " + e.getMessage
      case e:RuntimeException => "RuntimeException"
    } finally {
      println("from finally")
    }


  print(elemt)

  val a = throw new RuntimeException //throes run time exception


  def throwEx = throw new IOException

  throwEx

}
