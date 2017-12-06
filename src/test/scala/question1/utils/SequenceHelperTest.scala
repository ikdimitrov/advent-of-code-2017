package question1.utils

import org.scalatest.{FlatSpec, Matchers}

class SequenceHelperTest extends FlatSpec with Matchers {

  private val TestInput = "1234567890"

  it should "convert string to sequence of numbers" in {
    SequenceHelper.stringToList(TestInput) should be(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))
  }

}
