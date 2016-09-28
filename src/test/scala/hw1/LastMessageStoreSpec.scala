package hw1

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import hw1.messages.Message
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

/**
  * Created by Jinwoo on 2016. 9. 28..
  */
class LastMessageStoreSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {
  implicit val system = ActorSystem()

  describe("akkademyDb") {
    describe("given SetRequest") {
      it("should place key/value into map") {
        val actorRef = TestActorRef(new LastMessageStore)
        actorRef ! Message("hello")
        actorRef ! Message("world")
        val lastMessageStore = actorRef.underlyingActor
        lastMessageStore.map.get("last") should equal (Some("world"))
      }
    }
  }
}
