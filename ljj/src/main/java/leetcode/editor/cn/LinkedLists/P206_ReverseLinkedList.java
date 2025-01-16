package leetcode.editor.cn.LinkedLists;

/**
 * 反转链表
 *
 * @author solisamicus
 * @date 2024-12-10 21:08:17
 */
public class P206_ReverseLinkedList {

    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();

        ListNode head1 = ListUtils.arrayToList(new int[]{1, 2, 3, 4, 5});
        ListUtils.printList(head1);
        ListUtils.printList(solution.reverseList(head1));

        ListNode head2 = ListUtils.arrayToList(new int[]{1, 2});
        ListUtils.printList(head2);
        ListUtils.printList(solution.reverseList(head2));

        ListNode head3 = ListUtils.arrayToList(new int[]{});
        ListUtils.printList(head3);
        ListUtils.printList(solution.reverseList(head3));
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

}