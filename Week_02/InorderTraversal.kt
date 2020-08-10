package com.keep.algorithmic.week2

import java.util.*
import kotlin.collections.ArrayList

fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    inorderTraversalHelper(list, root)
    return list

}

fun inorderTraversal(root: TreeNode?, ans: ArrayList<Int> = ArrayList()): List<Int> {
    if (root == null) return ans
    inorderTraversal(root.left, ans)
    ans.add(root.`val`)
    inorderTraversal(root.right, ans)
    return ans

}

fun inorderTraversalHelper(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) return
    inorderTraversalHelper(list, node.left)
    list.add(node.`val`)
    inorderTraversalHelper(list, node.right)

}

/**
 *中序遍历 非递归
 */
fun inorderTraversal2(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    val stack = LinkedList<TreeNode>()
    var node = root
    while (!stack.isEmpty() || node != null) {
        if (node != null) {
            stack.push(node)
            node = node.left
        } else {
            node = stack.poll()
            list.add(node.`val`)
            node = node.right
        }


    }
    return list
}

/**
 * 中序遍历 非递归
 */
fun inorderTraversal3(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    val stack = LinkedList<TreeNode>()
    var node = root
    while (!stack.isEmpty() || node != null) {
        while (node != null) {
            stack.push(node)
            node = node.left
        }
        node = stack.pop()
        list.add(node.`val`)
        node = node.right

    }
    return list
}

/**
 * 前序遍历
 */
fun preorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    preOrderHelp(list, root)
    return list
}

fun preOrderHelp(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) return
    list.add(node.`val`)
    preOrderHelp(list, node.left)
    preOrderHelp(list, node.right)
}

fun preorderTraversal2(root: TreeNode?): List<Int> {
    val ans = ArrayList<Int>()
    val stack = LinkedList<TreeNode>()
    var node = root
    while (node != null || !stack.isEmpty()) {
        while (node != null) {
            ans.add(node.`val`)
            stack.push(node)
            node = node.left
        }
        node = stack.pop()
        node = node.right
    }
    return ans
}

fun preorderTraversal3(root: TreeNode?): List<Int> {
    val ans = ArrayList<Int>()
    val stack = LinkedList<TreeNode>()
    var node = root
    while (node != null || !stack.isEmpty()) {
        if (node != null) {
            ans.add(node.`val`)
            stack.push(node)
            node = node.left
        } else {
            node = stack.pop()
            node = node.right

        }
    }
    return ans
}


fun postorderTraversal(root: TreeNode?): List<Int> {
    val ans = ArrayList<Int>()
    postOrderHelper(ans, root)
    return ans

}

fun postOrderHelper(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) return
    postOrderHelper(list, node.left)
    postOrderHelper(list, node.right)
    list.add(node.`val`)
}

fun postorderTraversal2(root: TreeNode?): List<Int> {

    val ans = LinkedList<Int>()
    if (root == null) return ans
    val stack = LinkedList<TreeNode>()
    var node: TreeNode?
    stack.add(root)
    while (!stack.isEmpty()) {
        node = stack.pollLast()
        ans.addFirst(node.`val`)
        node.left?.let { stack.addLast(it) }
        node.right?.let { stack.addLast(it) }
    }

    return ans

}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val tree1 = TreeNode(1)
    val tree2 = TreeNode(2)
    val tree3 = TreeNode(3)
    tree1.right = tree2
    tree2.left = tree3
    println(inorderTraversal(tree1))
    println(inorderTraversal3(tree1))

    println(preorderTraversal(tree1))
    println(preorderTraversal2(tree1))
    println(preorderTraversal3(tree1))

    println(postorderTraversal(tree1))
    println(postorderTraversal2(tree1))

}