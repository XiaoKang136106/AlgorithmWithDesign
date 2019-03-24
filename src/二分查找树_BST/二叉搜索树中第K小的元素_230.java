package 二分查找树_BST;

import 二分查找树_BST.两数之和IV_653.TreeNode;

public class 二叉搜索树中第K小的元素_230 {

	
/*	给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

	说明：
	你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

	示例 1:

	输入: root = [3,1,4,null,2], k = 1
	   3
	  / \
	 1   4
	  \
	   2
	输出: 1
	示例 2:

	输入: root = [5,3,6,2,4,null,null,1], k = 3
	       5
	      / \
	     3   6
	    / \
	   2   4
	  /
	 1
	输出: 3*/
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	//思路:使用中序遍历求解,每次遍历到左节点的时候,cnt+1,因为为最小的值,如果cnt==k,就是当前查找的值
	private int cnt = 0;
	private int val;

	public int kthSmallest(TreeNode root, int k) {
	    inorder(root, k);
	    return val;
	}

	private void inorder(TreeNode node, int k) {
	    if(node == null) return;
	    inorder(node.left, k);
	    cnt++;
	    if(cnt == k) {
	        val = node.val;
	        return;
	    }
	    inorder(node.right, k);
	}
}
