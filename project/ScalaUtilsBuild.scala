import sbt._
import Keys._

/**
 * User: ugo
 * Date: 12/02/12
 */

object ScalaUtilsBuild extends Build {

	name := "scalaUtils"

	version := "0.1"

	scalaVersion := "2.9.1"

	retrieveManaged := true

	lazy val root = Project( id = "scalaUtils",
		base = file( "." ) ) aggregate( collection, actor )

	lazy val collection = Project( id = "scalaUtils-collection", base = file( "collection" ) )

	lazy val actor = Project( id = "scalaUtils-actor", base = file( "actor" ) )
}