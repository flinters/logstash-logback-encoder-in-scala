ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "jp.co.septeni_original"
ThisBuild / organizationName := "Septeni Original, Inc."

lazy val root = (project in file("."))
  .settings(
    name := "logstash-logback-encoder-in-scala",
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "net.logstash.logback" % "logstash-logback-encoder" % "5.3",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8"
    )
  )
