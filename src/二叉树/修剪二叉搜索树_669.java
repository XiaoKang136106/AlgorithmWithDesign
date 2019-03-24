package 二叉树;

public class 修剪二叉搜索树_669 {
/**
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
	
	示例 1:
	
					输入: 
					    1
					   / \
					  0   2
					
					  L = 1
					  R = 2
					
					输出: 
					    1
					      \
					       2
					示例 2:
					
					输入: 
					    3
					   / \
					  0   4
					   \
					    2
					   /
					  1
					
					  L = 1
					  R = 3
					
					输出: 
					      3
					     / 
					   2   
					  /
					 1
 */
	//左子树越来越小,右子树越来越大
	//思路:对于任意一个节点，左子树上所有节点的值，都小于该节点的值，右子树的所有节点的值都大于该节点的值
	//当root的值位于L和R之间，则递归修剪其左右子树，返回root。
	//当root的值小于L，则其左子树的值都小于L，抛弃左子树，返回修剪过的右子树。
	//当root的值大于R，则其右子树的值都大于R，抛弃右子树，返回修剪过的左子树。
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	 public TreeNode trimBST(TreeNode root, int L, int R) {
		 	if(root == null) return null;
		    if(root.val > R) return trimBST(root.left, L, R); //root的值大于右边,右边的值都抛弃,返回左边的值
		    if(root.val < L) return trimBST(root.right, L, R);//root的值小于左边,左边的值都抛弃,返回右边的值
		    root.left = trimBST(root.left, L, R);
		    root.right = trimBST(root.right, L, R);
		    return root;
	    }
}
