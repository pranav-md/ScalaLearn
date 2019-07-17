object LinkedList extends App
{
    sealed trait IntList
    case object End extends IntList
    final case class Pair(head: Int,tail: IntList) extends IntList

    val l_list1=new Pair(1,Pair(2,Pair(3,Pair(4,End))))
    val end1=End
    val p1=Pair(3,end1)
    val p2=Pair(4,p1)
    val p3=Pair(5,p2)
    val p4=Pair(6,p3)
    val p5=Pair(7,p4)

    println("SUM OF l_list1= "+listSum(l_list1,0))
    println("SUM OF p5= "+listSum(p5,0))

    println("SUM2 OF l_list1= "+listSum2(l_list1))
    println("SUM2 OF p5= "+listSum2(p5))

    dispList(p5)
    dispList(l_list1)
    def listSum(pairs:IntList,sum:Int):Int =
        pairs match {
          case End=>sum
          case Pair(hd,tl)=> listSum(tl,sum+hd)
        }

    def listSum2(pairs:IntList):Int =
        pairs match {
            case End=>0
            case Pair(hd,tl)=> hd+listSum2(tl)
        }


    def dispList(pairs:IntList):Int =
        pairs match {
            case End=> println(" ")
                       1
            case Pair(hd,tl)=>  print(" "+hd)
                                dispList(tl)
        }
}
