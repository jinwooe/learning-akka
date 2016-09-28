package hw1

import akka.actor.Actor
import akka.event.Logging
import hw1.messages.Message

import scala.collection.mutable

/**
  * Created by Jinwoo on 2016. 9. 28..
  */
class LastMessageStore extends Actor {
  val map = new mutable.HashMap[String, String]
  val log = Logging(context.system, this)
  override def receive = {
    case Message(str) => {
      log.info("received string - {}", str)
      map.put("last", str)
    }

    case o => log.info("received unknown message: {}", o)
  }
}
