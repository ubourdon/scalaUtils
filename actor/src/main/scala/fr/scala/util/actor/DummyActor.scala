package fr.scala.util.actor

import akka.actor.Actor
import org.slf4j.LoggerFactory

/**
 * @author ubourdon
 * Date: 20/09/11
 */

class DummyActor extends Actor {
	private val log = LoggerFactory.getLogger(classOf[ DummyActor ])

	protected def receive = {
		case message => log.info("dummy receive %s", message)
	}
}