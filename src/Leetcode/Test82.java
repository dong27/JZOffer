package Leetcode;

// 删除排序链表中的重复元素 II
//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

/**
 * 记录相同个数
 一个相同的保存，多个的跳过
 */
public class Test82 {
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode newHead = new ListNode(0);
        if(head ==null || head.next ==null)
            return head;
        ListNode cur = newHead;
        ListNode prev = head;
        while(head!=null){
            ListNode  p = head;
            int count = 0;// 记录相同结点的个数
            while(p!=null && p.val == head.val){
                p = p.next;
                count++;
            }
            if(count==1){ // 1 说明就一个
                cur.next = head;
                cur = cur.next;
                head = head.next;
            }else
                head = p;
        }
        cur.next =null;// 断开后面的结点
        return  newHead.next;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
}
