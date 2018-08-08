package Leetcode;

//两两交换链表中的节点
public class Test24 {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = first.next;
            ListNode third= second.next;
            pre.next = second;
            second.next = first;
            first.next = third;
            pre = pre.next.next;
        }
        return preHead.next;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
