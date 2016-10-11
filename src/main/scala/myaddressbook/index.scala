package myaddressbook

object index extends App {
  val addressbook = new Addressbook( getClass.getResourceAsStream("/addressbook.csv") )
  
  val w = addressbook.countWomen
  val o = addressbook.oldestPerson
  val d = addressbook.getAgeDiff("Bill", "Paul")
  
  println("1. How many women are in the address book?")
  println(w + "\n")
  
  println("2. Who is the oldest person in the address book?")
  println(o + "\n")
  
  println("3. How many days older is Bill than Paul?")
  println(d.getOrElse("Konnte wegen ungültiger Datumsangabe nicht berechnet werden!\n"))
  
}