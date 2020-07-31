package com.keep.algorithmic


/**
 *  合并两个有序链表
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var nodeHead: ListNode? = null
    var ll1 = l1
    var ll2 = l2
    var i: ListNode? = null
    do {
        var n = getMin(ll1, ll2)
        if (nodeHead == null) {
            i = n
            nodeHead = i
        } else {
            i?.next = n
            i = n
        }
        if (i == ll1)
            ll1 = ll1?.next
        else
            ll2 = ll2?.next
    } while (i != null)

    return nodeHead
}

fun getMin(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    if (l1.`val` > l2.`val`)
        return l2
    else
        return l1
}


fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
    var n1 = l1
    var n2 = l2
    var rstnode = ListNode(-1)
    var i: ListNode? = rstnode
    while (n1 != null && n2 != null) {
        if (n1.`val` > n2.`val`) {
            i?.next = n2
            n2 = n2.next
        } else {
            i?.next = n1
            n1 = n1.next
        }
        i = i?.next
    }
    if (n1 == null)
        i?.next = n2
    else
        i?.next = n1
    return rstnode.next
}

fun mergeTwoLists3(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    if (l1.`val` > l2.`val`) {
        l2.next = mergeTwoLists3(l1,l2.next)
        return l2
    }else{
        l1.next= mergeTwoLists3(l1.next,l2)
        return l1
    }
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val nodel1 = ListNode(1)
    val nodel2 = ListNode(2)
    val nodel4 = ListNode(4)
    nodel1.next = nodel2
    nodel2.next = nodel4

    val noder1 = ListNode(1)
    val noder3 = ListNode(3)
    val noder4 = ListNode(4)
    noder1.next = noder3
    noder3.next = noder4

    var noderst = mergeTwoLists3(nodel1, noder1)
    while (noderst != null) {
        println(noderst.`val`)
        noderst = noderst.next
    }
}