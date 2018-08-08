package Leetcode;

//旋转链表
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
public class Test61 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null)
            return head;

        ListNode node = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int size = 0;
        while(node!=null)
        {
            node = node.next;
            size++;
        }
        k = k%size;
        if(k==0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<k-1;i++)
        {
            fast = fast.next;
        }
        while(fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        dummy.next = slow;
        fast.next = head;

        return dummy.next;
    }
}
