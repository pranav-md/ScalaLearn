object Functionz extends App {

    def concatenator: (String, String)=> String= new Function2[String,String,String]{

      override def apply(a: String,b:String) : String =a+b

    }


  ///////////////CURRIED FUNCTION
  def concatenate2: Function1[String,Function1[String,String]]=new Function1[String,Function1[String,String]] {

    override def apply(x:String):Function1[String,String]= new Function1[String,String] {

      override def apply(y :String): String = x+y

    }

  }

    println("Concatenator1 "+concatenator(concatenator("Pranav ","Madhav")," Dev"))
    println("Concatenator2 "+concatenate2(concatenate2("Pranav ")("Madhav"))(" Dev"))


    ////////////HIGHER ORDER FUNCTIONS
    def nTimes(f: Int=> Int,n: Int,x: Int): Int =
        if(n==0)  x
        else   nTimes(f,n-1,f(x))

    val plusOne = (x:Int)=> x+1

    println("Plus One 25: "+nTimes(plusOne,25,1))


    ///////////////HOF + CURRYING
    def nTimesBetter(f:Int=>Int,n:Int):(Int=> Int)=
      if(n==0)(x: Int)=> x
      else  (x: Int)=> nTimesBetter(f,n-1)(f(x))

  println("Plus One Better 25: "+nTimesBetter(plusOne,25)(1))

    //////////////// SIMPLE CURRIED FUNCTION
    val supperAdder: Int => (Int=>Int)=(x:Int)=>(y:Int)=>x+y

    println("Super adder is here with 223+534= "+supperAdder(223)(543))

}
