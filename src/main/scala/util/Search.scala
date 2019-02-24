package util

//import scala.annotation.tailrec

/**
  * method to perform search
  */
object Search {

  /**
    * return the index of value which is the first not less than target in ascending sorted seq nums
    * @param nums ascending sorted indexed sequence: vector, array, String, Range etc.
    * @param start start index of search range
    * @param end end index of search range
    * @param target target value to be searched
    * @tparam T element type
    * @return
    */
//  @tailrec
//  def binarySearch[T](nums: Array[T], start: Int, end: Int, target: T): Int = {
//    val mid = start + (end -  start)/2
//    if (mid == start) {
//      if (nums(mid) >= target)
//        mid
//      else
//        -1
//    }
//    else {
//      val left = binarySearch(nums, start, mid, target)
//      val right = binarySearch(nums, mid + 1, end, target)
//      if (left >= 0)
//        left
//
//    }
//  }
}
