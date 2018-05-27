package Offer;

public class Test18 {
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        TreeNode head=new TreeNode();
        root.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        deleteNode(root,node3);
        TreeNode node=root;
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public static void deleteNode(TreeNode head,TreeNode toBeDelete){
        if(head==null||toBeDelete==null) return;
        //要删除的节点不是尾节点
        if(toBeDelete.next!=null){
            TreeNode pNext=toBeDelete.next;
            toBeDelete.val=pNext.val;
            toBeDelete.next=pNext.next;
        }
        //链表只有一个节点，删除头结点
        else if(head==toBeDelete){
            head=null;
        }
        else{
            TreeNode pNode=head;
            while (pNode.next!=toBeDelete){
                pNode=pNode.next;
            }
            pNode.next=null;
        }
    }
}
class TreeNode{
    int val;
    TreeNode next;
    TreeNode(){}
    TreeNode(int v){
        this.val=v;
    }
}
