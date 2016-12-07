import scala.util.Random

class CarEvents extends Runnable {
  def run(): Unit = {
    while (true) {
      val ample = Random.nextInt(10) match {
        case x if x < 7 => "Red"
        case 7 | 8 => "Green"
        case 9 => "Yellow"
      }

      val c = SimpleCounter("Ample", ample, 3)
      KinesisClient.pushEvent(c)
      Thread.sleep(1000)
    }
  }
}