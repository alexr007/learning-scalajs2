Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val commonSettings = Seq(
  scalaVersion := "2.13.12",
  organization := "org.alexr",
  version := "0.1.0",
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "2.1.0",
  )
)

lazy val j01 = (project in file("j01"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(
    name := "j01",
    /** this line will run main class automatically */
    scalaJSUseMainModuleInitializer := true,
    /** if we have more than 1 class with main */
//    Compile / mainClass := Some("j01.TutorialApp"),
    libraryDependencies ++= Seq(
      "com.lihaoyi"  %%% "scalatags"   % "0.12.0",
    ),
  )

lazy val j02 = (project in file("j02"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
