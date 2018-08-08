package Leetcode;

//从中序与后序遍历序列构造二叉树
//根据一棵树的中序遍历与后序遍历构造二叉树。

//先通过后序遍历的结果求出二叉树的根节点，然后通过递归的方式依次来求左子树和右子树。代码如下
public class Test106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1);
    }
    public static TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder,
                                     int ps, int pe) {
        if (is > ie || ps > pe)
            return null;
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == rootVal) {
                TreeNode left = buildTree(inorder, is, i - 1, postorder, ps, ps+ i - is - 1);
                TreeNode right = buildTree(inorder, i + 1, ie, postorder, pe- ie + i, pe - 1);
                root.left = left;
                root.right = right;
            }
        }
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
