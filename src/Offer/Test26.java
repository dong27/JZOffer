package Offer;

//树的子结构
//输入两棵二叉树A和B，判断B是不是A的子结构
public class Test26 {
    public static boolean HasSubtree(TreeNode root1,TreeNode root2){
        if(root1==null || root2==null)return false;
        return IsSubtree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    public static boolean IsSubtree(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val==root2.val)
            return IsSubtree(root1.left,root2.left)&&IsSubtree(root1.right,root2.right);
        else
            return false;
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
