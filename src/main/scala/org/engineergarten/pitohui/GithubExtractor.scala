package org.engineergarten.pitohui

import java.net.URI
import java.net.http.HttpClient.Version
import java.net.http.{HttpClient, HttpRequest}
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse.BodyHandlers
import java.time.Duration

import cats.effect.Sync
import cats.syntax.functor._
import cats.syntax.flatMap._
import io.circe._
import io.circe.parser._
import derevo.circe.decoder
import derevo.derive
import org.engineergarten.pitohui.GithubExtractor.GithubProject
import tofu.HasContext
import tofu.syntax.context._

trait GithubExtractor[F[_]] {
  def projects: F[List[Project]]
}

object GithubExtractor {
  @derive(decoder)
  case class GithubProject(
      name: String,
      `object`: GithubProjectContent
  )
  @derive(decoder)
  case class GithubProjectContent(
      text: String
  )
}

class GithubExtractorSuperTemporalSolutionHonestly[F[_]: Sync](githubToken: String) extends GithubExtractor[F] {

  private val client = HttpClient
    .newBuilder()
    .version(Version.HTTP_1_1)
    .connectTimeout(Duration.ofSeconds(20))
    .build

  private val httpReq =
    HttpRequest
      .newBuilder(URI.create("https://api.github.com/graphql"))
      .timeout(Duration.ofSeconds(30))
      .header("Authorization", s"Bearer $githubToken")
      .header("Content-Type", "application/json")
      .POST(
        BodyPublishers.ofString(
          """{"query":"{\r\n  content: repository(name: \"pitohui\", owner: \"engineergarten\") {\r\n    nameWithOwner\r\n    createdAt\r\n    description\r\n    diskUsage\r\n    object(expression: \"master:\") {\r\n      ... on Tree {\r\n        entries {\r\n          name\r\n          object {\r\n            id\r\n            ... on Blob {\r\n              text\r\n            }\r\n          }\r\n        }\r\n      }\r\n    }\r\n  }\r\n}"}"""
        )
      )
      .build

  def request: F[String] = {
    Sync[F].delay(client.send(httpReq, BodyHandlers.ofString())).map(_.body)
  }

  def splitFiles(jstr: String): Either[Error, List[GithubProject]] = {
    parse(jstr).map(
      _.hcursor.downField("data").downField("content").downField("object").downField("entries").as[List[GithubProject]]
    )
  }.flatten

  override def projects: F[List[Project]] = {
    request >>= (x => Sync[F].fromEither(splitFiles(x).map(_.filter(_.name != "README.md")))) >>= (???)
  }
}

object GithubExtractorSuperTemporalSolutionHonestly {
  case class GithubConfig(token: String)

  def Default[F[_]: *[_] HasContext GithubConfig: Sync]: F[GithubExtractorSuperTemporalSolutionHonestly[F]] = {
    hasContext[F, GithubConfig].map(x => new GithubExtractorSuperTemporalSolutionHonestly[F](x.token))
  }
}
