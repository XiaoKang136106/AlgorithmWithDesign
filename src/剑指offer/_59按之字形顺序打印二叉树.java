package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

import 剑指offer._59按之字形顺序打印二叉树.TreeNode;

public class _59按之字形顺序打印二叉树 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	/*
	 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
	 */
	//思路：利用两个栈的辅助空间分别存储奇数偶数层的节点，然后打印输出。或使用链表的辅助空间来实现，利用链表的反向迭实现逆序输出
/*	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (pRoot == null)
			return res;
		Stack<TreeNode> s1 = new Stack<>(); // s1表示奇数，从右向左输出
		Stack<TreeNode> s2 = new Stack<>(); // s2表示偶数，从左向右输出
		s1.push(pRoot);
		int level = 1;
		while (!s1.empty() || !s2.empty()) {
			//判断是否为奇数
			if (level % 2 != 0) {
				// => 为奇数
				ArrayList<Integer> list = new ArrayList<>();
				while (!s1.empty()) {
					TreeNode node = s1.pop();
					if (node != null) {
						list.add(node.val);
						s2.push(node.left);
						s2.push(node.right);
					}
				}
				if (!list.isEmpty()) {
					res.add(list);
					level++;
				}
			} else {
				// 为偶数
				ArrayList<Integer> list = new ArrayList<>();
				//判断栈是否为空
				while (!s2.empty()) {
					//出栈
					TreeNode node = s2.pop();
					//判断是否为叶子结点
					if (node != null) {
						list.add(node.val);
						s1.push(node.right);
						s1.push(node.left);
					}
				}
				if (!list.isEmpty()) {
					res.add(list);
					level++;
				}
			}
		}
		return res;
	}*/
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		//定义一个方向的list
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		//定义2个栈
		Stack<TreeNode> s1 = new Stack<TreeNode>(); //奇数,从右向左
		Stack<TreeNode> s2 = new Stack<TreeNode>(); //偶数,从左向右
		int level =1; //深度
		s1.push(pRoot);
		//开始遍历,一行一行的遍历
		while (!s1.isEmpty() || !s2.isEmpty()) {
			//判断是否为奇数
			if(level %2 !=0) {
				//创建list
				ArrayList<Integer> list = new ArrayList<Integer>();
				//奇数
				while(!s1.isEmpty()) {
					//取出栈顶的元素
					TreeNode node = s1.pop();
					if(node !=null) {
						list.add(node.val);
						//将偶数行的压栈,由于偶数行前面的向压进去了,所有,后面压栈的在前面
						s2.push(node.left);
						s2.push(node.right);
					}
				}
				//将list添加到res中
				if(!list.isEmpty()) {
					res.add(list);
					level++;
				}
				
			}else {
				//偶数行
				ArrayList<Integer> list = new ArrayList<Integer>();
				
				while(!s2.isEmpty()) {
					TreeNode node = s2.pop();
					if(node !=null) {
						list.add(node.val);
						//由于后面的在前面,所以,后压栈的为最前面的节点
						s1.push(node.right);
						s1.push(node.left);
					}
					
				}
				//将list添加到res中
				if(!list.isEmpty()) {
					res.add(list);
					level++;
				}
			}
		}
		
 		return res;
	}
}
