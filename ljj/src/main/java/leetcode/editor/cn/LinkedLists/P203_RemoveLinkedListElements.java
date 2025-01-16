package leetcode.editor.cn.LinkedLists;

/**
 * 移除链表元素
 *
 * @author solisamicus
 * @date 2024-12-10 19:33:47
 */
public class P203_RemoveLinkedListElements {

    public static void main(String[] args) {
        Solution solution = new P203_RemoveLinkedListElements().new Solution();
        Solution2 solution2 = new P203_RemoveLinkedListElements().new Solution2();

        ListUtils.printList(solution.removeElements(ListUtils.arrayToList(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
        ListUtils.printList(solution.removeElements(ListUtils.arrayToList(new int[]{}), 1));
        ListUtils.printList(solution.removeElements(ListUtils.arrayToList(new int[]{7, 7, 7, 7}), 7));

        ListUtils.printList(solution2.removeElements(ListUtils.arrayToList(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
        ListUtils.printList(solution2.removeElements(ListUtils.arrayToList(new int[]{}), 1));
        ListUtils.printList(solution2.removeElements(ListUtils.arrayToList(new int[]{7, 7, 7, 7}), 7));
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val)
                head = head.next;
            ListNode current = head;
            while (current != null && current.next != null)
                if (current.next.val == val)
                    current.next = current.next.next;
                else
                    current = current.next;
            return head;
        }
    }

    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode current = dummyHead;
            while (current.next != null)
                if (current.next.val == val)
                    current.next = current.next.next;
                else
                    current = current.next;
            return dummyHead.next;
        }
    }

}