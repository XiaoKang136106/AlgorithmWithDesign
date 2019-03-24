package 二叉树;

import 二叉树.平衡二叉树_110.TreeNode;

public class 树的最大高度_104 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private boolean result = true;

	public boolean isBalanced(TreeNode root) {
		maxDepth(root);
		return result;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		if (Math.abs(l - r) > 1)
			result = false;
		return 1 + Math.max(l, r);
	}
}
