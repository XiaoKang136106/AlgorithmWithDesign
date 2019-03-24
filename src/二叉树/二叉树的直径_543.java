package 二叉树;

import 二叉树.从有序数组中构造二叉查找树_108.TreeNode;

public class 二叉树的直径_543 {
/*
 * 
	给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
	
	示例 :
	给定二叉树
	
	          1
	         / \
	        2   3
	       / \     
	      4   5    
	返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 private int max = 0;

	 public int diameterOfBinaryTree(TreeNode root) {
	     depth(root);
	     return max;
	 }

	 private int depth(TreeNode root) {
	     if (root == null) return 0;
	     int leftDepth = depth(root.left);
	     int rightDepth = depth(root.right);
	     max = Math.max(max, leftDepth + rightDepth);
	     return Math.max(leftDepth, rightDepth) + 1;
	 }
	 /**
	  *     int max=0
		    public int diameterOfBinaryTree(TreeNode root) {
		        maxDepth(root);
		        return max;
		    }
		    public int maxDepth(TreeNode root){
		        if(root ==null) return 0;
		        int l = maxDepth(root.left);  
		        int r = maxDepth(root.right);        
		        max =Math.max(max,l+r);
		        return Math.max(leftDepth, rightDepth) + 1;
		    
		    }
	  */
}
