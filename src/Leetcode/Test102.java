package Leetcode;

//二叉树的层次遍历

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列里面存放结点
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //如果为空树就直接返回
        if(root == null){
            return result;
        }
        queue.offer(root);//根节点先入队
        //只要队列非空就一直循环;
        while (!queue.isEmpty()){
            int levelNum = queue.size();//获取当前层的节点数.
            List<Integer> subList = new ArrayList<>();
            //遍历当前层结点
            for(int i=0; i<levelNum; i++){
                //队首出队并将value加入子list
                TreeNode node = queue.poll();
                subList.add(node.val);

                //将非空左右子树加入queue
                if(node.left != null){//如果队首的左结点不为空就把左结点入队
                    queue.offer(node.left);
                }
                if(node.right != null){//如果队首的右结点不为空就把右结点入队
                    queue.offer(node.right);
                }
            }
            result.add(subList);//添加一层
        }
        return result;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
