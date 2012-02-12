package fr.scala.util.actor

import akka.actor.{ActorRef, Actor}


/**
 * User: ugo
 * Date: 12/02/12
 */
class TestingActor( actor: ActorRef ) extends Actor {

	def receive = {
		case message: String => actor ! "salut " + message
	}
}