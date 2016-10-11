package myaddressbook

import scala.io.Source
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.language.implicitConversions

class Addressbook(val addresses: Array[Address]) {
  
  def countWomen = addresses.filter(_.gender == "Female").length
  
  def oldestPerson = addresses.reduceLeft( (a, b) => {
    if (a.birthday.nonEmpty && b.birthday.nonEmpty) {
      if (a.birthday.get isBefore b.birthday.get) a else b
    }
    else {
      if (a.birthday.nonEmpty) a else b
    }
  })
  
  def this(lines: Array[String]) {
    this( for{
      line <- lines
      if !line.trim.isEmpty   
      if (line + " ").split(",").length > 2
    } yield {
      val cols = (line + " ").split(",").map(_.trim)
      Address(cols(0), cols(1), cols(2))
    })
  }
  
  def this(file: String) {
    this(Source.fromFile(file).getLines.toArray)
  }
  
  def this(stream: java.io.InputStream) {
    this( Source.fromInputStream( stream ).getLines.toArray )
  }
  
  def this() {
    this( getClass.getResourceAsStream("/addressbook.csv")  )
  }
  
  def getAgeDiff(person1Name:String, person2Name:String):Option[Long] = {
    val p1 = getPerson(person1Name)
    val p2 = getPerson(person2Name)
    if (p1.nonEmpty && p2.nonEmpty
        && p1.get.birthday.nonEmpty && p2.get.birthday.nonEmpty ) {
      Some(p1.get.birthday.get minus p2.get.birthday.get)
    } else None;
  }
  
  implicit def getPerson(name: String):Option[Address] = {
    addresses.getByName(name)
  }
}

object Addressbook {
  def apply = new Addressbook
}