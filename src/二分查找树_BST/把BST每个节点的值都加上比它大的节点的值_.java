package 二分查找树_BST;

import 二分查找树_BST.二叉搜索树的最小绝对差_530.TreeNode;

public class 把BST每个节点的值都加上比它大的节点的值_ {
/**
 * 	Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13
	
	Output: The root of a Greater Tree like this:
	             18
	            /   \
	          20     13
 */
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	private int sum = 0;
	//思路:先遍历右子树(大的),root进行累加,在遍历左子树
	public TreeNode convertBST(TreeNode root) {
	    traver(root);
	    return root;
	}

	private void traver(TreeNode root) {
	    if (root == null) {
	        return;
	    }
	    
	    if (root.right != null) {
	        traver(root.right);
	    }
	    sum += root.val;
	    root.val = sum;
	    if (root.left != null) {
	        traver(root.left);
	    }
	}
}
