package 二叉树;

import 二叉树.二叉树的最小深度_111.TreeNode;

public class 统计左叶子节点的和_404 {
/**
 * 3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public int sumOfLeftLeaves(TreeNode root) {
	    if(root == null) {
	        return 0;
	    }
	    if(isLeaf(root.left)) {
	        return root.left.val +  sumOfLeftLeaves(root.right);
	    }
	    return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}

	private boolean isLeaf(TreeNode node){
	    if(node == null) {
	        return false;
	    }
	    return node.left == null && node.right == null;
	}
}
