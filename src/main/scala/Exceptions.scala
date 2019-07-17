object Exceptions extends App {

  val x: String =null


  def getInt(withExceptions: Boolean): Int =
    if(withExceptions)  throw  new RuntimeException("No int is there for you!")
    else 22

  try{
    getInt(true)
    getInt(false)
  }
  catch{
    case e: RuntimeException => println("Caught an runtime exception")
  }
  finally
    {
      println("finally finally")
    }
}
