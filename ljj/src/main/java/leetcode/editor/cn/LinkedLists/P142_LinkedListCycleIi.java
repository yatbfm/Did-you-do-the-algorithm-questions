package leetcode.editor.cn.LinkedLists;

/**
 * 环形链表 II
 *
 * @author solisamicus
 * @date 2024-12-10 22:56:43
 */
public class P142_LinkedListCycleIi {

    public static void main(String[] args) {
        Solution solution = new P142_LinkedListCycleIi().new Solution();
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    ListNode i = fast; // or slow
                    ListNode j = head;
                    while (i != j) {
                        i = i.next;
                        j = j.next;
                    }
                    return i; // or j
                }
            }
            return null;
        }
    }

}