import play.core.PlayVersion.current
import sbt._

object AppDependencies {

  val compile = Seq(
    "uk.gov.hmrc" %% "play-reactivemongo" % "6.2.0",
    "uk.gov.hmrc" %% "bootstrap-play-25"  % "3.15.0"
  )

  val test = Seq(
    "org.scalatest"          %% "scalatest"                % "3.0.4"   % "test, it",
    "com.typesafe.play"      %% "play-test"                % current   % "test, it",
    "org.pegdown"            % "pegdown"                   % "1.6.0"   % "test, it",
    "uk.gov.hmrc"            %% "service-integration-test" % "0.2.0"   % "test, it",
    "org.scalatestplus.play" %% "scalatestplus-play"       % "2.0.0"   % "test, it",
    "org.mockito"            % "mockito-all"               % "1.10.19" % "test, it"
  )

}
