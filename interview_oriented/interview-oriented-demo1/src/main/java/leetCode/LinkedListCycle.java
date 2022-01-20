package leetCode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author kelvinchung
 *
 * 02.08. 环路检测
 *
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 */
public class LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return head;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }
    // 快慢指针
//    public ListNode detectCycle(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode slow = head, fast = head;
//        while (fast != null) {
//            slow = slow.next;
//            if (fast.next != null) {
//                fast = fast.next.next;
//            } else {
//                return null;
//            }
//            if (fast == slow) {
//                ListNode ptr = head;
//                while (ptr != slow) {
//                    ptr = ptr.next;
//                    slow = slow.next;
//                }
//                return ptr;
//            }
//        }
//        return null;
//    }

}
