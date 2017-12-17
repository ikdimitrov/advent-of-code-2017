package question7

case class Node(name: String, weight: Int = 0, children: Option[List[Node]] = None) {

  def overallWeight = {
    weight + children.getOrElse(List()).foldLeft(0)((accumulated, c2) => {
      accumulated + c2.weight
    })
  }
}

object Node {

  def generateTree(inputStream: Iterator[String],
                   rootName: String): Node = {

    val nodeLineMap = inputStream
      .map(line => NodeLine(line))
      .map(nodeLine => nodeLine.name -> nodeLine)
      .toMap

    val finalMap = nodeLineMap.map {
      case (name, nodeLine) => {
        val childrenNodes = nodeLine
          .childrenNames
          .map(l => l.map(name => buildTree(name, nodeLineMap)))

        name -> Node(name, nodeLine.weight, childrenNodes)
      }
    }

    finalMap.get(rootName).get
  }

  private def buildTree(name: String, map: Map[String, NodeLine]): Node = {
    val nodeLine: NodeLine = map.get(name).get

    if(nodeLine.childrenNames.isDefined) {
      val children = nodeLine.childrenNames
        .map(l => l.map(childName => buildTree(childName, map)))

      Node(nodeLine.name, nodeLine.weight, children)
    } else Node(nodeLine.name, nodeLine.weight, None)
  }
}
