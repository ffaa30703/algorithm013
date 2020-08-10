package com.keep.algorithmic.week2

import com.keep.algorithmic.mergeTwoLists
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/**
 * 方法一：对每个字符创进行排序，排序相同的则是字母异位词
 * 时间复杂度O(NKlogK)
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val rstMap = mutableMapOf<String, MutableList<String>>()
    for (item in strs) {
        val s = item.toCharArray()
        s.sort()
        val key = String(s)
        if (!rstMap.containsKey(key)) {
            rstMap[key] = mutableListOf()
        }
        rstMap[key]!!.add(item)
    }
    return ArrayList(rstMap.values)
}

/**
 *安计数器分类
 */
fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val rstMap = mutableMapOf<String, MutableList<String>>()
    var count = IntArray(26)
    val builder = StringBuilder()
    for (item in strs) {
        val chars = item.toCharArray()
        Arrays.fill(count, 0);
        builder.clear()
        for (c in chars) {
            count[c - 'a']++
        }
        for (n in count) {
            builder.append("#$n")
        }
        val key = builder.toString()
        if (!rstMap.containsKey(key)) {
            rstMap[key] = mutableListOf()
        }
        rstMap[key]?.add(item)

    }




    return rstMap.values.toList()
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagrams(strs))
    println(groupAnagrams2(strs))
}