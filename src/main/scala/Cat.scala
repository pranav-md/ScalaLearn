package main.scala

class Cat(xname: String, xcolor: String, xfood: String)
{
      var name: String =xname
      var color: String= xcolor
      var food: String=xfood
      
      def dispCatDetails()
      {
          println("Cat name= "+ xname+ " Color:"+color+" Food:"+food)
      }
      
}