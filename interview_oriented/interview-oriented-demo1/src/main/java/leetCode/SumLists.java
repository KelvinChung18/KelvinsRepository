package leetCode;

/**
 * @author kelvinchung
 *
 * 02.05. 链表求和
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 */
public class SumLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 0;  // 进位
        ListNode dummy = new ListNode(0);   // 哑节点
        ListNode node = dummy;

        while(l1 != null || l2 != null || x != 0) {
            int sum = x;    // 当前位的和
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(sum % 10);
            x = sum / 10;
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(4);
        ListNode t3 = new ListNode(3);

        ListNode t4 = new ListNode(5);
        ListNode t5 = new ListNode(6);
        ListNode t6 = new ListNode(4);

        t1.next = t2;
        t2.next = t3;


        t4.next = t5;
        t5.next = t6;

        addTwoNumbers(t1, t4);
    }
}
