package question3

import org.scalatest.{FlatSpec, Matchers}

class CoordinateSpec extends FlatSpec with Matchers {

  it should "compute the correct manhattan distance" in {
    val c1 = Coordinate(0, 0)
    val c2 = Coordinate(1, 0)
    val c3 = Coordinate(1, 1)

    c1.manhattanDistance(c2) should be(1)
    c1.manhattanDistance(c3) should be(2)
  }
}

