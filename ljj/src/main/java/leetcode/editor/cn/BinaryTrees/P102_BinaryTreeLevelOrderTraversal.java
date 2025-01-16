package leetcode.editor.cn.BinaryTrees;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * @author solisamicus
 * @date 2024-12-27 20:33:08
 */
public class P102_BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.levelOrder(root1));

        TreeNode root2 = new TreeNode(1);
        System.out.println(solution.levelOrder(root2));

        TreeNode root3 = null;
        System.out.println(solution.levelOrder(root3));
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    level.add(node.val);
                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                }
                result.add(level);
            }
            return result;
        }
    }

}