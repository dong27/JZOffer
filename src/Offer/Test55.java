package Offer;

//二叉树的深度
public class Test55 {
    public static void main(String[] args) {

    }
    public static boolean isBalanced(TreeNode pRoot){
        if(pRoot==null)
            return true;
        int left=treeDepth(pRoot.left);
        int right=treeDepth(pRoot.right);
        int diff=left-right;
        if(diff>1||diff<-1)
            return false;
        return isBalanced(pRoot.left)&&isBalanced(pRoot.right);
    }
    public static int treeDepth(TreeNode pRoot){
        if(pRoot==null)
            return 0;
        int nLeft=treeDepth(pRoot.left);
        int nRight=treeDepth(pRoot.right);
        return (nLeft>nRight)?nLeft:nRight;
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){
            this.val=val;
        }
    }
}
