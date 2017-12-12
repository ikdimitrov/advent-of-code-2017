package question3

case class Coordinate(x: Long, y: Long) {

  def manhattanDistance(other: Coordinate) = {
    Math.abs(this.x - other.x) + Math.abs(this.y + other.y)
  }
}