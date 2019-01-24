package com.iwenchaos.mdualgor.tree;

/**
 * Created by chaos
 * on 2019/1/24. 17:34
 * 文件描述：通过有序数组，生成平衡搜索二叉树
 * <p>
 * 算法：用有序数组的最中间的数 生成搜索二叉树的根节点
 * 然后用这个数左边的数生成左子树，用右边的数生成右子树
 */
public class SortedArrGenTreeAlgo {


    public static TreeNode generateTree(int[] sortedArr) {
        if (sortedArr == null) {
            return null;
        }
        return generate(sortedArr, 0, sortedArr.length - 1);
    }

    private static TreeNode generate(int[] sortedArr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = generate(sortedArr, start, mid - 1);
        root.right = generate(sortedArr, mid + 1, end);
        return root;

    }

}
