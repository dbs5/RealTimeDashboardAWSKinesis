import java.nio.ByteBuffer
import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder
import com.amazonaws.services.kinesis.model.PutRecordRequest


object KinesisClient {
  val key = "YOUR-KEY"
  val secretkey = "YOUR-SECRETKEY"
  val region = "YOUR-REGION"

  val awsCreds = new BasicAWSCredentials(key, secretkey)
  val client = AmazonKinesisClientBuilder.standard()
    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    .withRegion(region)
    .build()

  def pushEvent(counter: SimpleCounter): Unit = {
    val data =s"""{"occurrenceCount":"${counter.occurrenceCount}","eventCategory":"${counter.eventCategory}","eventType":"${counter.eventType}"}"""

    val b: Array[Byte] = data.getBytes()
    val request = new PutRecordRequest
    request.setData(ByteBuffer.wrap(b))
    request.setStreamName("GatherStream")
    request.setPartitionKey(counter.eventCategory)

    val result = client.putRecord(request)
    println(result.toString)
  }
}
