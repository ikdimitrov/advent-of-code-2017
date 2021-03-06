package question7

import java.io.InputStream

import org.scalatest.{FlatSpec, Matchers}

class RecursiveCircusSpec extends FlatSpec with Matchers {

  private val recursiveCircus = RecursiveCircus()

  it should "provide the name of the bottom program for part 1 example" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/short_input_question_7_part_1.txt")

    recursiveCircus.findBottomName(fileStream) should be("tknk")
  }

  it should "provide the name of the bottom program for part 1" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_7_part_1.txt")

    recursiveCircus.findBottomName(fileStream) should be("cyrupz")
  }

  it should "check if list if list is unbalanced and give correct weight" in {
    val correctNodes = Node("a", 2, Some(List(Node("gyxo", 61, None), Node("ebii", 61, None), Node("jptl", 61, None))))

    recursiveCircus.checkChildrenBalanced(correctNodes) should be(true)

    val incorrectNodes = Node("a", 3, Some(List(Node("gyxo", 61, None), Node("ebii", 80, None), Node("jptl", 61, None))))
    recursiveCircus.checkChildrenBalanced(incorrectNodes) should be(false)
  }

  it should "find the correct weight of a node for balancing in part 2 example" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/short_input_question_7_part_1.txt")

    recursiveCircus.findCorrectWeight(fileStream, "tknk") should be(60)
  }

  it should "find the correct weight of a node for balancing in part 2 overall input that is same as part 1" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_7_part_1.txt")

    recursiveCircus.findCorrectWeight(fileStream, "cyrupz") should be(11690)
  }
}
