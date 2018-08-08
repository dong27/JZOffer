package Offer;

//链表反转
public class Test24 {
    public static ListNode reverseList(ListNode pHead){
        ListNode pReverseHead=null;
        ListNode pNode=pHead;
        ListNode pPre=null;
        while (pNode!=null){
            ListNode pNext=pNode.next;
            if(pNext==null)
                pReverseHead=pNode;
            pNode.next=pPre;
            pPre=pNode;
            pNode=pNext;
        }
        return pReverseHead;
    }
    public static class ListNode{
        int val;
        public ListNode(int val){
            this.val=val;
        }
        ListNode next;
    }
}
