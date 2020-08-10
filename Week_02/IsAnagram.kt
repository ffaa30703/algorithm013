package com.keep.algorithmic.week2

/**
 *  有效的字母异位词
 */
/**
 * 使用一个count容器，都是小写只有26个字母
 * 对第一个字符串中的字符相应位置做++
 * 对第二个字符串中的字符相应位置做--
 * 遍历count如果其中一个不为0则返回false
 */
fun isAnagram(s: String, t: String): Boolean {
    if (s == null || t == null || s.length != t.length) return false
    val count = IntArray(26) { 0 }
    for (i in s.indices) {
        count[s[i] - 'a']++
        count[t[i] - 'a']--
    }
    for (i in count) {
        if (i != 0) return false
    }

    return true
}

/**
 * 或者我们可以先用计数器表计算 s，
 * 然后用 t 减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零
 * ，我们知道 t 包含一个不在 s 中的额外字母，并立即返回 FALSE。


 */
fun isAnagram2(s: String, t: String): Boolean {
    if (s == null || t == null || s.length != t.length) return false
    val count = IntArray(26) { 0 }
    for (i in s.indices) {
        count[s[i] - 'a']++
    }
    for (i in t.indices) {
        if ((--count[t[i] - 'a']) < 0) return false
    }
    return true
}

fun main() {
    val s = "a"
    val t = "b"
    println(isAnagram2(s, t))
}