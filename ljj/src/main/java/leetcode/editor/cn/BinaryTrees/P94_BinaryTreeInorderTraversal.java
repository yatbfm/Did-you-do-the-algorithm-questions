package leetcode.editor.cn.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author solisamicus
 * @date 2024-12-21 17:45:05
 */
public class P94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();

        TreeNode test1 = new TreeNode(1);
        test1.right = new TreeNode(2);
        test1.right.left = new TreeNode(3);
        System.out.println(solution.inorderTraversal(test1));

        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.left.right = new TreeNode(5);
        test2.left.right.left = new TreeNode(6);
        test2.left.right.right = new TreeNode(7);
        test2.right.right = new TreeNode(8);
        test2.right.right.left = new TreeNode(9);
        System.out.println(solution.inorderTraversal(test2));

        TreeNode test3 = null;
        System.out.println(solution.inorderTraversal(test3));

        TreeNode test4 = new TreeNode(1);
        System.out.println(solution.inorderTraversal(test4));
    }

    class Solution {
        private void inorder(TreeNode root, List<Integer> result) {
            if (root == null) return;
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            return result;
        }
    }

}