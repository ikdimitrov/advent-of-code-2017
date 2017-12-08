package question4

import java.io.InputStream

import org.scalatest.{FlatSpec, Matchers}

class PassphraseValidatorSpec extends FlatSpec with Matchers {

  private val validator = new PassphraseValidator()

  it should "return true for valid passphrases" in {
    val testInput = "aa bb cc dd ee"
    val testInput2 = "aa bb cc dd aaa"

    validator.check(testInput) should be(true)
    validator.check(testInput2) should be(true)
  }

  it should "return false for invalid passphrases" in {
    val testInput = "aa bb cc dd aa"

    validator.check(testInput) should be(false)
  }

  it should "count the number of valid passphrases" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_4_part1.txt")

    validator.countValid(fileStream) should be(337)
  }

  it should "return true for words not anagrams of each other" in {
    val testInput = "abcde fghij"
    val testInput2 = "a ab abc abd abf abj"
    val testInput3 = "iiii oiii ooii oooi oooo"

    validator.checkAnagrams(testInput) should be(true)
    validator.checkAnagrams(testInput2) should be(true)
    validator.checkAnagrams(testInput3) should be(true)
  }

  it should "return false for words that are anagrams of each other" in {
    val testInput = "abcde xyz ecdab"
    val testInput2 = "oiii ioii iioi iiio"

    validator.checkAnagrams(testInput) should be(false)
    validator.checkAnagrams(testInput2) should be(false)
  }

  it should "count the number of valid passphrases in the anagrams case" in {
    val fileStream: InputStream = getClass.getResourceAsStream("/input_question_4_part2.txt")

    validator.countValid(fileStream, validator.checkAnagrams) should be(231)
  }
}
