package Leetcode;

//平衡二叉树
//给定一个二叉树，判断它是否是高度平衡的二叉树。

//本题中，一棵高度平衡二叉树定义为：
//        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
public class Test110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; //空树是平衡二叉树
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) return false; //左右子树高度差大于1，不是平衡二叉树
        else return isBalanced(root.left) && isBalanced(root.right); // 递归判断左右子树是否为平衡二叉树
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left); //计算左子树的深度
        int right = depth(root.right); //计算右子树的深度
        return Math.max(left, right) + 1; //返回较大值
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
