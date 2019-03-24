package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

import 剑指offer._60把二叉树打印成多行.TreeNode;

public class _60把二叉树打印成多行 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	/*
	 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
	 */
	// 思路：利用辅助空间链表或队列来存储节点，每层输出。
/*	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (pRoot == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		ArrayList<Integer> list = new ArrayList<>();
		int start = 0;
		int end = 1;
		while (!queue.isEmpty()) {
			//取出头结点
			TreeNode node = queue.pop();
			list.add(node.val);
			start++;
			if (node.left != null)
				//添加左节点
				queue.offer(node.left);
			if (node.right != null)
				//添加右节点
				queue.offer(node.right);
			//到达了该层的最后一个节点
			if (start == end) {
				start = 0;
				end = queue.size();
				res.add(new ArrayList<>(list));
				list.clear();
			}
		}
		return res;

	}*/
	
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(pRoot == null) 
			return res;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(pRoot);
		int start = 0; 
		int end = 1; //该层的最后一个节点
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			//取出头结点
			TreeNode node = queue.pop();
			list.add(node.val);
			start++;
				if(node.left != null) 
					queue.offer(node.left);
				if(node.right !=null)
					queue.offer(node.right);
				
				if(start ==end ) {	
					start =0;
					end =queue.size();
					res.add(new ArrayList<Integer>(list));
					list.clear();
				}
		}
			
			return res;

	}

}
