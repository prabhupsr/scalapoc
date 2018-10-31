package sample

object BaseCls {
  def main(args: Array[String]): Unit = {

    var l:List[String] = "abc"::"123"::"aaa"::List("zzz","mmmm")


    println(l.:\ ("abb",1){(a, b)=> (a+b._1,a.length)})
    println(maxValue(l))

  }

  def maxValue(elements:List[String]):String={

  elements match {
    case List()=>throw new RuntimeException
    case List(x)=>x
    case x::r =>
      println(r.size)
      val max=maxValue(r)
      if(x>max){
        x
      }else{
        max
      }
  }
  }
}
