package Offer;

//两个链表的第一个公共节点
//输入两个链表，找出它们的第一个公共节点。
public class Test52 {
    static class Node {
        int data;
        Node next;
    }
    public static void main(String[] args) {
        Node node1 = null, node2 = null;
        Node node = findFirstCommonNode(node1, node2);
        System.out.println(node);
    }
    /*
     * 单链表相交的结果为成“Y”形
     */
    private static Node findFirstCommonNode(Node node1, Node node2) {
        // 获取链表的长度
        int nLength1 = GetListLength(node1);
        int nLength2 = GetListLength(node2);
        // 应多走的步数
        int extraLength = nLength1 - nLength1;
        Node pNodeLong = node1, pNodeShort = node2;
        if (nLength1 < nLength2) {
            extraLength = nLength2 - nLength1;
            pNodeLong = node2;
            pNodeShort = node1;
        }
        // 长链表先走extraLength步
        while (extraLength > 0) {
            pNodeLong = pNodeLong.next;
            extraLength--;
        }
        Node pNodeCommon = null;
        // 两个链表同时向后走
        while (pNodeLong != null && pNodeShort != null) {
            pNodeLong = pNodeLong.next;
            pNodeShort = pNodeShort.next;
            if (pNodeLong == pNodeShort) {
                pNodeCommon = pNodeLong;
                break;
            }
        }
        return pNodeCommon;
    }
    /*
     * 获取链表长度
     */
    private static int GetListLength(Node node1) {
        int length = 0;
        while (node1 != null) {
            length++;
            node1 = node1.next;
        }
        return length;
    }
}
