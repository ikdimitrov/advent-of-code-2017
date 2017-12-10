package question5

import java.io.InputStream

import scala.annotation.tailrec
import scala.io.Source

case class MazeRunner() {

  @tailrec
  private def countJumpsToExit(mazeState: List[Int],
                               position: Int = 0,
                               numberOfCompletedJumps: Long = 0): Long = {
    val offset = mazeState(position)
    val newPosition = position + offset

    if (newPosition >= mazeState.length) {
      numberOfCompletedJumps + 1
    } else {
      val newMazeState = mazeState.updated(position, offset + 1)

      countJumpsToExit(newMazeState, newPosition, numberOfCompletedJumps + 1)
    }
  }

  def compute(inputStream: InputStream): Long = {
    val initialMazeState = Source.fromInputStream(inputStream).getLines.map(_.toInt).toList

    countJumpsToExit(initialMazeState)
  }

}
