package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//二叉树的锯齿形层次遍历
public class Test103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> visited=new LinkedList<List<Integer>>();
        int row=0,col=0;
        Boolean direction=true;//true代表向右，false代表向左
        if(root!=null){queue.offer(root);}
        else{return visited;}
        while(!queue.isEmpty()){
            int level=queue.size();
            List<Integer> sub_visited=new LinkedList<Integer>();
            Stack<Integer> sub_stack=new Stack<Integer>();
            List<Integer> sub_queue=new LinkedList<Integer>();
            for(int i=0;i<level;i++){
                if(queue.peek().left!=null){queue.offer(queue.peek().left);}
                if(queue.peek().right!=null){queue.offer(queue.peek().right);}
                int value=queue.poll().val;
                sub_stack.push(value);
                sub_queue.add(value);
            }
            if(direction==true){
                sub_visited=sub_queue;
            }
            else{
                while(!sub_stack.isEmpty()){
                    sub_visited.add(sub_stack.pop());
                }
            }
            direction=!direction;
            visited.add(sub_visited);
        }
        return visited;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
