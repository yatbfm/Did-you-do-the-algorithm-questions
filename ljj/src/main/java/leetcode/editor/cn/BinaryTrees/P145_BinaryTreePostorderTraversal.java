package leetcode.editor.cn.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author solisamicus
 * @date 2024-12-21 17:44:58
 */
public class P145_BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new P145_BinaryTreePostorderTraversal().new Solution();

        TreeNode test1 = new TreeNode(1);
        test1.right = new TreeNode(2);
        test1.right.left = new TreeNode(3);
        System.out.println(solution.postorderTraversal(test1));

        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.left.right = new TreeNode(5);
        test2.left.right.left = new TreeNode(6);
        test2.left.right.right = new TreeNode(7);
        test2.right.right = new TreeNode(8);
        test2.right.right.left = new TreeNode(9);
        System.out.println(solution.postorderTraversal(test2));

        TreeNode test3 = null;
        System.out.println(solution.postorderTraversal(test3));

        TreeNode test4 = new TreeNode(1);
        System.out.println(solution.postorderTraversal(test4));
    }

    class Solution {
        private void postorder(TreeNode root, List<Integer> result) {
            if (root == null) return;
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorder(root, result);
            return result;
        }
    }

}