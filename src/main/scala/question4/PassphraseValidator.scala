package question4

import java.io.InputStream

import scala.io.Source

class PassphraseValidator {

  def checkAnagrams(testInput: String): Boolean = {

    val words = testInput.split("\\s+")

    !words.groupBy(_.sorted)
        .exists{case(_, keyMatches) => keyMatches.size > 1}
  }

  def check(testInput: String): Boolean = {

    val words = testInput.split("\\s+")

    words.distinct.size == words.size
  }

  def countValid(inputStream: InputStream, f: String => Boolean = check): Long = {

    Source.fromInputStream(inputStream)
      .getLines
      .count(line => f(line))
  }
}
