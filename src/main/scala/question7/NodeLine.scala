package question7

case class NodeLine(name: String, weight: Int, childrenNames: Option[List[String]] = None)

object NodeLine {

  val regex = "^([a-z]+) \\(([0-9]+)\\)(?: -> (.*)?)?$".r

  def apply(inputLine: String): NodeLine = {
    inputLine match {
      case regex(name, weight, childrenNames) => {

        val children = if (childrenNames == null) None
                       else Option(childrenNames.split(", ").toList)

        NodeLine(name, weight.toInt, children)
      }
    }
  }
}