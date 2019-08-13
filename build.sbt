name := "Training"

version := "0.1"

scalaVersion := "2.12.0"

 
// https://mvnrepository.com/artifact/com.arangodb/arangodb-java-driver
libraryDependencies += "com.arangodb" % "arangodb-java-driver" % "5.0.7"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-http
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.1.9"

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.23"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.3"

// https://mvnrepository.com/artifact/com.arangodb/arangodb-spark-connector
libraryDependencies += "com.arangodb" %% "arangodb-spark-connector" % "1.0.11"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.3"

enablePlugins(SbtTwirl)
