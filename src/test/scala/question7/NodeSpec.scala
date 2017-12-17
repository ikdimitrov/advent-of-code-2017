package question7

import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

class NodeSpec extends FlatSpec with Matchers {

  it should "generate a tree from given short input" in {

    val inputStream = getClass.getResourceAsStream("/short_input_question_7_part_1.txt")
    val lines = Source.fromInputStream(inputStream).getLines

    val expected = "Node(tknk,41,Some(List(Node(ugml,68,Some(List(Node(gyxo,61,None), Node(ebii,61,None), Node(jptl,61,None)))), Node(padx,45,Some(List(Node(pbga,66,None), Node(havc,66,None), Node(qoyq,66,None)))), Node(fwft,72,Some(List(Node(ktlj,57,None), Node(cntj,57,None), Node(xhth,57,None)))))))"
    Node.generateTree(lines, "tknk").toString should be(expected)
  }

  it should "compute the correct node weight" in {
    val inputNode = Node("ugml", 68, Some(List(Node("gyxo", 61, None), Node("ebii", 61, None), Node("jptl", 61, None))))

    inputNode.overallWeight should be(251)
  }
}
