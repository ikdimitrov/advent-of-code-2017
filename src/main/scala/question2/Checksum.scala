package question2

import java.io.InputStream

import scala.io.Source

object Checksum {

  def apply(inputStream: InputStream) = {

    val lines: Iterator[String] = Source.fromInputStream(inputStream).getLines

    lines.map(findMinMaxDifference).sum
  }

  def findMinMaxDifference(row: String): Long = {

    val numbers = row.split("\\s+")
      .map(_.toLong)
      .sorted

    numbers.last - numbers.head
  }
}
