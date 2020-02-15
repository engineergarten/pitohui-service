package org.engineergarten.pitohui

import cats.Monad
import cats.syntax.flatMap._

object Processes {
  def githubToStorage[F[_] : Monad](extractor: GithubExtractor[F], storage: ProjectStorage[F]): F[Unit] = {
    extractor.projects >>= storage.upsert // Todo schedule
  }
}
