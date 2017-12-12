package question3

import org.scalatest.{FlatSpec, Matchers}

class SpiralMemorySpec extends FlatSpec with Matchers  {

  private val spiralMemory = SpiralMemory()

  it should "compute the right steps for the given squares" in {
    spiralMemory.computeStepsFromPoint(1) should be(0)
    spiralMemory.computeStepsFromPoint(12) should be(3)
    spiralMemory.computeStepsFromPoint(23) should be(2)
    spiralMemory.computeStepsFromPoint(1024) should be(31)
    spiralMemory.computeStepsFromPoint(347991) should be(480) // needs to run with VM -Xss32m
  }
}
