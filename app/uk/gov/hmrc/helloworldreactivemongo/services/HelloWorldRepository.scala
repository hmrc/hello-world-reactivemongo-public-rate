package uk.gov.hmrc.helloworldreactivemongo.services

import java.util.UUID

import javax.inject.Inject
import play.api.libs.json.{Json, OFormat}
import play.modules.reactivemongo.ReactiveMongoComponent
import uk.gov.hmrc.mongo.ReactiveRepository

import scala.concurrent.ExecutionContext

final case class HelloWorld(foo: String)

object HelloWorld {

  def random = HelloWorld(UUID.randomUUID().toString)

  implicit val format: OFormat[HelloWorld] = Json.format[HelloWorld]

}

class HelloWorldRepository @Inject()(reactiveMongoComponent: ReactiveMongoComponent)(implicit val ec: ExecutionContext)
    extends ReactiveRepository("hello-world", reactiveMongoComponent.mongoConnector.db, HelloWorld.format)
