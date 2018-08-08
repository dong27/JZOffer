package Offer;

//删除链表中重复的节点
public class Test18_2 {
    public static void main(String[] args){

    }
    public static void deleteDuplication(TreeNode head){
        if(head==null) return;

        TreeNode preNode=null,pNode;
        pNode=head;
        while (pNode!=null){
            TreeNode pNext=pNode.next;
            boolean needDelete=false;
            if(pNext!=null&&pNext.val==pNode.val)
                needDelete=true;
            if(!needDelete){
                preNode=pNode;
                pNode=pNode.next;
            }
            else{
                int val=pNode.val;
                TreeNode toBeDel=pNode;
                while (toBeDel!=null&&toBeDel.val==val){
                    pNext=toBeDel.next;
                    toBeDel=pNext;
                }
                if(preNode==null){
                    head=pNext;
                }else{
                    preNode.next=pNext;
                }
            }
        }
    }
    public static class TreeNode{
        int val;
        TreeNode next;
        TreeNode(){}
        TreeNode(int v){
            this.val=v;
        }
    }
}