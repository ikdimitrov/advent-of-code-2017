package question7

import java.io.InputStream

import scala.collection.mutable
import scala.io.Source

case class RecursiveCircus() {

  def findBottomName(inputStream: InputStream) = {

    val circusNodes = loadData(inputStream)
    val allNodeNames = getAllProgramNames(circusNodes)

    circusNodes
      .filter(_.contains("->"))
      .foreach(
        line => {
          val supportingNodes = line.split(" -> ")(1)
          val supportingNodeNames = supportingNodes.split(", ").toSet
          allNodeNames.retain(element => !supportingNodeNames.contains(element))
        }
      )

    allNodeNames.head
  }

  private def getAllProgramNames(circusNodes: List[String]): mutable.Set[String] = {
    val nameArray = circusNodes
      .map(_.split(" \\(")(0))

    mutable.Set(nameArray: _*)
  }

  private def loadData(inputStream: InputStream): List[String] = {
    Source
      .fromInputStream(inputStream)
      .getLines
      .toList
  }
}
