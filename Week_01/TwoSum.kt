package com.keep.algorithmic

fun main() {
    val ints = intArrayOf(3, 3)
    val target = 6
    println(twoSum(ints, target)?.toList())

}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val n = target - nums[i]
        if (map.containsKey(n))
            return intArrayOf(map[n]!!, i)
        map[nums[i]] = i
    }
    return intArrayOf()
}


fun twoSum3(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val n = target - nums[i]
        if (map.containsKey(n)) {
            return intArrayOf(map[n]!!, i)
        }
        map[nums[i]] = i
    }
    return intArrayOf()


}







































