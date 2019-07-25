
class Human(val name:String,val age:Int,val nationality:String,val profession:String,val gender:String)

sealed trait hair
{
  val hairColor:String
  val hairStyle:String
}

sealed trait face
{
  val complexion:String
  val faceShape: String
  val facialHair:Boolean
}

 trait body
{
   val height: Int
   val weight: Int
   val body_type:String
}


case class Person(override val name: String, override val age: Int, override val nationality: String, override val profession: String, override val gender: String
             , h_color:String, h_style:String
             , f_complexion:String, f_Shape:String, f_hair:Boolean
             , b_height:Int, b_weight:Int, b_type:String) extends Human(name,age,nationality,profession,gender) with hair with face with body    //(name,age,nationality,profession,gender)
{
  override val hairColor: String = h_color
  override val hairStyle: String = h_style

  override val complexion: String = f_complexion
  override val faceShape: String = f_Shape
  override val facialHair: Boolean = f_hair

  override val height: Int = b_height
  override val weight: Int = b_weight
  override val body_type: String = b_type

  def definePerson(): Unit =
  {
    println(name+" is a "+age+" years old "+nationality+" "+gender+" who is working as "+profession)
    println("with "+complexion+" complexion with "+faceShape+" face and "+(if(facialHair)"with"else "having no")+" facial hair ")
    println("His height is "+height+"m and weighs "+weight+"kg with "+body_type+" body type.")
  }
}


object HumanTrait extends App
{
  createPerson("Donald Trump",68,"American","President","Male"
              ,"White","Comb Over"
              ,"White","Round",false
              ,180,100,"Fat")


    def createPerson(nme:String,age:Int,nationality:String,profession:String,gender:String
                     ,h_color:String,h_style:String
                     ,f_complexion:String,f_Shape:String,f_hair:Boolean
                     ,b_height:Int,b_weight:Int,b_type:String): Unit =
    {

      val newPerson=Person(nme,age,nationality,profession,gender
        ,h_color,h_style
        ,f_complexion,f_Shape,f_hair
        ,b_height,b_weight,b_type)

      newPerson.definePerson()
      println(newPerson.toString)
    }
}
