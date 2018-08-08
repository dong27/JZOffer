package Offer;

import java.util.Stack;

//二叉树中和为某一值的路径
//输入一棵二叉树和一个整数，打印出二叉树节点中节点值的和为输入整数的所有路径。从树的根节点开始往下
//一直到叶节点所经过的节点形成一条路径。
public class Test34 {
    public static void main(String[] args) {

    }
    public static void findPath(TreeNode pRoot,int expectedSum){
        if(pRoot==null) return;
        Stack<TreeNode> path=new Stack<>();
        int currentSum=0;
        findPath(pRoot,expectedSum,path,currentSum);
    }
    public static void findPath(TreeNode pNode,int expectedSum,Stack<TreeNode> path,int currentSum){
        currentSum+=pNode.val;
        path.push(pNode);
        boolean isLeaf=pNode.left==null&&pNode.right==null;
        if(expectedSum==currentSum&&isLeaf){
            System.out.println("A path is found:");
            for(TreeNode node:path){
                System.out.println(node.val);
            }
        }
        //如果不是叶子节点，则遍历它的子节点
        if(pNode.left!=null){
            findPath(pNode.left,expectedSum,path,currentSum);
        }
        if(pNode.right!=null){
            findPath(pNode.right,expectedSum,path,currentSum);
        }
        path.pop();
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
