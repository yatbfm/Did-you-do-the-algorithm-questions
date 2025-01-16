package leetcode.editor.cn.BinaryTrees;

import java.util.*;

/**
 * 二叉树的右视图
 *
 * @author solisamicus
 * @date 2024-12-27 20:33:24
 */
public class P199_BinaryTreeRightSideView {

    public static void main(String[] args) {
        Solution solution = new P199_BinaryTreeRightSideView().new Solution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println(solution.rightSideView(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.left.left = new TreeNode(5);
        System.out.println(solution.rightSideView(root2));

        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(3);
        System.out.println(solution.rightSideView(root3));

        TreeNode root4 = null;
        System.out.println(solution.rightSideView(root4));
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                    if (i == size - 1) result.add(node.val);
                }
            }
            return result;
        }
    }

}