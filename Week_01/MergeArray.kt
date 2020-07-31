package me.hgj.jetpackmvvm.demo.data.model.bean

/**
 *
 * 合并两个有序数组
 *  author : Jiyf
 *  e-mail : ffaa30703@icloud.com
 *  time   : 2020/07/29
 *  desc   :
 *  version: 1.0
 *
 */


fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var count = m + n
    var i = count - 1
    var n1 = m - 1
    var n2 = n - 1
    var temp = 0
    while (i >= 0) {
        if (n1 < 0 && n2 < 0)
            break
        if (n1 < 0 || n2 < 0) {
            if (n1 < 0) {
                temp = nums2[n2]
                n2--
            } else {
                temp = nums1[n1]
                n1--
            }
        } else {
            if (nums1[n1] > nums2[n2]) {
                temp = nums1[n1]
                n1--
            } else {
                temp = nums2[n2]
                n2--
            }
        }

        nums1[i] = temp
        i--
    }


}

fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    if (m <= 0 && n <= 0) {
        return
    }

    if (m > 0 && n > 0) {
        if (nums1[m - 1] > nums2[n - 1]) {
            nums1[n + m - 1] = nums1[m - 1]
            merge2(nums1, m - 1, nums2, n)
        } else {
            nums1[n + m - 1] = nums2[n - 1]
            merge2(nums1, m, nums2, n - 1)
        }
    } else {
        if (m < 0) {
            nums1[n - 1] = nums2[n - 1]
            merge2(nums1, m, nums2, n - 1)
        } else {
            nums1[m - 1] = nums1[m - 1]
            merge2(nums1, m - 1, nums2, n)
        }
    }

}

fun merge3(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

}


fun main() {

    var nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    var nums2 = intArrayOf(2, 5, 6)
    merge2(nums1, 3, nums2, 3)
    println(nums1.toList())
}