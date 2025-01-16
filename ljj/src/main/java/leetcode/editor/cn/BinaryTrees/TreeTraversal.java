package leetcode.editor.cn.BinaryTrees;

import java.util.*;

public class TreeTraversal {
    // 前序遍历: 根 -> 左 -> 右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);        // 访问根节点
        preorder(root.left, result); // 遍历左子树
        preorder(root.right, result);// 遍历右子树
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    // 中序遍历: 左 -> 根 -> 右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);  // 遍历左子树
        result.add(root.val);        // 访问根节点
        inorder(root.right, result); // 遍历右子树
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    // 后序遍历: 左 -> 右 -> 根
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);  // 遍历左子树
        postorder(root.right, result); // 遍历右子树
        result.add(root.val);          // 访问根节点
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> levelorderTraversal(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        levelorder(root, resList, 0);
        for (List<Integer> level : resList) {
            result.addAll(level);
        }
        return result;
    }

    private void levelorder(TreeNode root, List<List<Integer>> resList, int level) {
        if (root == null) return;
        level++;
        if (resList.size() < level) {
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(level - 1).add(root.val);
        levelorder(root.left, resList, level);
        levelorder(root.right, resList, level);
    }

    public List<Integer> levelorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> items = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                items.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            result.addAll(items);
        }
        return result;
    }

    public static void main(String[] args) {
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 创建遍历器实例
        TreeTraversal traversal = new TreeTraversal();

        // 测试前序遍历 (预期结果: 1,2,4,5,3)
        System.out.println("前序遍历(递归版): " + traversal.preorderTraversal(root));
        System.out.println("前序遍历(迭代版): " + traversal.preorderTraversalIterative(root));

        // 测试中序遍历 (预期结果: 4,2,5,1,3)
        System.out.println("中序遍历(递归版): " + traversal.inorderTraversal(root));
        System.out.println("中序遍历(迭代版): " + traversal.inorderTraversalIterative(root));

        // 测试后序遍历 (预期结果: 4,5,2,3,1)
        System.out.println("后序遍历(递归版): " + traversal.postorderTraversal(root));
        System.out.println("后序遍历(迭代版): " + traversal.postorderTraversalIterative(root));

        // 测试层序遍历 (预期结果: 1,2,3,4,5)
        System.out.println("层序遍历(递归版): " + traversal.levelorderTraversal(root));
        System.out.println("层序遍历(迭代版): " + traversal.levelorderTraversalIterative(root));
    }
}