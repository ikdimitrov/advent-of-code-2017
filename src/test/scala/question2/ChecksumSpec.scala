package question2

import java.io.InputStream

import org.scalatest.{FlatSpec, Matchers}

class ChecksumSpec extends FlatSpec with Matchers {

  it should "find (max - min) for given input" in {
    val input = "5 1 9 5"

    Checksum.findMinMaxDifference(input) should be(8)
  }

  it should "compute the checksum of a small file input" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/short_input_question_2.txt")

    Checksum(fileStream) should be(18)
  }

  it should "compute the checksum of given file input" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_2.txt")

    Checksum(fileStream) should be(45351)
  }

}
