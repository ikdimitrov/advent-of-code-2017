package question2

import java.io.InputStream
import org.scalatest.{FlatSpec, Matchers}

class ChecksumSpec extends FlatSpec with Matchers {

  private val checksum = new Checksum()

  it should "find (max - min) for given input" in {
    val input = "5 1 9 5"

    checksum.findMinMaxDifference(input) should be(8)
  }

  it should "compute the checksum of a small file input" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/short_input_question_2_part_1.txt")

    checksum.computeUsingMinMaxDifference(fileStream) should be(18)
  }

  it should "compute the checksum of given file input" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_2_part_1.txt")

    checksum.computeUsingMinMaxDifference(fileStream) should be(45351)
  }

  it should "find the even divisors result" in {
    val input = "5 9 2 8"

    checksum.findEvenDivisorsResult(input) should be(4)
  }

  it should "compute the checksum of a small file input based on even divisions" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/short_input_question_2_part_2.txt")

    checksum.computeUsingEvenDivisorsResult(fileStream) should be(9)
  }

  it should "compute the checksum of given file input based on even divisions" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_2_part_2.txt")

    checksum.computeUsingEvenDivisorsResult(fileStream) should be(275)
  }
}
