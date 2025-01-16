package leetcode.editor.cn.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @author solisamicus
 * @date 2024-12-27 20:33:56
 */
public class P116_PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Solution solution = new P116_PopulatingNextRightPointersInEachNode().new Solution();

        testCase1(solution);

        testCase2(solution);
    }

    private static void testCase1(Solution solution) {
        P116_PopulatingNextRightPointersInEachNode outer = new P116_PopulatingNextRightPointersInEachNode();
        Node root1 = outer.new Node(1);
        root1.left = outer.new Node(2);
        root1.right = outer.new Node(3);
        root1.left.left = outer.new Node(4);
        root1.left.right = outer.new Node(5);
        root1.right.left = outer.new Node(6);
        root1.right.right = outer.new Node(7);
        printNextPointers(solution.connect(root1));
    }

    private static void testCase2(Solution solution) {
        P116_PopulatingNextRightPointersInEachNode outer = new P116_PopulatingNextRightPointersInEachNode();
        Node root2 = outer.new Node();
        printNextPointers(root2);
    }

    private static void printNextPointers(Node root) {
        if (root == null) return;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                System.out.print(curr.val + " -> ");
                System.out.println(curr.next != null ? curr.next.val : "null");
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Deque<Node> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                Node curr = null, prev = null;
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        prev = deque.poll();
                        curr = prev;
                    } else {
                        curr = deque.poll();
                        prev.next = curr;
                        prev = curr;
                    }
                    if (curr.left != null) deque.offer(curr.left);
                    if (curr.right != null) deque.offer(curr.right);
                }
                curr.next = null;
            }
            return root;
        }
    }

}