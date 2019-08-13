
package main.scala

import example.html.twirltry

object TwirlOn extends App {

   var cats= List[Cat](new Cat("Cat1","Brown","Chicken"),new Cat("Cat2","White","Egg"),new Cat("Cat3","Black","KFC"))

  println(twirltry.render(cats))
}