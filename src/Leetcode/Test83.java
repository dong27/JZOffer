package Leetcode;

//删除排序链表中的重复元素
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
public class Test83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = p.next;
        while(p!=null && q != null){
            while(q != null && p.val == q.val){
                //当p和下一个q相等时，往后移动q
                q = q.next;
            }
            p.next = q;
            p = q;
            if(p !=null){
                q = p.next;
            }

        }
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
