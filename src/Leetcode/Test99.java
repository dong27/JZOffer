package Leetcode;

//恢复二叉搜索树

//二叉搜索树中的两个节点被错误地交换。
//请在不改变其结构的情况下，恢复这棵树。
public class Test99 {
    TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode biggerOne = null;
    TreeNode smallerOne = null;
    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int tmp = biggerOne.val;
        biggerOne.val = smallerOne.val;
        smallerOne.val = tmp;
    }
    public void inorderTraverse(TreeNode root){
        if(root == null) return ;
        inorderTraverse(root.left);
        // 正确的应该大于
        if(biggerOne == null && root.val <= lastNode.val){
            biggerOne = lastNode;
        }
        if(biggerOne != null && root.val <= lastNode.val){
            smallerOne = root;
        }
        lastNode = root;
        inorderTraverse(root.right);
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
