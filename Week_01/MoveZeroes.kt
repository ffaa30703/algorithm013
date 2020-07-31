package com.keep.algorithmic


fun main() {

}

fun moveZeroes(nums: IntArray): Unit {
    var j = 0//指向最后一个0的位置
    for (i in nums.indices) {
        if (nums[i] != 0) {
            if (i != j) {
                nums[j] = nums[i]
                nums[i] = 0
            }
            j++
        }
    }


}