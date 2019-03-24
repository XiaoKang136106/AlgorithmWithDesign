package 二叉树;

import 二叉树.修剪二叉搜索树_669.TreeNode;

public class 从有序数组中构造二叉查找树_108 {
/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

	本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
	
	示例:
	
	给定有序数组: [-10,-3,0,5,9],
	
	一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
	
	      0
	     / \
	   -3   9
	   /   /
 	 -10  5
 */
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 //思路:由于排好了顺序,取每次的中间值作为下一个节点,那么就是为一颗高度平衡树
	 public TreeNode sortedArrayToBST(int[] nums) {
	        //转换成二叉查找树
		    return toBST(nums, 0, nums.length - 1);
	 }

	 private TreeNode toBST(int[] nums, int sIdx, int eIdx){
		 
	     if(sIdx > eIdx) return null;
	     //中间的索引
	     int mIdx = (sIdx + eIdx) / 2;
	     
	     TreeNode root = new TreeNode(nums[mIdx]);//由于排好了顺序,取每次的中间值作为下一个节点
	     
	     root.left =  toBST(nums, sIdx, mIdx - 1);
	     root.right = toBST(nums, mIdx + 1, eIdx);
	    
	     return root;
	 }
}
