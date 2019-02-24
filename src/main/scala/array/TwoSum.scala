package array

import scala.collection.mutable
import scala.util.control.Breaks

object TwoSum extends App {

  val TestCase = Array((Array(4, -1, 0, -10, 5, 2, 7, 6, 1, 9), 6),
                       (Array(8, -1, 3, 4, 2, 9), 5),
                       (Array(3, 4, -10, 2, 9, -1), 8))

  val TestCaseSorted = Array((Array(-10, -1, 0, 1, 2, 4, 5, 6, 7, 9), 6),
                             (Array(-1, 2, 3, 4, 8, 9), 5),
                             (Array(-10, -1, 2, 3, 4, 9), 8))

  println("[Two Sum]")
  TestCase.foreach { test =>
    val result = levelIUseHash(test._1, test._2)
    println(s"Array: ${test._1.mkString(" ")}, Target: ${test._2}")
    println(s"Solution: [${result(0)}, ${result(1)}]")
  }

  println("[Two Sum II - Input array is sorted]")
  TestCaseSorted.foreach { test =>
    val result = levelIIInputArrayIsSorted(test._1, test._2)
    println(s"Array: ${test._1.mkString(" ")}, Target: ${test._2}")
    println(s"Solution: [${result(0)}, ${result(1)}]")
  }

  /**
    * Given an array of integers, find two numbers such that they add up to a specific target number.
    * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
    * Note:
    *
    * Your returned answers (both index1 and index2) are not zero-based.
    * You may assume that each input would have exactly one solution and you may not use the same element twice.
    *
    * @param nums input array
    * @param target target sum
    * @return answers
    */
  def levelIUseHash(nums: Array[Int], target: Int): Array[Int] = {
    val result = Array(0, 0)
    val numsHash = new mutable.HashMap[Int, Int]()
    val find = new Breaks
    find.breakable {
      for (idx <- nums.indices) {
        val targetIdx = numsHash.getOrElse(target - nums(idx), -1)
        if (targetIdx >= 0) {
          result(0) = targetIdx
          result(1) = idx
          find.break
        } else
          numsHash.put(nums(idx), idx)
      }
    }
    result
  }

  /**
    * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
    * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
    * Note:
    *
    * Your returned answers (both index1 and index2) are not zero-based.
    * You may assume that each input would have exactly one solution and you may not use the same element twice.
    *
    * @param nums input array
    * @param target target sum
    * @return index of answer
    */
  def levelIIInputArrayIsSorted(nums: Array[Int], target: Int): Array[Int] = {
    val result = Array(0, 0)
    val find = new Breaks
    find.breakable {
      var lowerIdx, biggerIdx = 0
      val midVal = target/2
      while (lowerIdx < nums.length && nums(lowerIdx) <= midVal) {
          biggerIdx = lowerIdx + 1
          val upperVal = target - nums(lowerIdx)
          while (biggerIdx < nums.length && nums(biggerIdx) <= upperVal) {
            if (nums(biggerIdx) == upperVal) {
              result(0) = lowerIdx + 1
              result(1) = biggerIdx + 1
              find.break
            }
            biggerIdx += 1
          }
          lowerIdx += 1
      }
    }
    result
  }
}
