package Offer;

//对称的二叉树
//实现一个函数，判断一棵二叉树是不是对称的。
public class Test28 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    boolean isSymmetrical(TreeNode r1,TreeNode r2) {
        if (r1 == null&&r2 == null)
            return true;
        if (r1 == null||r2 == null)
            return false;
        return r1.val==r2.val&&isSymmetrical(r1.left,r2.right)&&isSymmetrical(r1.right,r2.left);
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
    }
}
