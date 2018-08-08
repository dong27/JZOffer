package Leetcode;

// 对称二叉树
//给定一个二叉树，检查它是否是镜像对称的。
public class Test101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val == right.val) return isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
        return false;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
