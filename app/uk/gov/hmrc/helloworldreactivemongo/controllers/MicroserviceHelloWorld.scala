package uk.gov.hmrc.helloworldreactivemongo.controllers

import javax.inject.{Inject, Singleton}
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc._
import uk.gov.hmrc.helloworldreactivemongo.services.{HelloWorld, HelloWorldRepository}
import uk.gov.hmrc.play.bootstrap.controller.BaseController

import scala.concurrent.ExecutionContext

@Singleton()
class MicroserviceHelloWorld @Inject()(repo: HelloWorldRepository)(implicit val ec: ExecutionContext)
    extends BaseController {

  def hello() = Action {
    Ok("hello-world")
  }

  def testMongo() = Action.async {
    repo.insert(HelloWorld.random).flatMap { _ =>
      repo.count.map { count =>
        val msg = s"Count of objects = $count"
        Logger.info(msg)
        Ok(Json.obj(msg -> msg))
      }
    }
  }

}
