package leetCode;

import java.util.*;

/**
 * @author zhonghf
 * 100 101
 * 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * 输入： 1->2     输出： false
 * 输入： 1->2->2->1       输出： true
 */
public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        // 0 1 2 3 4
        // 0 1 2 3
        for (int i = 0, j = arr.size() - 1; i < arr.size() / 2; i++, j--) {
            if (!arr.get(i).equals(arr.get(j))) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
//        ListNode t1 = new ListNode(1);
//        ListNode t2 = new ListNode(0);
//        ListNode t3 = new ListNode(0);
//        t1.next = t2;
//        t2.next = t3;
//        System.out.println(isPalindrome(new ListNode(1)));
        HashSet<String> set = new HashSet<>();
        set.add("kelvin");

    }


}
