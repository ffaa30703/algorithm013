package com.keep.java.week3;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || (inorder.length != preorder.length) || inorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildHelp(preorder, inorder, 0, preorder.length - 1,0, inorder.length - 1);
    }

    public TreeNode buildHelp(int[] preorder, int[] inorder, int pOrderStart, int pOrderEnd, int inOrderLeft, int inOrderRight) {
        if (pOrderStart > pOrderEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pOrderStart]);
        int inOrderIndex = map.get(preorder[pOrderStart]);
        int leftChildCount = inOrderIndex - inOrderLeft;

        int lStart = pOrderStart + 1;
        int lEnd = pOrderStart + leftChildCount;

        int rStart = pOrderStart + leftChildCount + 1;
        int rEnd = pOrderEnd;
        if (leftChildCount != 0)
            node.left = buildHelp(preorder, inorder, lStart, lEnd, inOrderLeft, inOrderIndex - 1);
        node.right = buildHelp(preorder, inorder, rStart, rEnd, inOrderIndex + 1, inOrderRight);
        return node;

    }


    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2,};
        int[] inorder = new int[]{2, 1};

        TreeNode node = new BuildTree().buildTree(preorder, inorder);
        System.out.println(node.val);

    }

}
