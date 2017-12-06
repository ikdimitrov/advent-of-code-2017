package question1.utils

object SequenceHelper {

  def stringToList(number: String): List[Int] = {
    number.map(_.asDigit).toList
  }

}
