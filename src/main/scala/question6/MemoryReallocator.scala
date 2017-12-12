package question6

import scala.annotation.tailrec

case class MemoryReallocator() {

  @tailrec
  private def reallocateBlocks(state: Array[Int],
                               encounteredStates: Set[Array[Int]],
                               index: Int = 0,
                               value: Int = 0,
                               cycles: Int = 0): Long = {
    var i = index
    var acc = value
    while(acc > 0) {
      if (i == state.length) i = 0
      state(i) += 1
      i += 1
      acc -= 1
    }

    if(encounteredStates.exists(containedState => containedState.deep == state.deep)) {
      cycles
    } else {
      val (maxValue, maxIndex) = findMaxWithIndexIn(state)
      val updatedStates = encounteredStates + state.clone()
      state(maxIndex) = 0
      reallocateBlocks(state, updatedStates, maxIndex + 1, maxValue, cycles + 1)
    }

  }

  def computeStepsFor(initialState: Array[Int]): Long = {
    reallocateBlocks(initialState, Set())
  }

  def findMaxWithIndexIn(input: Array[Int]): (Int, Int) = {
    input
      .zipWithIndex
      .maxBy(_._1)
  }

}
