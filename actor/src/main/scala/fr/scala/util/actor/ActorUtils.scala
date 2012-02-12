package fr.scala.util.actor

import akka.actor.ActorRef

/**
 * @author ubourdon
 * Date: 26/09/11
 */

object ActorUtils {
	def stopActor(actors: ActorRef*) {
		actors.foreach(
			actor => actor.stop()
		)
	}
}