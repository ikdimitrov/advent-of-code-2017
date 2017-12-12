package question3

case class SpiralMemory() {

  def computeStepsFromPoint(point: Long) = {
    val x = calculateXCoordinate(point)
    val y = calculateYCoordinate(point)

    Coordinate(x, y).manhattanDistance(Coordinate(0, 0))
  }

  private def calculateXCoordinate(point: Long): Long = {
    if (point == 0) 0
    else {
      val k = (Math.floor(Math.sqrt(4.0 * (point - 2) + 1)) % 4)
      calculateXCoordinate(point - 1) + Math.sin(k * Math.PI / 2).toLong
    }
  }

  private def calculateYCoordinate(point: Long): Long = {
    if (point == 0) 0
    else {
      val k = (Math.floor(Math.sqrt(4.0 * (point - 2) + 1)) % 4)
      calculateYCoordinate(point - 1) + Math.cos(k * Math.PI / 2).toLong
    }
  }
}
