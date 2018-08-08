package Offer;

//搜索二叉树的第K大节点
//给定一个二叉树，请找出其中第k大的节点
public class Test54 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(7);
        root.left=node1;
        root.right=node2;
        TreeNode node3=new TreeNode(2);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(6);
        TreeNode node6=new TreeNode(8);
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        TreeNode node=KthNode(root,4);
        System.out.println(node.val);
    }
    public static TreeNode KthNode(TreeNode pRoot,int k){
        if(pRoot==null||k==0)
            return null;
        return KthNodeCore(pRoot,k);
    }
    public static TreeNode KthNodeCore(TreeNode node,int k){
        TreeNode target=null;
        if(node.left!=null)
            target=KthNodeCore(node.left,k);
        if(target==null &&k==1){
                target=node;
        }
        if(target==null&&node.right!=null)
            target=KthNodeCore(node.right,k);
        return target;
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
