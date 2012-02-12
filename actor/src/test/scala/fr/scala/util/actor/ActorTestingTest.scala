package fr.scala.util.actor

import akka.actor.{Actor, ActorRef}
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers


/**
 * User: ugo
 * Date: 12/02/12
 */

class ActorTestingTest extends FunSuite with ShouldMatchers {

	test("simple actor testing with string message") {
		val actorSpy: ActorSpy[String] = new ActorSpy[String]
		val testDoubleDependency: ActorRef = Actor.actorOf( new ActorStub(actorSpy) ).start()		
		
		val underTestActor: ActorRef = Actor.actorOf( new TestingActor( testDoubleDependency ) ).start()

		underTestActor ! "toto"

		Thread.sleep( 100 )

		actorSpy.get should be ( "salut toto" )

		/*val actorSpy: ActorSpy[InstallUpdateFail] = new ActorSpy[InstallUpdateFail]
		testDoubleRouter = Actor.actorOf(new ActorStub(actorSpy)).start()

		val updater: Updater = mock(classOf[Updater])
		when(updater.installUpdate(Matchers.any[Update])).thenThrow(new RuntimeException())

		val expectedUpdate: Update = new UpdateBuilder().id(1).toUpdate

		updaterActor = Actor.actorOf(new UpdaterActor(updater)).start()
		updaterActor ! UpdaterStart(testDoubleRouter)

		updaterActor ! InstallUpdate(expectedUpdate)

		Thread.sleep(100)

		actorSpy.get.update.id should be(expectedUpdate.id)*/
	}
}