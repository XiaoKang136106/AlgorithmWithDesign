package 二叉树;

import 二叉树.二叉查找树的最近公共祖先_235和236.TreeNode;

public class 最长同值路径_687 {
/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

	注意：两个节点之间的路径长度由它们之间的边数表示。

			示例 1:
			
			输入:
			
			              5
			             / \
			            4   5
			           / \   \
			          1   1   5
			输出:
			
			2
			示例 2:
			输入:
			
			              1
			             / \
			            4   5
			           / \   \
			          4   4   5
			输出:
			
			2
 */
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 //思路:使用dfs算法,定义一个全局的path,在搜索遍历的时候,进行搜索
	 private int path =0;
	 public int longestUnivaluePath(TreeNode root) {
	        dfs(root);
	        return path;
	    }
	 
	 	private int dfs(TreeNode root){
		    if(root == null) return 0;
		    int left = dfs(root.left);
		    int right = dfs(root.right);
		    int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
		    int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
		    path = Math.max(path, leftPath + rightPath);
		    return Math.max(leftPath, rightPath);
		}
	 	
}
