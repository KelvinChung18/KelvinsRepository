package leetCode;

/**
 * @author kelvinchung
 * <p>
 * 02.07. 链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * A走完走B的路线 B走完就走A的
 * e.g. A的路径是7 / B的路径是9
 *
 * 由于两个链表的前面部分可能不一样长，因此我们不能一次性的找到那个交点。我们可以在A链表到尾部后再连到B链表上，
 * B链表到尾部后连到A链表上，这样的话如果前面的部分不一样长，那么第二次就一定同时到那个交点上。
 * 例如：两个链表相交的长度为c，A链表前面的部分长度为a，B链表前面的长度为b。那么第一次到相交的起始节点时，A的指针要走a个长度，B的指针要走b个长度。这样两个指针走的长度可能会不一致。
 * 继续走到尾部，再互相连接后，A的指针走的距离是（a+c+b）,B的指针走的距离是（b+c+a）,这样两个指针就会同时到相交的节点了。
 * 如果没有交点，那么两个就会同时到null，就会直接返回null。(c=0)
 */
public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 不相交的情况 A=B=null 退出循环
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
