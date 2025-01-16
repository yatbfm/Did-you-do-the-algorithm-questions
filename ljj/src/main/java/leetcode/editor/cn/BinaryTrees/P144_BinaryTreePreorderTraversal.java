package leetcode.editor.cn.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * @author solisamicus
 * @date 2024-12-21 17:44:52
 */
public class P144_BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new P144_BinaryTreePreorderTraversal().new Solution();

        TreeNode test1 = new TreeNode(1);
        test1.right = new TreeNode(2);
        test1.right.left = new TreeNode(3);
        System.out.println(solution.preorderTraversal(test1));

        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.left.right = new TreeNode(5);
        test2.left.right.left = new TreeNode(6);
        test2.left.right.right = new TreeNode(7);
        test2.right.right = new TreeNode(8);
        test2.right.right.left = new TreeNode(9);
        System.out.println(solution.preorderTraversal(test2));

        TreeNode test3 = null;
        System.out.println(solution.preorderTraversal(test3));

        TreeNode test4 = new TreeNode(1);
        System.out.println(solution.preorderTraversal(test4));
    }

    class Solution {
        private void preorder(TreeNode root, List<Integer> result) {
            if (root == null) return;
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;
        }
    }

}