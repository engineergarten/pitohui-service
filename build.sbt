name := "pitohui"

version := "0.1"

scalaVersion := "2.13.1"

val derevo = "0.11.0"
val circeVersion = "0.12.3"
val circeDerVersion = "0.12.3"
val scalatest = "3.1.1"

val circe = Seq(
  "io.circe" %% "circe-core",
//  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion) ++ Seq(
  "io.circe" %% "circe-derivation" % "0.13.0-M2",
  "org.manatki" %% "derevo-circe" % derevo
)

val testDeps = Seq(
  "org.scalatest" %% "scalatest" % scalatest % "test"
)

libraryDependencies ++= Seq(
  "ru.tinkoff" %% "tofu" % "0.7.1"
) ++ circe ++ testDeps

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)
scalacOptions += "-Ymacro-annotations"