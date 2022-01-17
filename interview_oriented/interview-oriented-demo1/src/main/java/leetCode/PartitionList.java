package leetCode;


/**
 * @author kelvinchung
 *
 * 02.04. 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你不需要保留每个分区中各节点的初始相对位置。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 */
public class PartitionList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        // 要有头节点
        ListNode min = null;
        ListNode currMin = null;
        ListNode max = null;
        ListNode currMax = null;
        // 开始遍历
        while (head != null) {
            if (head.val >= x) {
                if (max == null) {
                    max = new ListNode(head.val);
                    currMax = max;
                    head = head.next;
                    continue;
                }
                currMax.next = new ListNode(head.val);
                currMax = currMax.next;

            }else {
                if (min == null) {
                    min = new ListNode(head.val);
                    currMin = min;
                    head = head.next;
                    continue;
                }
                currMin.next = new ListNode(head.val);
                currMin = currMin.next;
            }
            head = head.next;
        }
        if (currMin == null) {
            return max;
        }
        currMin.next = max;
        return min;
    }

//    public ListNode partition(ListNode head, int x) {
//        ListNode small = new ListNode(0);
//        ListNode smallHead = small;
//        ListNode large = new ListNode(0);
//        ListNode largeHead = large;
//        while (head != null) {
//            if (head.val < x) {
//                small.next = head;
//                small = small.next;
//            } else {
//                large.next = head;
//                large = large.next;
//            }
//            head = head.next;
//        }
//        large.next = null;
//        small.next = largeHead.next;
//        return smallHead.next;
//    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(4);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(2);
        ListNode t5 = new ListNode(5);
        ListNode t6 = new ListNode(2);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = t6;
        partition(t1, 3);
    }
}
