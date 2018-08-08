package Offer;

import java.util.LinkedList;

//二叉树的镜像
//输入一棵二叉树，请输出他的镜像
public class Test27 {
    //递归实现
    public static void Mirror(TreeNode root){
        if(root==null)
            return;
        else{
            TreeNode temp=root.left; //交换根节点的左右孩子
            root.left=root.right;
            root.right=temp;
            Mirror(root.left); //镜像根节点的左孩子的左右子树
            Mirror(root.right); //镜像根节点的右孩子的左右子树
        }
    }
    //非递归实现
    public void Mirror1(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();//借助于辅助栈
        TreeNode current = null;//存放出栈的栈顶元素
        TreeNode temp = null;
        stack.push(root);//将根元素入栈
        while (!stack.isEmpty()) {
            current = stack.pop();//将根元素出栈 交换根元素的左右子树
            if (current.left != null || current.right != null)//若左右孩子不为空则交换左右孩子
            {
                temp = current.left;
                current.left = current.right;
                current.right = temp;
            }
            //将根元素的左右孩子压入栈中
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }
    }
        public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
}
