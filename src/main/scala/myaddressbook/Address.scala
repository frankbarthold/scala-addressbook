package myaddressbook
import java.time.LocalDate

case class Address(
    name: String, 
    gender: String, 
    birthday: Option[LocalDate])