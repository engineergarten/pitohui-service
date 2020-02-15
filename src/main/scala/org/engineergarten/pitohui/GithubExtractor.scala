package org.engineergarten.pitohui

trait GithubExtractor[F[_]] {
  def projects: F[List[Project]]
}
