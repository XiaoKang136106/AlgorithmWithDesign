package 二叉树;

import 二叉树.树的最大高度_104.TreeNode;

public class 翻转树_226 {
/**
 * 输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  public TreeNode invertTree(TreeNode root) {
		  	if(root ==null) return null;
		  	TreeNode left = root.left; //后面的操作已经改变left的指针,所以,需要先保存
		  	root.left = invertTree(root.right);//这里的操作改变的left的指针
		  	root.right = invertTree(left);
		  	return root;
	  
	  }
}
