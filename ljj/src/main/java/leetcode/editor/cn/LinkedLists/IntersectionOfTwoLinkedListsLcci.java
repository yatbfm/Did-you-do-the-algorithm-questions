package leetcode.editor.cn.LinkedLists;

/**
 * 相交链表
 *
 * @author solisamicus
 * @date 2024-12-10 22:31:10
 */
public class IntersectionOfTwoLinkedListsLcci {

    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedListsLcci().new Solution();
    }

    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA, B = headB;
            while (A != B) {
                A = A == null ? headB : A.next;
                B = B == null ? headA : B.next;
            }
            return A;
        }
    }

}