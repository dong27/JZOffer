package Offer;

import java.util.Deque;
import java.util.LinkedList;


//分行从上到下打印二叉树
//从上到下打印二叉树，同一层的节点按照从左到右的顺序打印，每一层打印到一行
public class Test32_2 {
    public static void main(String[] args) {

    }
    public static void Print(TreeNode pRoot){
        if(pRoot==null) return;
        Deque<TreeNode> deque=new LinkedList<TreeNode>();
        deque.push(pRoot);
        int nextLevel=0;
        int toBePrinted=1;
        while (!deque.isEmpty()){
            TreeNode pNode=deque.peek();
            System.out.print(pNode.val);
            if(pNode.left!=null){
                deque.push(pNode.left);
                ++nextLevel;
            }
            if(pNode.right!=null){
                deque.push(pNode.right);
                ++nextLevel;
            }
            deque.pop();
            --toBePrinted;
            if(toBePrinted==0){
                System.out.print("\n");
                toBePrinted=nextLevel;
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
