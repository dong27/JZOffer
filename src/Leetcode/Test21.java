package Leetcode;

//合并两个有序链表
public class Test21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode pMergedHead=null;
        if(l1.val<l2.val){
            pMergedHead=l1;
            pMergedHead.next=mergeTwoLists(l1.next,l2);
        }else{
            pMergedHead=l2;
            pMergedHead.next=mergeTwoLists(l1,l2.next);
        }
        return pMergedHead;
    }
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
