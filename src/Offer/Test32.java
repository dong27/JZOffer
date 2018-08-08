package Offer;

import java.util.Deque;
import java.util.LinkedList;

//不分行从上到下打印二叉树
//从上到下打印二叉树的每一个节点，同一层的节点按照从左到右的顺序打印。
public class Test32 {
    public static void main(String[] args) {

    }
    public static void PrintFromTopToBottom(TreeNode pRoot){
        if(pRoot==null) return;
        Deque<TreeNode> deque=new LinkedList<>(); //注意初始化
        deque.push(pRoot);
        while(deque.size()!=0){
            TreeNode pNode=deque.peek();
            deque.pop();
            System.out.println(pNode.val);
            if(pNode.left!=null){
                deque.push(pNode.left);
            }
            if(pNode.right!=null){
                deque.push(pNode.right);
            }
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
