package com.gafis.services

import scala.actors.Actor

/**
  * Created by Administrator on 2017/10/12.
  */
class MyActor extends Actor {
  override def act: Unit = {
    println(Thread.currentThread().getName)
    for (i <- 1 to 10) {
      println("Step: " + i)
      Thread.sleep(2000)
    }
  }
}

object MyActor {
  def main(args: Array[String]): Unit = {
    val actor1 = new MyActor
    actor1.start()
  }
}

