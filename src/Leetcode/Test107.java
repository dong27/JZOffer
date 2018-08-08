package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// 二叉树的层次遍历 II
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

//总的结果用栈存储，最后再一次弹出，从而使各个分数组逆序排列
public class Test107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Stack<List<Integer>> visited=new Stack<List<Integer>>();
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        int row=0,col=0;
        if(root!=null){queue.offer(root);}
        else{return visited;}
        while(!queue.isEmpty()){
            int level=queue.size();
            List<Integer> sub_visited=new LinkedList<Integer>();
            for(int i=0;i<level;i++){
                if(queue.peek().left!=null){queue.offer(queue.peek().left);}
                if(queue.peek().right!=null){queue.offer(queue.peek().right);}
                sub_visited.add(queue.poll().val);
            }
            visited.push(sub_visited);
        }
        while(!visited.isEmpty()){
            result.add(visited.pop());
        }
        return result;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
