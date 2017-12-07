package question1

class Captcha {

  def sumSameSubsequent(input: List[Int]) = {

    val overall = input ::: List(input.head)

    overall.zip(overall.tail)
      .par
      .filter(subsequentElements => subsequentElements._1 == subsequentElements._2)
      .map(_._2)
      .sum
  }

  def sumSameHalfway(input: List[Int]) = {
    val halfway = input.length / 2

    input.zip(input.drop(halfway))
      .par
      .filter(subsequentElements => subsequentElements._1 == subsequentElements._2)
      .map(_._1 * 2)
      .sum
  }
}
