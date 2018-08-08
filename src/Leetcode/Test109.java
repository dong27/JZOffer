package Leetcode;

//有序链表转换二叉搜索树
//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

//因为是有序的，所以可以将其分成两部分，前部分作为左子树，后部分作为右子树
public class Test109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) return null;

        if (null == head.next)
        {
            return new TreeNode(head.val);
        }

        ListNode slow = head, fast = head.next.next;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.next.val);
        node.right = sortedListToBST(slow.next.next);
        slow.next = null;
        node.left = sortedListToBST(head);

        return node;
    }
    class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
