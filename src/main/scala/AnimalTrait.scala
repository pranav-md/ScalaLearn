
class Animal(val name:String,val life_expectancy:Int,val locality:String,val spc_type:String,val scietific_name:String)

sealed trait diet
{
  val fav_food:String
  val diet_type:String
}

sealed trait habitat
{
  val temperature:String
  val place: String
 }

sealed trait behaviour
{
  val harmful_level:String
}


case class Species(override val name: String, override val life_expectancy: Int, override val locality: String, override val spc_type: String, override val scietific_name: String
                  , f_food:String, d_type:String
                  , temp:String, plc:String
                  , h_level:String) extends Animal(name,life_expectancy,locality,spc_type,scietific_name) with diet with habitat with behaviour     //(name,age,nationality,profession,gender)
{
  override val fav_food: String = f_food
  override val diet_type: String = d_type

  override val temperature: String = temp
  override val place: String = plc

  override val harmful_level: String = h_level
  def definePerson(): Unit =
  {
    println(name+" is a species which comes under "+spc_type+" which is found in "+locality+", expected to live "+life_expectancy+" years. Scientific name is: "+scietific_name)
    println("Being a "+diet_type+" it loves eating "+fav_food)
    println("It is typically found in "+place+" and it can withstand temperature upto "+temperature)
    println("Its quite "+harmful_level+" species as well.")
  }

}


object AnimalTrait extends App {

  createSpecies("Tiger",68,"Indian","Mammal","Panthera tigris"
                ,"flesh","carnivores"
                ,"40 degree C","grasslands"
                ,"highly harmful")



    def createSpecies( nme: String,life_expectancy: Int,locality: String,spc_type: String,scietific_name: String,
    f_food:String,d_type:String
    ,temp:String, plc:String
    , h_level:String): Unit = {

    val newSpecies = Species(nme, life_expectancy, locality, spc_type, scietific_name
      , f_food, d_type
      , temp, plc
      , h_level)

    newSpecies.definePerson()
    println(newSpecies.toString)
  }
}