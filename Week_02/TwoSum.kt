package com.keep.algorithmic.week2

/**
 * 两数之和
 * 题目要求：你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 所以如果1个数n重复出现2次 target=2n 否则会有多个答案
 * 单次哈希 map key对应值，value对应索引位置
 * n=target-nums[i]
 * 如果n在map的key中则返回
 * 不在则将map[nums[i]]=i
 */
fun twoSum(nums: IntArray, target: Int): IntArray {

    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val n = target - nums[i]
        if (map.containsKey(n)) {
            return intArrayOf(map[n]!!, i)
        }
        map[nums[i]] = i
    }

    return intArrayOf()

}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    println(twoSum(nums, target).toList())
}