package com.keep.algorithmic.week1

/**
 * 接雨水
 */
fun trap(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var count = 0
    var leftMax = 0
    var rightMax = 0
    while (left < right) {
        if (height[left] < leftMax && height[left] < rightMax) {
            count += Math.min(leftMax, rightMax) - height[left]
        }
        if (height[right] < leftMax && height[right] < rightMax) {
            count += Math.min(leftMax, rightMax) - height[right]
        }
        leftMax = Math.max(leftMax, height[left])
        rightMax = Math.max(rightMax, height[right])

        if(height[left]<height[right]){
            left++
        }else{
            right--
        }
    }


    return count
}

fun main() {
    val nums = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(trap(nums))
}