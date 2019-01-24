package com.iwenchaos.mdualgor.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chaos
 * on 2019/1/24. 09:59
 * 文件描述：二叉树的序列化和反序列化
 * <p>
 * 1. 先给出序列化方案  每个节点 为 值!
 * 如果节点为null，则 #!
 */
public class SerializeTreeAlgo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        createBinTree(root);
        System.out.print(serialize2(root));
//        preorderTraverse(root);
    }

    public static void createBinTree(TreeNode root) {
        TreeNode newNodeB = new TreeNode(2);
        TreeNode newNodeC = new TreeNode(3);
        TreeNode newNodeD = new TreeNode(4);
        TreeNode newNodeE = new TreeNode(5);
        TreeNode newNodeF = new TreeNode(6);
        root.left = newNodeB;
        root.right = newNodeC;
        root.left.left = newNodeD;
        root.left.right = newNodeE;
        root.right.right = newNodeF;
    }

    /**
     * 这里使用深度遍历的先序遍历方式  根-左-右
     */
    public static String serialize(TreeNode root) {
        if (root == null) return "#!";
        String res = root.value + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }


    /**
     * 这里不用递归的方式，进行先序遍历
     */
    public static String serialize2(TreeNode root) {
        if (root == null) return "#!";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            sb.append(root.value).append("!");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return sb.toString();
    }


    /**
     * 反序列化
     * <p>
     * 使用队列的方式，先进先出
     */
    public static TreeNode deserialize(String text) {
        String[] values = text.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreorder(queue);
    }


    private static TreeNode reconPreorder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = reconPreorder(queue);
        node.right = reconPreorder(queue);
        return node;
    }
}
