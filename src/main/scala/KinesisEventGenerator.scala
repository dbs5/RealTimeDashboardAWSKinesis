object KinesisEventGenerator {

  def main(args: Array[String]): Unit = {

    val carThread = new Thread(new CarEvents())
    carThread.start()

    val loginThread = new Thread(new LoginEvents())
    loginThread.start()

    val callsThread = new Thread(new IncomingCallsEvents())
    callsThread.start()

  }
}