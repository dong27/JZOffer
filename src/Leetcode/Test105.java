package Leetcode;

// 从前序与中序遍历序列构造二叉树
//根据一棵树的前序遍历与中序遍历构造二叉树

public class Test105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        TreeNode result = new TreeNode(preorder[0]);
        if(preorder.length==1){
            return result;
        }
        int top_pos=0;
        for(top_pos=0;top_pos<inorder.length;top_pos++){
            if(inorder[top_pos]==preorder[0]){
                break;
            }
        }
        int[] left_preorder=new int[top_pos];
        int[] left_inorder=new int[top_pos];
        int[] right_preorder=new int[preorder.length-top_pos-1];
        int[] right_inorder=new int[preorder.length-top_pos-1];
        for(int i=0;i<top_pos;i++){
            left_preorder[i]=preorder[i+1];
            left_inorder[i]=inorder[i];
        }
        result.left=buildTree(left_preorder,left_inorder);
        for(int i=0;i<preorder.length-top_pos-1;i++){
            right_preorder[i]=preorder[i+top_pos+1];
            right_inorder[i]=inorder[i+top_pos+1];
        }
        result.right=buildTree(right_preorder,right_inorder);
        return result;
    }
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
