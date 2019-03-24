package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

import 二叉树.统计左叶子节点的和_404.TreeNode;

public class 找树左下角的值_513 {
/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。

	示例 1:
	
	输入:
	
	    2
	   / \
	  1   3
	
	输出:
	1
	 
	
	示例 2:
	
	输入:
	
	        1
	       / \
	      2   3
	     /   / \
	    4   5   6
	       /
	      7
	
	输出:
	7
 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	//思路:从右边开始使用层次遍历
	public int findBottomLeftValue(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while(!queue.isEmpty()){
	        root = queue.poll();
	        if(root.right != null) queue.add(root.right);
	        if(root.left != null) queue.add(root.left);
	    }
	    return root.val;
	}
}
