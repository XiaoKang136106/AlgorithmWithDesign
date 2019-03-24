package 二叉树;

import 二叉树.二叉树的直径_543.TreeNode;

public class 找出二叉树中第二小的节点_671 {
/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

示例 1:

输入: 
    2
   / \
  2   5
     / \
    5   7

输出: 5
说明: 最小的值是 2 ，第二小的值是 5 。
示例 2:

输入: 
    2
   / \
  2   2

输出: -1
说明: 最小的值是 2, 但是不存在第二小的值。
 */
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	/*
	 * 思路:一开始这题用的是深度优先搜索，虽然没有错，但是却没有利用好题目所给的条件，效率不高。(root不大于子节点)下层越来越大并且一定会大于等于父节点
题目所给的函数原型为int findSecondMinimumValue(TreeNode* root) ，对于这样一个函数，可以这样理解：返回值是与root->val不同的值。分四种情况：
1、如果root的值与左右孩子的值各不相同，那么返回的是左右孩子的最小值
2、如果root的值与左孩子值相同，且与右孩子值不同。(第二小的值就是左孩子的子节点和右孩子的最小值)
	那么，只要递归调用左孩子得到的返回值不为-1，那么答案就是返回值与右孩子值的最小值。否则，答案就是右孩子的值
3、如果root的值与右孩子值相同，且与左孩子值不同。(第二小的值就是右孩子的子节点和左孩子的最小值)
	那么，只要递归调用右孩子得到的返回值不为-1，那么答案就是返回值与左孩子值的最小值。否则，答案就是左孩子的值
4、如果root的值与左右孩子的值都相同，那么返回的是递归调用左右孩子的返回值的最小值。如果有返回值是-1，那么结果是另一个返回值（即使也有可能是-1）
	 */
	public int findSecondMinimumValue(TreeNode root) {
	    if(root == null) return -1;
	    //说明root为叶子结点
	    if(root.left == null && root.right == null) return -1;
	    //左孩子的值
	    int leftVal = root.left.val;
	    //右孩子的值
	    int rightVal = root.right.val;
	    //左孩子 等于Root,找左孩子的孩子和右孩子的最小值,赋给左孩子,没找到的话,值为-1,找到了就是第二小的数
	    if(leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
	    //右孩子 等于Root,找右孩子的孩子和左孩子的最小值,赋给右孩子,没找到的话,值为-1,找到了就是第二小的数
	    if(rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
	    //左,右孩子都不等于root,说明都有值,需要比较大小,直接返回
	    if(leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
	    //左孩子不为-1,返回左孩子,递归调用左右孩子的返回值的最小值
	    if(leftVal != -1) return leftVal;
	    
	    return rightVal;
	}
	
	public int findSecondMinimumValue2(TreeNode root) {
		if(root ==null) return -1;
		if(root.left==null && root.right==null) return -1;
		int leftVal = root.left.val;
		int rightVal = root.right.val;
		if(leftVal ==root.val) leftVal=findSecondMinimumValue(root.left);
		if(rightVal ==root.val) rightVal=findSecondMinimumValue(root.right);
		
		if(leftVal != -1 && rightVal !=-1) return Math.min(leftVal, rightVal);
		
		if(leftVal != -1) return leftVal;
		return rightVal;
	}
}
