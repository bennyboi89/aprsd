// Use H2Driver to connect to an H2 database
import java.util.Date
import java.sql.{ Date => SqlDate }
import slick.lifted.Tag
import java.sql.Timestamp
import slick.driver.PostgresDriver.api._


case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}


  // Definition of the Mission table
case class Mission(id: Option[Long], name: String, person: String, date: Option[Date], description: String)

class Missions(tag: Tag) extends Table[Mission](tag, "MISSION") {

  implicit val dateColumnType = MappedColumnType.base[Date, Long](d => d.getTime, d => new Date(d))

  def id = column[Int]("MISSION_ID", O.PrimaryKey, O.AutoInc) // This is the primary key column
    def name = column[String]("MISSION_NAME")
    def date = column[Date]("DATE")
    def person = column[String]("MISSING_PERSON")
    def description = column[String]("DESCRIPTION")

    // Every table needs a * projection with the same type as the table's type parameter
    def * = (id.?, name, date.?, person, description) <> (Mission.tupled, Mission.unapply _)

}
