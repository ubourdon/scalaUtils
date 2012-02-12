package fr.scala.util.actor

/**
 * @author ubourdon, jblemee
 * Date: 21/09/11
 */

class ActorSpy[T] {

	private var saved: T = _

	def store(saved: T) {
		this.saved = saved
	}

	def get(): T = {
		this.saved
	}
}