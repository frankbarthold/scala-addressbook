name := "MyAddressBook"

version := "1.0"

scalaVersion := "2.11.0"

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.12.0"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0" % "test"
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.8.4" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")

//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")
