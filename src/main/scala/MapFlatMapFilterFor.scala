object MapFlatMapFilterFor extends  App
{
      val list=List(1,2,464,654,65,2)

      println("Head of the list= "+list.head)
      println("Tail of the list= "+list.tail)

    /////map          // just to see all the elements formatted in a particular way
    println(list.map(_+1))
    println(list.map(_+" is a number"))

    /////filter       ///  filters the list elements in the list in a certain condition
    println("Even numbers: "+list.filter(_%2==0))
    println("Odd numbers: "+list.filter(_%2!=0))

    //////flatMap     Formats in an advanced way
    val toPair = (x:Int)=> List(x,x*2)
    println("FlatMap: "+list.flatMap(toPair))

    //////creating combinations using flatmap
    val numbers=List(1,2,3,4,5)
    val chars=List('a','b,'c','d','e')
    val colors= List("black","white")



    val combinations=numbers.flatMap(n=> chars.flatMap(c=> colors.map( col=> " "+n+" "+c+" "+col)))



    println("Combinations are: "+combinations)
}
