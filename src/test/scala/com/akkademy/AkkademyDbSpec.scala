package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkademy.messages.SetRequest
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

/**
  * Created by dibakar on 3/6/19.
  */
class AkkademyDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {


  implicit val system: ActorSystem = ActorSystem()

  describe("akkademyDb") {
    describe("given SetRequest") {

      it ("should place key/value into map") {
        val actorRef: TestActorRef[AkkademyDb] = TestActorRef(new AkkademyDb)

        actorRef ! SetRequest("key", "value")

        val akkademyDb: AkkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal (Some("value"))
      }
    }
  }
}
