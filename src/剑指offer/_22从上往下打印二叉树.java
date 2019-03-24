package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

import 剑指offer._22从上往下打印二叉树.TreeNode;

/*
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class _22从上往下打印二叉树 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
		/*
		 * 思路:利用队列,使用广度优先算法
		 */
	  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		  ArrayList<Integer> list = new ArrayList<Integer>();
		  if(root==null) {
			  return list;
		  }
		  ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		  queue.add(root);
		  //不为空
		  while(!queue.isEmpty()) {
			  //出队列
			  TreeNode node = queue.remove();
			  list.add(node.val);
			  if(root.left !=null) {
				  queue.add(node.left);
			  }
			  if(root.right !=null) {
				  queue.add(node.right);
			  }
		  }
		  
		  return list;
				  
		  
	    }

}
