package leetcode.editor.cn.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最大深度
 *
 * @author solisamicus
 * @date 2024-12-27 20:34:10
 */
public class P104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
        Solution2 solution2 = new P104_MaximumDepthOfBinaryTree().new Solution2();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.maxDepth(root1));
        System.out.println(solution2.maxDepth(root1));

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(solution.maxDepth(root2));
        System.out.println(solution2.maxDepth(root2));

    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            int depth = 0;
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                }
                depth++;
            }
            return depth;
        }
    }

    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

}