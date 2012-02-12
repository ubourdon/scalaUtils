package fr.scala.util.actor

import akka.actor.{Actor, ActorRef}
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.jayway.awaitility.Awaitility._
import com.jayway.awaitility.scala.AwaitilitySupport


/**
 * User: ugo
 * Date: 12/02/12
 */

class ActorTestingTest extends FunSuite with ShouldMatchers with AwaitilitySupport {

	test( "simple actor testing with string message" ) {
		val actorSpy: ActorSpy[String] = new ActorSpy[String]
		val testDoubleDependency: ActorRef = Actor.actorOf( new ActorStub(actorSpy) ).start()		
		
		val underTestActor: ActorRef = Actor.actorOf( new TestingActor( testDoubleDependency ) ).start()

		underTestActor ! "toto"

		Thread.sleep( 100 )

		actorSpy.get should be ( "salut toto" )
	}
	
	test( "simple actor testing with awaitility support rather than Thread.sleep" ) {
		val actorSpy: ActorSpy[String] = new ActorSpy[String]
		val testDoubleDependency: ActorRef = Actor.actorOf( new ActorStub(actorSpy) ).start()

		val underTestActor: ActorRef = Actor.actorOf( new TestingActor( testDoubleDependency ) ).start()

		underTestActor ! "toto"

		await until { receiveMsg( actorSpy ) }

		actorSpy.get should be ( "salut toto" )
	}

	def receiveMsg( spy: ActorSpy[String] ): Boolean = spy.get() != null
}