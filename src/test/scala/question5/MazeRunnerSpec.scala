package question5

import java.io.InputStream

import org.scalatest.{FlatSpec, Matchers}

class MazeRunnerSpec extends FlatSpec with Matchers {

  private val mazeRunner = MazeRunner()

  it should "compute that 5 steps are required to escape small maze" in {

    val fileStream: InputStream = getClass.getResourceAsStream("/short_input_question_5_part_1.txt")

    mazeRunner.compute(fileStream) should be(5)
  }

  it should "compute the correct steps for part one" in {

    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_5_part_1.txt")

    mazeRunner.compute(fileStream) should be(318883)
  }
}
