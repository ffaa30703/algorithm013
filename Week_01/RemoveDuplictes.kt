package com.keep.algorithmic

import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * 删除排序数组中的重复项
 * 解题思路：
 * 前提这是一个有序的数组
 * 1、两指针 rindex 指向不同项的最后一个，i指针每次扫描如果与 nums[rindex] 不同则将这位放到
 * nums[rindex] 后面 这样指针就能把不同项放到最前面
 * rindex是最后一项的指针 所以个数 rindex+1
 *
 */


fun removeDuplicates(nums: IntArray): Int {
    val length = nums.size
    if (length == 0) return 0
    var rindex = 0
    for (i in 1 until length) {
        if (nums[rindex] != nums[i]) {
            nums[++rindex] = nums[i]
        }

    }
    return rindex + 1

}

fun removeDuplicates2(nums: IntArray): Int {
    if (nums.size < 2) return nums.size
    var sindex = 0
    for (i in 1 until nums.size) {
        if (nums[sindex] != nums[i]) {
            nums[++sindex] = nums[i]
        }
    }
    return sindex + 1
}

fun removeDuplicates3(nums: IntArray): Int {
    if (nums.size < 2) return nums.size
    var rindex = 0
    for (i in 1 until nums.size) {
        if (nums[rindex] != nums[i]) {
            nums[++rindex] = nums[i]
        }
    }

    return rindex + 1
}


@ExperimentalTime
fun main() {
    val nums: IntArray = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val time = measureTime {
        val rst = removeDuplicates(nums)
        println("rst:${rst}")
    }
    println("time:$time")


}