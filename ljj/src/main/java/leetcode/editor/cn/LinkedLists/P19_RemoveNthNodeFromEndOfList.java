package leetcode.editor.cn.LinkedLists;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author solisamicus
 * @date 2024-12-10 21:55:39
 */
public class P19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();

        ListNode head1 = ListUtils.arrayToList(new int[]{1, 2, 3, 4, 5});
        ListUtils.printList(head1);
        ListUtils.printList(solution.removeNthFromEnd(head1, 2));

        ListNode head2 = ListUtils.arrayToList(new int[]{1});
        ListUtils.printList(head2);
        ListUtils.printList(solution.removeNthFromEnd(head2, 1));

        ListNode head3 = ListUtils.arrayToList(new int[]{1, 2});
        ListUtils.printList(head3);
        ListUtils.printList(solution.removeNthFromEnd(head3, 1));
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode fast = dummyHead;
            ListNode slow = dummyHead;
            for (int i = 1; i <= n + 1; i++)
                fast = fast.next;
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummyHead.next;
        }
    }

}