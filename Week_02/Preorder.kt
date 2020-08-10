package com.keep.algorithmic.week2

import java.util.*

/**
 * N叉树的前序遍历
 */

/**
 * 递归
 */
fun preorder(root: Node?): List<Int> {
    val ans = mutableListOf<Int>()
    preOrderHelp(ans, root)

    return ans
}

fun preOrderHelp(list: MutableList<Int>, node: Node?) {
    if (node == null) return
    list.add(node.`val`)
    node.children?.let {
        for (n in it) {
            preOrderHelp(list, n)
        }
    }
}

/**
 * 迭代
 */
fun preorder2(root: Node?): List<Int> {
    val ans = mutableListOf<Int>()
    val stack = LinkedList<Node>()
    if (root == null) return ans
    stack.push(root)
    while (!stack.isEmpty()) {
        val node = stack.pop()
        ans.add(node.`val`)
        node.children.reverse()
        for (n in node.children){
            stack.push(n)
        }
    }
    return ans
}


class Node(var `val`: Int) {
    var children: MutableList<Node?> = mutableListOf()
}


fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    val node6 = Node(6)

    node1.children.add(node3)
    node1.children.add(node2)
    node1.children.add(node4)
    node3.children.add(node5)
    node3.children.add(node6)
    println(preorder(node1))
    println(preorder2(node1))

}



