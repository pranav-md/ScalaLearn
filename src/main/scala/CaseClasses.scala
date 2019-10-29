object CaseClasses extends App{

    case class Person(name: String, age:Int)

    val p1= new Person("Pranav", 22)

    println(p1.name)    /// case classes have fields

    val p2=new Person("Pranav",22)

    println(p1==p2)     ///// case classes can be checked whether equal

    val p3=p1.copy(age=23)  /// cloning the objects
    println(p3)

    

}
