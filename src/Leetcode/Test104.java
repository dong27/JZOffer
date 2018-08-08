package Leetcode;

//二叉树的最大深度
public class Test104 {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root != null) {
            max++;
            int max_left = maxDepth(root.left);
            int max_right = maxDepth(root.right);

            max += max_left>max_right ? max_left:max_right;
        }
        return max;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
