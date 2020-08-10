package com.keep.algorithmic.week2

fun nthUglyNumber(n: Int): Int {

    var a = 0
    var b = 0
    var c = 0
    val dp = IntArray(n)
    dp[0] = 1
    for (i in 1 until n) {
        val n2 = dp[a] * 2
        val n3 = dp[b] * 3
        val n5 = dp[c] * 5
        dp[i] = Math.min(Math.min(n2, n3), n5)
        if (n2 == dp[i]) a++
        if (n3 == dp[i]) b++
        if (n5 == dp[i]) c++

    }
    return dp[n - 1]

}

fun main() {
    println(nthUglyNumber(10))
}