package question7

import java.io.InputStream

import org.scalatest.{FlatSpec, Matchers}

class RecursiveCircusSpec extends FlatSpec with Matchers  {

  private val recursiveCircus = RecursiveCircus()

  it should "provide the name of the bottom program for part 1 example" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/small_input_question_7_part_1.txt")

    recursiveCircus.findBottomName(fileStream) should be("tknk")
  }

  it should "provide the name of the bottom program for part 1" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_7_part_1.txt")

    recursiveCircus.findBottomName(fileStream) should be("cyrupz")
  }
}
