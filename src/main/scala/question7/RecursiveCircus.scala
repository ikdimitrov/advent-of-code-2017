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

    findCorrectWeightForUnbalancedNode(rootNode)
  }

  private def findCorrectWeightForUnbalancedNode(node: Node, imbalance: Int = 0): Int = {

    if (imbalance != 0 && checkChildrenBalanced(node)) {
      node.weight - imbalance
    } else {
      val mostCommonOverallWeight = node.children.get.groupBy(n => n.overallWeight).maxBy(_._2.size)._1
      val badNode = node.children.get.find(t => t.overallWeight != mostCommonOverallWeight).get
      findCorrectWeightForUnbalancedNode(badNode, Math.abs(badNode.overallWeight - mostCommonOverallWeight))
    }

  }

  def checkChildrenBalanced(node: Node): Boolean = {
    if (node.children.isDefined) {
      node.children.get.map(_.overallWeight).distinct.size == 1
    } else true
  }

  private def loadData(inputStream: InputStream): Iterator[String] = {
    Source
      .fromInputStream(inputStream)
      .getLines
  }

}
