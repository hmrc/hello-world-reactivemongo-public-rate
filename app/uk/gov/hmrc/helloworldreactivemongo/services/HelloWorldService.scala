package uk.gov.hmrc.helloworldreactivemongo.services

import javax.inject.Inject
import play.api.Logger
import uk.gov.hmrc.helloworldreactivemongo.repositories.{HelloWorld, HelloWorldRepository}

import scala.concurrent.{ExecutionContext, Future}

class HelloWorldService @Inject()(repo: HelloWorldRepository)(implicit ec: ExecutionContext) {

  def addObjectAndCountAll(): Future[Int] =
    repo.insert(HelloWorld.random).flatMap { _ =>
      repo.count.map { count =>
        Logger.info(s"count of objects = $count")
        count
      }
    }

}
