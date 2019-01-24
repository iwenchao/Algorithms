package com.iwenchaos.mdualgor.tree;

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
    public static void createBinTree(TreeNode root){
        TreeNode newNodeB = new TreeNode(2);
        TreeNode newNodeC = new TreeNode(3);
        TreeNode newNodeD = new TreeNode(4);
        TreeNode newNodeE = new TreeNode(5);
        TreeNode newNodeF = new TreeNode(6);
        root.left=newNodeB;
        root.right=newNodeC;
        root.left.left=newNodeD;
        root.left.right=newNodeE;
        root.right.right=newNodeF;
    }

    /**
     * 递归方式
     */
    public static void preorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value+"-->");
        preorderTraverse(root.left);
        preorderTraverse(root.right);

    }
    /**
     * 递归方式
     */
    public static void inorderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.value+"-->");
        inorderTraverse(root.right);
    }
    /**
     * 递归方式
     */
    public static void posorderTraverse(TreeNode root){
        if(root == null) return;
        preorderTraverse(root.left);
        preorderTraverse(root.right);
        System.out.print(root.value+"-->");
    }


    public static void preorderTraverse2(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.print(root.value+"-->");
            if(root.right!= null){
                stack.push(root.right);
            }
            if(root.left!= null){
                stack.push(root.left);
            }
        }

    }

}
