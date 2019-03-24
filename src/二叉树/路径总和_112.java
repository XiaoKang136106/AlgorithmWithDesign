package 二叉树;

import 二叉树.归并两棵树_617.TreeNode;

public class 路径总和_112 {
/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

	说明: 叶子节点是指没有子节点的节点。
	
	示例: 
	给定如下二叉树，以及目标和 sum = 22，
	
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	        判断:路径和是否等于一个数
 */
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  //思路:递归思想,sum-当前节点的值,如果为叶子节点并且当前值等于递归后剩下的值
	public boolean hasPathSum(TreeNode root, int sum) {
	    if(root == null) return false;
	    if(root.left == null && root.right == null && root.val == sum) return true;
	    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
