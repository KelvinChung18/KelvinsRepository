package leetCode;

/**
 * @author kelvinchung
 *
 * 02.02. 返回倒数第 k 个节点
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 */
public class KthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        // 一共5个 倒数2 就是正数4
        // 一共10个 倒数1 就是正数10
        int length = 0;

        ListNode last = head;
        ListNode result = head;

        while (last.next != null) {
            last = last.next;
            length++;
        }
        // length个节点 倒数第k
        // 正数就是第length-k+1
        for (int i = 0; i < length - k + 1; i++) {
            result = result.next;
        }
        return result.val;

    }


}
