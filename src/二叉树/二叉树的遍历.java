package 二叉树;

import 二叉树.找树左下角的值_513.TreeNode;

	public class 二叉树的遍历 {
		public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;
	
			TreeNode(int x) {
				val = x;
			}
		}
		
		/**
		 *     1
			  / \
			 2  3
			/ \  \
		   4  5  6
		 */
		//前序遍历根左右
		void dfs(TreeNode node) {
			visited(node);
			dfs(node.left);
			dfs(node.right);
		}
		
		//中序遍历左根右
		void dfs2(TreeNode node) {
		
			dfs2(node.left);
			visited(node);
			dfs2(node.right);
		}
		
		//后序遍历左右根
		void dfs3(TreeNode node) {
		
			dfs3(node.left);
			dfs3(node.right);
			visited(node);
		}
		private int visited(TreeNode node) {
			return node.val;
			
		}
}
