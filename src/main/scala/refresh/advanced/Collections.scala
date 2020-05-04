package refresh.advanced

object Collections extends App {



  /*
 1.Immutable collection (package : scala.collections.immutable)
 Traversable
   Iterable
    Set
      HashSet
      SortedSet
    Seq
      IndexedSeq
        Vector
        String
        Range
      LinearSeq
        List
        Stream
        Stack
        Queue
    Map
      HashMap
      SortedMap


 2.mutable collection (package : scala.collections.mutable)
 Traversable
   Iterable
    Set
      HashSet
      LinkedHashSet
    Seq
      IndexedSeq
        StringBuilder
        ArrayBuffer
      LinearSeq
        MutableList
        LinkedList
      Buffer
        ArrayBuffer
        ListBuffer
    Map
      HashMap
      MultiMap
   */

  list
  array
  vector
  map

  val numList = List(1, 2, 3, 4, 5, 6)

  println(numList)

  //double all the number in the list
  //create a range for all the number in the list
  numList
    .map(_ * 2) // .map(num=> num * 2)
    .flatMap(1 to _ toList) // same as .flatMap(num=>(1 to num).toList)
    .sortWith(_ - _ > 0) // .sortWith((num1,num2) => num1 - num2 > 0)
  //  .foreach(println)
}


object list {

  //List will be good for insertion in first, as head is assigned to a field
  // insertion in the middle is time complex
  println("******************listObject start ******************************")
  val sequence = Seq(1, 2, 3, 4, 5) // return List from apply method of Seq
  //in scala , list has head and remaining list as a tail List[E]{head:E,tail:List[E]}
  val list = List(1, 2, 3, 4)
  println(list) // return List
  println(list(3)) // 4 - take base on index
  println(list ++ sequence) // merging 2 list
  println(list.head) // taking head and tail in O(1)

  private val listAppend: List[Int] = 10 +: list :+ 15
  private val ints: List[Int] = 11 :: list
  List.fill(5)(1) // List(1,1,1,1,1)

  println("******************listObject end ******************************")
}

object range {

  private val inclusive: Range.Inclusive = 1 to 15
  println(inclusive)

  private val range1: Range = 1 until 10
  println(range1)

}

object array {

  //Arrays are same as java array
  //scala converts array to Seq by implicit conversion
  //will all the methods of Seq
  private val array: Array[Int] = Array(1, 2, 3, 4)
  array(1)
  array.length
  val arrayByDim = Array.ofDim(5)
  println(arrayByDim)
}

object vector {

  println("*****vector*****")
  //vector - fixed branch trie(branch factor 32)
  //so read and write will be faster
  //vector will be suitable for insertion ans deletion in the middle
  //will be apt fot large data
  private val vector = Vector(1, 2, 3, 4)
  println(vector.drop(2)) //drops 2 element Vector(3,4)
  vector updated(1, 10) // Vector(3,10)


}

object map {
  println("*****************Maps******************")
  //map contains list of tuple2
  //without default value apply will throw exp if key not found
  //map.get will give Option value
  private val map = Map(1 -> "A", 2 -> "B").withDefault("")
  map.map(tuple2 => (tuple2._2, tuple2._2 ))
  map + (3 -> "c") //appending a tuple
  map.count(_ ==2) //count based on  predicate
}