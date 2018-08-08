package Leetcode;

//分隔链表
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

/**
 * 对于值大于等于x的节点，直接插到链表。对于值小于x的节点，需要找到第一个大于等于x的节点，插到它的前面。
 */
public class Test86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        node.next = null;
        while(head!=null)
        {
            if(head.val>=x)
            {
                while(node.next!=null)
                {
                    node = node.next;
                }
                node.next = new ListNode(head.val);
                node.next.next = null;
            }
            else
            {
                while(node.next!=null && node.next.val < x)
                {
                    node = node.next;
                }
                ListNode temp = node.next;
                node.next = new ListNode(head.val);
                node.next.next = temp;
            }
            node = dummy;
            head = head.next;
        }

        return dummy.next;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
