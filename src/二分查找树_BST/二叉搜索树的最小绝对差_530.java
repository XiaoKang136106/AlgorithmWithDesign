package 二分查找树_BST;

import 二分查找树_BST.两数之和IV_653.TreeNode;

public class 二叉搜索树的最小绝对差_530 {
/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * Input:
	   1
	    \
	     3
	    /
	   2
	
	Output:
	1
 */
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 private int minDiff = Integer.MAX_VALUE;
	 private int preVal = -1; //前一个值
     public int getMinimumDifference(TreeNode root) {
    	    inorder(root);
    	    return minDiff;
    	}

     private void inorder(TreeNode node){
    	    if(node == null) return;
    	    inorder(node.left);
    	    //最小值和相邻值进行比较
    	    if(preVal != -1) minDiff = Math.min(minDiff, Math.abs(node.val - preVal));
    	    preVal = node.val;
    	    inorder(node.right);
    	}

}
