package question6

import scala.annotation.tailrec

case class MemoryReallocator() {

  @tailrec
  private def reallocateBlocks(state: Array[Int],
                               encounteredStates: Set[Array[Int]],
                               index: Int = 0,
                               value: Int = 0,
                               cycles: Int = 0): (Long, Array[Int]) = {

    updateState(state, index, value)

    if(encounteredStates.exists(containedState => containedState.deep == state.deep)) {
      (cycles, state)
    } else {
      val (maxValue, maxIndex) = findMaxWithIndexIn(state)
      val updatedStates = encounteredStates + state.clone()
      state(maxIndex) = 0
      reallocateBlocks(state, updatedStates, maxIndex + 1, maxValue, cycles + 1)
    }

  }

  @tailrec
  private def updateState(state: Array[Int],
                          index: Int,
                          value: Int): Array[Int] = {

    if (value > 0) {
      if (index == state.length) updateState(state, 0, value)
      else {
        state(index) += 1
        updateState(state, index + 1, value - 1)
      }
    } else state

  }

  def computeStepsFor(initialState: Array[Int]): (Long, Long) = {

    val (initialCycles, state) = reallocateBlocks(initialState, Set())
    val (nextCycles, _) = reallocateBlocks(state, Set())

    (initialCycles, nextCycles)
  }

  def findMaxWithIndexIn(input: Array[Int]): (Int, Int) = {
    input
      .zipWithIndex
      .maxBy(_._1)
  }

}
