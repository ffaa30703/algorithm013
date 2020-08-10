package com.keep.algorithmic.week2

import java.util.*
import kotlin.collections.ArrayList

class LevelOrder {

    class Node(var `val`: Int) {
        var children: MutableList<Node?> = mutableListOf()
    }

    companion object {
        private fun levelOrder(root: Node?): List<List<Int>> {
            val list = ArrayList<List<Int>>()
            if (root == null) return list
            val stack = LinkedList<Node>()
            stack.add(root)
            while (!stack.isEmpty()) {
                val size = stack.size
                val level = ArrayList<Int>()
                for (i in 0 until size) {
                    val node = stack.pollFirst()
                    level.add(node.`val`)
                    node.children?.forEach {
                        it?.let { stack.add(it) }
                    }

                }
                list.add(level)
            }
            return list
        }

        @JvmStatic
        fun main(args: Array<String>) {
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
            println(levelOrder(node1))

        }
    }

}