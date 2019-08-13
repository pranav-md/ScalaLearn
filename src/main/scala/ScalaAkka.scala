 import java.util.Calendar

 import com.arangodb.ArangoDB
 import com.arangodb.spark.ArangoSpark
 import org.apache.spark.{SparkConf, SparkContext}
 import akka.actor.ActorSystem
 import akka.http.scaladsl.Http
 import akka.http.scaladsl.model._
 import akka.http.scaladsl.server.Directives._
 import akka.stream.ActorMaterializer
 import com.arangodb.entity.BaseDocument
 import com.arangodb.model.AqlQueryOptions
 import com.arangodb.util.MapBuilder
 import example.html.twirltry
 import main.scala.Cat

 import scala.io.StdIn

 object ScalaAkka extends App{
//    val conf = new SparkConf().setMaster("local[2]").setAppName("local")
//      .set("arangodb.host", "127.0.0.1")
//      .set("arangodb.port", "8529")
//      .set("arangodb.user", "root")
//      .set("arangodb.password", "5q9*h#PfD6HT")
//
//    val sc = new SparkContext(conf)
//
//    val rdd = ArangoSpark.load[MyBean](sc, "Employee")
//
//    ArangoSpark.save(rdd, "Employee")
//

   val arangoDB=new ArangoDB.Builder().host("127.0.0.1",8529)
                      .user("root")
                      .password("5q9*h#PfD6HT")
                      .build()


  ///The code for set up the route for http request
  implicit val system = ActorSystem("my-system")
   implicit val materializer = ActorMaterializer()
   // needed for the future flatMap/onComplete in the end
   implicit val executionContext = system.dispatcher
   var route1 =
     path("newdatabase") {
       post
       {
         var result=""
         try {
           arangoDB.createDatabase("NewDB")
           result="Success"
         }
         catch
           {
             case x:Exception=> result="Failed :"+x
           }
         complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>"+result+"</h1>"))
       }
     }

    var route2 =
   path("newcollection") {
       post
       {
         var result=""
         try {
           var myArangoCollection= arangoDB.db("NewDB").createCollection("NewCollection")
           result="Success"
         }
          catch
         {
           case x:Exception=> result="Failed :"+x
         }
         complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>"+result+"</h1>"))
       }
     }

   var route6 =
     path("twirltry") {
       get
       {
         var cats= List[Cat](new Cat("Cat1","Brown","Chicken"),new Cat("Cat2","White","Egg"),new Cat("Cat3","Black","KFC"))
         complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, twirltry.render(cats).toString()))
       }
     }

    var route3 =
   path("newdocument") {
     post
     {
       var result=""
       try {
         arangoDB.db("NewDB").collection("NewCollection").insertDocument(new MyBean)
         result="Success"
       }
       catch
         {
           case x:Exception=> result="Failed :"+x
         }
       complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>"+result+"</h1>"))
     }
     get
     {
       var result=""
       try {
         val q_db=arangoDB.db("NewDB").query("FOR coll IN NewCollection RETURN coll",null,null,classOf[String])
         result="Success "
         for(elem<- q_db) result=result+"---"+elem

       }
       catch
         {
           case x:Exception=> result="Failed :"+x
         }
       complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>"+result+"</h1>"))
     }
   }

   var route5 =
     path("newdocument") {
       post
       {
         var result=""
         try {
            val q_db=arangoDB.db("NewDB").query("FOR coll IN NewCollection RETURN coll",null,null,classOf[String])
           result="Success "+q_db
         }
         catch
           {
             case x:Exception=> result="Failed :"+x
           }
         complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>"+result+"</h1>"))
       }
     }

   var routes=route1~route2~route3~route6

   val bindingFuture = Http().bindAndHandle(routes, "localhost", 8081)
   println(s"Server online at http://localhost:8081/\nPress RETURN to stop...")
   StdIn.readLine() // let it run until user presses return
   bindingFuture
     .flatMap(_.unbind()) // trigger unbinding from the port
     .onComplete(_ => system.terminate()) // and shutdown when done
}