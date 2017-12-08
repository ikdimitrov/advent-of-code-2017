package question2

import java.io.InputStream
import scala.io.Source

class Checksum {

  def computeUsingMinMaxDifference(inputStream: InputStream) = {

      stremLines(inputStream)
        .map(findMinMaxDifference)
        .sum
  }

  def computeUsingEvenDivisorsResult(inputStream: InputStream) = {

    stremLines(inputStream)
      .map(findEvenDivisorsResult)
      .sum
  }

  def findEvenDivisorsResult(row: String): Long = {

    val numbers: Array[Long] = convertStringToDigits(row)
    val pairs: Array[(Long, Long)] = for(x <- numbers; y <- numbers if x > y) yield (x, y)

    pairs
      .par
      .filter{case (x, y) => x % y == 0}
      .map{case (x, y) => x / y}
      .sum
  }

  def findMinMaxDifference(row: String): Long = {

    val numbers = convertStringToDigits(row).sorted

    numbers.last - numbers.head
  }

  private def convertStringToDigits(row: String) = {
    row.split("\\s+")
      .map(_.toLong)
  }

  private def stremLines(inputStream: InputStream) = {
    Source.fromInputStream(inputStream).getLines
  }

}
