lazy val rcVersion = "3.0.0-RC2"
lazy val crossVersions = Seq(Option(rcVersion), dottyLatestNightlyBuild()).flatten
lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-example-project",
    description := "Example sbt project that compiles using Scala 3",
    version := "0.1.0",
    scalaVersion := rcVersion,
    crossScalaVersions := crossVersions,
    useScala3doc := true,
    skip in publish := true
  )

ThisBuild / githubWorkflowJavaVersions := Seq("adopt@1.8.0-275", "adopt@1.11.0-9", "adopt@1.15.0-1")
ThisBuild / githubWorkflowScalaVersions := crossVersions
ThisBuild / githubWorkflowBuildPreamble ++= Seq(WorkflowStep.Sbt(List("run")))
ThisBuild / githubWorkflowPublishTargetBranches := Nil
Global / onChangedBuildSource := ReloadOnSourceChanges
