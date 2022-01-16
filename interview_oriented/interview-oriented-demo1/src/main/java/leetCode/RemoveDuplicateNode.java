package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kelvinchung
 * <p>
 * 02.01. 移除重复节点
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 *
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 *
 */
public class RemoveDuplicateNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 大神解法
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null) {
            return head;
        }
        // 传入不为空
        // 存储节点的val
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        // pos表示当前检查的是哪一个节点
        ListNode pos = head;
        while(pos.next != null) {
            // 当前节点的下一个
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                // 之前没有加过
                pos = pos.next;
            } else {
                // 有过了 就检查重复的下一个
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

}
