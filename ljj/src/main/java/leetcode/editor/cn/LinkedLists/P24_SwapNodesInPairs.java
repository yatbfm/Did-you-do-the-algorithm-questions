package leetcode.editor.cn.LinkedLists;

/**
 * 两两交换链表中的节点
 *
 * @author solisamicus
 * @date 2024-12-10 21:27:54
 */
public class P24_SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new P24_SwapNodesInPairs().new Solution();

        ListNode head1 = ListUtils.arrayToList(new int[]{1, 2, 3, 4});
        ListUtils.printList(head1);
        ListUtils.printList(solution.swapPairs(head1));

        ListNode head2 = ListUtils.arrayToList(new int[]{});
        ListUtils.printList(head2);
        ListUtils.printList(solution.swapPairs(head2));

        ListNode head3 = ListUtils.arrayToList(new int[]{1});
        ListUtils.printList(head3);
        ListUtils.printList(solution.swapPairs(head3));
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode current = dummyHead;
            ListNode first;
            ListNode second;
            ListNode next;
            while (current.next != null && current.next.next != null) {
                first = current.next;
                second = first.next;
                next = second.next;
                current.next = second;
                second.next = first;
                first.next = next;
                current = first;
            }
            return dummyHead.next;
        }
    }

}