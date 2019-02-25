package com.iwenchaos.mdualgor.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chaos
 * on 2019/1/23. 00:24
 * 文件描述：遍历二叉树
 * 深度遍历：
 * 前序：根-左-右
 * 中序：左-根-右
 * 后序：左-右-根
 * 广度遍历
 */
public class Traverse2XTreeAlgo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        createBinTree(root);
        inorderTraverse(root);
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
     * 递归方式
     */
    public static void preorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + "-->");
        preorderTraverse(root.left);
        preorderTraverse(root.right);

    }

    /**
     * 递归方式
     */
    public static void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.value + "-->");
        inorderTraverse(root.right);
    }

    /**
     * 递归方式
     */
    public static void posorderTraverse(TreeNode root) {
        if (root == null) return;
        preorderTraverse(root.left);
        preorderTraverse(root.right);
        System.out.print(root.value + "-->");
    }


    /**
     * 采用非递归的方式，使得已遍历的节点不再遍历
     * <p>
     * 前序遍历二叉树
     */
    public static void preorderTraverse2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.value + "-->");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

    }

    /**
     * 采用非递归的方式，使得已遍历的节点不再遍历
     * <p>
     * 中序遍历二叉树 左-根-右
     *
     * 补充：可以用来判断是否是搜索二叉树
     */
    public static void inorderTraverse2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {//root为空说明走到了叶子节点
                root = stack.pop();
                System.out.print(root.value + "-->");
                root = root.right;
            }
        }


    }

    /**
     * 采用非递归的方式，使得已遍历的节点不再遍历
     * <p>
     * 后序遍历二叉树 左-右-根
     * 本方法的思想就是 逆向，将逆向遍历的结果放到stack中，
     * 然后在从stack pop（）出来就是正向的后序遍历
     */
    public static void posorderTraverse2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> saved = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            saved.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }
        while (!saved.isEmpty()) {
            System.out.print(saved.pop().value + "-->");
        }
    }


    /**
     * 广度遍历 二叉树
     *
     * 补充：可以用来判断是否是完全二叉树
     */
    public static void flatOrderTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = ((LinkedList<TreeNode>) queue).pop();
            System.out.print(root.value + "-->");
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

}
