import scala.util.Random

class LoginEvents extends Runnable {
  def run(): Unit = {
    while (true) {
      val loginStatus = Random.nextInt(9) match {
        case x if x < 7 => "Success"
        case 7 | 8 => "Failed"
      }

      val c = SimpleCounter("Logins", loginStatus, 1)
      KinesisClient.pushEvent(c)
      Thread.sleep(1000)
    }
  }
}