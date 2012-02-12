package fr.scala.util.actor

import akka.actor.Actor
import org.slf4j.LoggerFactory


/**
 * @author ubourdon
 * Date: 21/09/11
 */

class ActorStub[T]( spy: ActorSpy[ T ] ) extends Actor {
	private val log = LoggerFactory.getLogger( classOf[ActorStub[T]] )

	def receive = {
		case message: T => spy.store( message )
		case _ => log.warn( "Wrong Type" )
	}
}