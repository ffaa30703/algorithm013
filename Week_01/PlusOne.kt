package com.keep.algorithmic


fun plusOne(digits: IntArray): IntArray {
    var a = 0
    for (i in (digits.size - 1) downTo 0) {
        digits[i]++
        a = digits[i]
        digits[i] = digits[i] % 10
        if (a < 10) break
    }
    return if (a > 0) {
        val n = digits.toMutableList()
        n.add(0, 1)
        n.toIntArray()
    } else {
        digits
    }

}

fun main() {
    val digits = intArrayOf(9, 9, 9)
    plusOne(digits)
    println(digits.toList())
}

