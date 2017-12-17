package question7

import java.io.InputStream

import scala.collection.mutable
import scala.io.Source

case class RecursiveCircus() {

  def findBottomName(inputStream: InputStream) = {

    val circusNodes = loadData(inputStream).toList
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

  def findCorrectWeight(inputStream: InputStream, rootName: String) = {
    val circusNodes = loadData(inputStream)

    val rootNode: Node = Node.generateTree(circusNodes, rootName)

    findCorrectWeightForUnbalancedNode(rootNode)._2
  }

  private def findCorrectWeightForUnbalancedNode(node: Node): (Boolean, Int) = {

    if (node.children.isDefined) {
      val tuples = node.children
        .get
        .map(node => findCorrectWeightForUnbalancedNode(node))
        .filter(t => t._1 == true)

      if (tuples.size > 0) {
        tuples.head
      }
      else computeWeightIfUnbalanced(node.children.get)
    } else {
      (false, 0)
    }

  }

  def computeWeightIfUnbalanced(nodes: List[Node]) = {

    val sortedWeights = nodes.map(n => (n.weight, n.overallWeight)).sortBy(t => t._2)
    val min = sortedWeights.head
    val max = sortedWeights.last

    (max._2 != min._2, max._1 - (max._2 - min._2))
  }

  private def loadData(inputStream: InputStream): Iterator[String] = {
    Source
      .fromInputStream(inputStream)
      .getLines
  }

}
