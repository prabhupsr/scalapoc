package sample.dynamic

import scala.language.dynamics

class DynamicExample extends Dynamic {

  def applyDynamic(mName:String)(str:Int) {
    println(s"called $mName with $str")
  }

}

object DynamicExample {
  def main(args: Array[String]): Unit = {
    val d = new DynamicExample()

    println(d.abc(6))

  }
}
