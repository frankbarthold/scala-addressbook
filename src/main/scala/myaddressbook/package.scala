import scala.language.implicitConversions
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.{TemporalAmount, ChronoUnit}

package object myaddressbook {
  
    val dateFormatterENShort = DateTimeFormatter.ofPattern("dd/MM/yy")
    val dateFormatterENLong = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dateFormatterDEShort = DateTimeFormatter.ofPattern("dd.MM.yy")
    val dateFormatterDELong = DateTimeFormatter.ofPattern("dd.MM.yyyy")    
    val dateFormatterISO = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    
    
    val datePatternENShort = """(\d\d)/(\d\d)/(\d\d)""".r
    val datePatternENLong  = """(\d\d)/(\d\d)/(\d\d\d\d)""".r
    val datePatternDEShort = """(\d\d).(\d\d).(\d\d)""".r
    val datePatternDELong  = """(\d\d).(\d\d).(\d\d\d\d)""".r
    val datePatternISO     = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
    
    implicit def getLocalDate(text: String): Option[LocalDate] = {
      text match {
        case datePatternENShort(d,m,y) => Some(LocalDate.parse(text, dateFormatterENShort))
        case datePatternENLong(d,m,y)  => Some(LocalDate.parse(text, dateFormatterENLong))
        case datePatternDEShort(d,m,y) => Some(LocalDate.parse(text, dateFormatterDEShort))
        case datePatternDELong(d,m,y) => Some(LocalDate.parse(text, dateFormatterDELong))
        case datePatternISO(d,m,y) => Some(LocalDate.parse(text, dateFormatterISO))
        case _ => None
      }
    }
    
    implicit class AddressesUtils(addresses: Array[Address]) {
      def getByName(name: String): Option[Address] = {
        val i = addresses.indexWhere(_.name.startsWith(name))
        if (i > -1) Some(addresses(i)) else None
      }
    }
    
    implicit class LocalDateUtils(thisDate: LocalDate) {
      def minus(otherDate:LocalDate):Long = {
        ChronoUnit.DAYS.between(thisDate, otherDate)
      }
      
      def -(otherDate:LocalDate) = minus(otherDate)
    }
}