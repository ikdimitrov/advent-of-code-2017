package question7

import org.scalatest.{FlatSpec, Matchers}

class NodeLineSpec extends FlatSpec with Matchers {

  it should "construct the expected node" in {

    NodeLine("fwft (72) -> ktlj, cntj, xhth") should be(NodeLine("fwft", 72, Option(List("ktlj", "cntj", "xhth"))))
    NodeLine("fwft (72)") should be(NodeLine("fwft", 72, None))
  }

}
