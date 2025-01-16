package leetcode.editor.cn.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最小深度
 *
 * @author solisamicus
 * @date 2024-12-27 20:34:17
 */
public class P111_MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
        Solution2 solution2 = new P111_MinimumDepthOfBinaryTree().new Solution2();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.minDepth(root1));
        System.out.println(solution2.minDepth(root1));

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(7);
        System.out.println(solution.minDepth(root2));
        System.out.println(solution2.minDepth(root2));
    }

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            int depth = 0;
            while (!deque.isEmpty()) {
                int size = deque.size();
                depth++;
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node.right == null && node.left == null) return depth;
                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                }
            }
            return depth;
        }
    }

    class Solution2 {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) return minDepth(root.right) + 1;
            if (root.right == null) return minDepth(root.left) + 1;
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

}