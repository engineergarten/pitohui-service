package org.engineergarten.pitohui

trait ProjectStorage[F[_]] {
  def upsert(projects: List[Project]): F[Unit]
  def projects: F[List[Project]]
}
