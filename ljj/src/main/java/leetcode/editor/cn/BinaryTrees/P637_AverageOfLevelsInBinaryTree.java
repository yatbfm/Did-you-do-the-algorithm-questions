package leetcode.editor.cn.BinaryTrees;

import java.util.*;

/**
 * 二叉树的层平均值
 *
 * @author solisamicus
 * @date 2024-12-27 20:33:32
 */
public class P637_AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        Solution solution = new P637_AverageOfLevelsInBinaryTree().new Solution();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.averageOfLevels(root1));

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.left.left = new TreeNode(15);
        root2.left.right = new TreeNode(7);
        System.out.println(solution.averageOfLevels(root2));
    }

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root == null) return result;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                int[] level = new int[size];
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    level[i] = node.val;
                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                }
                double sum = 0;
                for (int i = 0; i < size; i++) {
                    sum += level[i];
                }
                double avg = sum / size;
                result.add(avg);
            }
            return result;
        }
    }

}