import slick.driver.PostgresDriver.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global




trait DAOComponent {

  def insert(mission: Mission): Future[Int]
  def update(id: Long, mission: Mission): Future[Int]
  def delete(id: Long): Future[Int]
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[Mission]]
  def findById(id: Long): Future[Mission]
  def count: Future[Int]

}

object DAO extends DAOComponent {

  private val missions = TableQuery[Missions]

  private def db: Database = Database.forDataSource(DB.getDataSource())

  /**
    * Filter mission with id
    */
  private def filterQuery(id: Long): Query[Missions, Mission, Seq] =
    missions.filter(_.id === id)

  /**
    * Count missions with a filter
    */
  private def count(filter: String): Future[Int] =
    try db.run(missions.filter(_.name.toLowerCase like filter.toLowerCase()).length.result)
    finally db.close

  /**
    * Count total missions in database
    */
  override def count: Future[Int] =
    try db.run(missions.length.result)
    finally db.close

  /**
    * Find mission by id
    */
  override def findById(id: Long): Future[Mission] =
    try db.run(filterQuery(id).result.head)
    finally db.close

  /**
    * Create a new mission
    */
  override def insert(mission: Mission): Future[Int] =
    try db.run(missions += mission)
    finally db.close

  /**
    * Update mission with id
    */
  override def update(id: Long, mission: Mission): Future[Int] =
    try db.run(filterQuery(id).update(mission))
    finally db.close

  /**
    * Delete mission with id
    */
  override def delete(id: Long): Future[Int] =
    try db.run(filterQuery(id).delete)
    finally db.close

  /**
    * Return a page of missions
    */
  override def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[Mission]] = {
    try {
      val offset = pageSize * page
      val query =
        (for {
          employee <- missions if mission.name.toLowerCase like filter.toLowerCase
        } yield (mission)).drop(offset).take(pageSize)
      val totalRows = count(filter)
      val result = db.run(query.result)
      result flatMap (missions => totalRows map (rows => Page(missions, page, offset, rows)))
    } finally { db.close() }
  }

}