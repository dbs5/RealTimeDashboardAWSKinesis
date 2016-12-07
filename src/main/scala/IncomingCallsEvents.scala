class IncomingCallsEvents extends Runnable {
  def run(): Unit = {
    while(true){
      val c = SimpleCounter("Calls", "Calls", 1)
      KinesisClient.pushEvent(c)
      Thread.sleep(3000)
    }
  }
}