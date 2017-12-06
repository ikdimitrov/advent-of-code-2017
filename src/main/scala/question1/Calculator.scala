package question1

object Calculator {

  def apply(input: List[Int]) = {

    val overall = input ::: List(input.head)

    overall.zip(overall.tail)
      .par
      .filter(subsequentElements => subsequentElements._1 == subsequentElements._2)
      .map(_._2)
      .sum
  }
}
