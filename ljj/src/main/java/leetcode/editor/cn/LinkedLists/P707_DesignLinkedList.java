package leetcode.editor.cn.LinkedLists;

/**
 * 设计链表
 *
 * @author solisamicus
 * @date 2024-12-10 20:06:34
 */
public class P707_DesignLinkedList {

    public static void main(String[] args) {
        MyLinkedList obj = new P707_DesignLinkedList().new MyLinkedList();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    class MyLinkedList {

        int size;

        ListNode dummyHead;

        public MyLinkedList() {
            size = 0;
            dummyHead = new ListNode();
        }

        public int get(int index) {
            if (index < 0 || index >= size)
                return -1;
            ListNode node = dummyHead.next;
            while (index != 0) {
                node = node.next;
                index--;
            }
            return node.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = dummyHead.next;
            dummyHead.next = node;
            size++;
        }

        public void addAtTail(int val) {
            ListNode current = dummyHead;
            while (current.next != null)
                current = current.next;
            current.next = new ListNode(val, null);
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size)
                return;
            if (index < 0)
                index = 0;
            ListNode current = dummyHead;
            while (index != 0) {
                current = current.next;
                index--;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;
            ListNode current = dummyHead;
            while (index != 0) {
                current = current.next;
                index--;
            }
            current.next = current.next.next;
            size--;
        }
    }

}