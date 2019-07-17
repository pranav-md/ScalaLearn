object HelloWorld extends App {
   println("Incrementer")
          //     var dir1=new Director("Satyan","Anthikad",1977)
          //     var dir2=new Director("Steven","Spielberg",1957)
          //     var dir3=new Director("James","Cameroon",1925)
          //
          //     var film1=new Film("Manasinakare",2005,dir1)
          //     var film2=new Film("Jurassic",2005,dir2)
          //     var film3=new Film("Manasinakare",2005,dir3)
          //
          //     println("Satyan anthikads film age: "+ film1.directorsAge())
          //     println("Steven speilbergs film age: "+ film1.directorsAge())
          //     println("James cameroons film age: "+ film1.directorsAge())

//          var ctr= new CountR(30)
//          callByVal(System.nanoTime())       /// Only the value is passed through the arguement
//          callByName(System.nanoTime())      ///  The expression itself is passed through the arguement

         val sirname="Kuttappan"
         val placename="OOTY"
         val str: String =":43:343:535:21:66"
         println("User IDs= "+str.split(":").toList)
         val greetings: String =s"Hello $sirname, Welcome to $placename nice to meet you"
         println(greetings)


   def recurseIt(num:Int=30): Int ={                     /// RECURSION--FUNCTION DEFINITION--default parameter
      if(num==0)
         return 0;
      else
      {
         println("Num= "+num)
         return recurseIt(num-1)
      }
   }

   def callByVal(x: Long):Unit=        //// call by value
   {
      println("x= "+x)
      println("x= "+x)
   }

   def callByName(x: =>Long):Unit=     //// => makes all the difference
   {
      println("x= "+x)
      println("x= "+x)
   }

   def stringOperations(x:String):Unit=     //// => makes all th
   // difference
   {
      println("x= "+x)
      println("x= "+x)
   }

   class Animal(name: String,age: Int)
   class Cat(name: String, age:Int,color: String) extends Animal("Prnaav",12)


}

