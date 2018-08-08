package Leetcode;

//反转链表 II
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
/**
 * 注意要求：在原地反转，也就是不能申请额外的空间，且只能遍历一遍。
 自然而然想到把链表分为三部分，重点是如何遍历一遍把中间部分反转？借助两个指针，
 tmpHead和tmpNext，tmpHead是遍历反转后的head，tmpNext始终是tmpHead反转后的next。

 https://blog.csdn.net/ljiabin/article/details/41748689
 */
public class Test92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        // The (m-1) node is the tail of first tail.
        ListNode firstTail = preHead;
        int k = m - 1;
        while (k-- > 0) {
            firstTail = firstTail.next;
        }
        // The m-th node is the traversed tail.
        ListNode secondTail = firstTail.next;
        // Traverse m~n nodes, and get the traversed head.
        ListNode tmpHead = null;
        ListNode tmpNext = null;
        ListNode node = firstTail.next;
        k = n - m + 1;
        while (k-- > 0) {
            tmpHead = node;
            node = node.next;

            tmpHead.next = tmpNext;
            tmpNext = tmpHead;
        }
        // Connect three parts.
        firstTail.next = tmpHead;
        secondTail.next = node;
        return preHead.next;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
