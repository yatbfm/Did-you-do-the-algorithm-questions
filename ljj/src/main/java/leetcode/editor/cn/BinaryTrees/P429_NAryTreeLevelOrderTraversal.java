package leetcode.editor.cn.BinaryTrees;

import java.util.*;

/**
 * N 叉树的层序遍历
 *
 * @author solisamicus
 * @date 2024-12-27 20:33:43
 */
public class P429_NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new P429_NAryTreeLevelOrderTraversal().new Solution();

        testCase1(solution);

        testCase2(solution);
    }

    private static void testCase1(Solution solution) {
        P429_NAryTreeLevelOrderTraversal outer = new P429_NAryTreeLevelOrderTraversal();
        Node node5 = outer.new Node(5);
        Node node6 = outer.new Node(6);
        Node node2 = outer.new Node(2);
        Node node4 = outer.new Node(4);
        Node node3 = outer.new Node(3, Arrays.asList(node5, node6));
        Node root = outer.new Node(1, Arrays.asList(node3, node2, node4));
        System.out.println(solution.levelOrder(root));
    }

    private static void testCase2(Solution solution) {
        P429_NAryTreeLevelOrderTraversal outer = new P429_NAryTreeLevelOrderTraversal();
        Node node14 = outer.new Node(14);
        Node node13 = outer.new Node(13);
        Node node12 = outer.new Node(12);
        Node node11 = outer.new Node(11, Arrays.asList(node14));
        Node node10 = outer.new Node(10);
        Node node9 = outer.new Node(9, Arrays.asList(node13));
        Node node8 = outer.new Node(8, Arrays.asList(node12));
        Node node7 = outer.new Node(7, Arrays.asList(node11));
        Node node6 = outer.new Node(6);
        Node node5 = outer.new Node(5, Arrays.asList(node9, node10));
        Node node4 = outer.new Node(4, Arrays.asList(node8));
        Node node3 = outer.new Node(3, Arrays.asList(node6, node7));
        Node node2 = outer.new Node(2);
        Node root = outer.new Node(1, Arrays.asList(node2, node3, node4, node5));
        System.out.println(solution.levelOrder(root));
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Deque<Node> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Node node = deque.poll();
                    level.add(node.val);
                    List<Node> children = node.children;
                    if (children == null) {
                        continue;
                    }
                    for (Node child : children) {
                        deque.offer(child);
                    }
                }
                result.add(level);
            }
            return result;
        }
    }

}