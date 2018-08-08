package Offer;

//二叉搜索树与双向链表
//输入一棵二叉树，将该二叉搜索树转换成一个排序的双向链表
public class Test36 {
    TreeNode convert(TreeNode pRootTree){
        TreeNode lastNodeInList=null;
        convertNode(pRootTree,lastNodeInList);
        TreeNode headOfList=lastNodeInList;
        while (headOfList!=null&&headOfList.left!=null){
            headOfList=headOfList.left;
        }
        return headOfList;
    }
    public void convertNode(TreeNode pNode,TreeNode lastNodeInList){
        if(pNode==null) return;
        TreeNode pCurrent=pNode;
        if(pCurrent.left!=null)
            convertNode(pCurrent.left,lastNodeInList);
        pCurrent.left=lastNodeInList;
        if(lastNodeInList!=null)
            lastNodeInList.right=pCurrent;

        lastNodeInList=pCurrent;
        if(pCurrent.right!=null)
            convertNode(pCurrent.right,lastNodeInList);
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
