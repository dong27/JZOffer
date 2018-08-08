package Leetcode;

//相同的树
//

public class Test100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag = false;
        if(p==null && q == null)
            return true;
        if(p == null && q!= null)
            return false;
        if(p!= null && q== null)
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
