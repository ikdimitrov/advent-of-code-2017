package question6

import org.scalatest.{FlatSpec, Matchers}

class MemoryReallocatorSpec extends FlatSpec with Matchers {

  private val memoryReallocator = MemoryReallocator()

  it should "find the max value with the respective index" in {

    memoryReallocator.findMaxWithIndexIn(Array(0, 2, 7, 0)) should be((7, 2))

    memoryReallocator.findMaxWithIndexIn(Array(7, 7, 7, 7)) should be((7, 0))
  }

  it should "compute the correct number of steps for part one small input" in {
    val testInput = Array(0, 2, 7, 0)

    memoryReallocator.computeStepsFor(testInput) should be((5, 4))
  }

  it should "compute the correct number of steps for part one big input" in {
    val testInput = Array(4,	1,	15,	12,	0,	9,	9,	5,	5,	8,	7,	3,	14,	5,	12,	3)

    memoryReallocator.computeStepsFor(testInput) should be((6681, 2392))
  }

}
