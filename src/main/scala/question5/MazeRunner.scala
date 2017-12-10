package question5

import java.io.InputStream

import scala.annotation.tailrec
import scala.io.Source

case class MazeRunner() {

  @tailrec
  private def countJumpsToExit(mazeState: List[Int],
                               position: Int,
                               numberOfCompletedJumps: Long,
                               valueCalculator: Int => Int): Long = {
    val offset = mazeState(position)
    val newPosition = position + offset

    if (newPosition >= mazeState.length) {
      numberOfCompletedJumps + 1
    } else {
      val newMazeState = mazeState.updated(position, valueCalculator(offset))

      countJumpsToExit(newMazeState, newPosition, numberOfCompletedJumps + 1, valueCalculator)
    }
  }

  private def incrementDependingOnPositionValue(list: List[Int], position: Int, value: Int): List[Int] = {
    val newValue = if (value >= 3) value - 1 ; else value + 1
    list.updated(position, newValue)
  }

  def computePart1(inputStream: InputStream): Long = {
    val initialMazeState = Source.fromInputStream(inputStream).getLines.map(_.toInt).toList

    countJumpsToExit(initialMazeState, 0, 0, value => value + 1)
  }

  def computePart2(inputStream: InputStream): Long = {
    val initialMazeState = Source.fromInputStream(inputStream).getLines.map(_.toInt).toList

    countJumpsToExit(initialMazeState, 0, 0, value => {if (value >= 3) value - 1 ; else value + 1})
  }

}
