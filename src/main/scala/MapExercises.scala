object MapExercises extends App {

  var m1=Map("Kuttappan"->3,"Ruchi"->2,"Becky"->4,"MEGHA"->23)

  var allPPL=Map(1->"Pranav",2->"Jimmy",3->"Kuttappan",4->"Sashi").withDefaultValue(-1)

  var allFriends=Map(1->List(2,3,4),2->List(1,4))
  var loop=1
  while (loop==1) {
    println("SOCIAL NETWORK")
    println("1. Print all users")
    println("2. Add a user")
    println("3. Delete a user")
    println("4. Show friends of a user")
    println("5. Add friend of a User")
    println("6. Delete a friend of a User")
    println("7. Stop")
    val choice = scala.io.StdIn.readInt()
    choice match {
      case 1 => printAllUsers()
      case 2 => addUser()
      case 3 => deleteUser()
      case 4 => showUserFriends()
      case 5 => addUserFriend()
      case 6 => deleteUserFriend()
      case 7 => loop=0
    }
  }

  def printAllUsers() {
    println("THE USERS ARE:")
    allPPL.keys.map(id=> println(id+".  "+allPPL(id)))
   }

  def addUser(){
    println("ADD NEW USER")
    println("Enter user name:  ")
    val name=scala.io.StdIn.readLine()
    val newUser= (allPPL.size+1) -> name
    allPPL=allPPL+newUser
    println("USER ADDED SUCCESSFULLY")
  }

  def deleteUser(){
    println("DELETE A USER")
    println("Enter user ID:  ")
    val id=scala.io.StdIn.readInt()
    val name=allPPL(id)
    allPPL-=id
    println("DELETED "+name+" SUCCESSFULLY!")
  }

  def showUserFriends()
  {
      println("SHOW FRIENDS OF USER")
      println("Enter user ID:  ")
      val id=scala.io.StdIn.readInt()
      val f_list=allFriends(id)
      println("ALL FRIENDS ARE")
      f_list.foreach((element:Int)=>println(element+". "+allPPL(element)))
   }

  def addUserFriend(){
    println("ADD NEW USER")
    println("Enter user ID:  ")
    val id=scala.io.StdIn.readInt()
    if(allPPL(id)==(-1))
        println("NO USER FOUND")
    else
    {
        val name=allPPL(id)
        println("Enter user ID of "+name+"'s new friend:  ")
        val f_id=scala.io.StdIn.readInt()
        val newnode=id->(allFriends(id):+f_id)
        allFriends-=id
        allFriends=allFriends+newnode
        println("USER FRIEND ADDED SUCCESSFULLY")
    }
  }

  def deleteUserFriend()
  {
    println("DELETE NEW USER")
    println("Enter user ID:  ")
    val id=scala.io.StdIn.readInt()
    if(allPPL(id)==(-1))
      println("NO USER FOUND")
    else
    {
      val name=allPPL(id)
      println("Enter user ID of "+name+"'s friend to be deleted:  ")
      val f_id=scala.io.StdIn.readInt()
      val newnode=id->(allFriends(id).filter(f_id!=_))
      allFriends-=id
      allFriends=allFriends+newnode
      println("USER FRIEND DELETED SUCCESSFULLY")
    }
  }
}
