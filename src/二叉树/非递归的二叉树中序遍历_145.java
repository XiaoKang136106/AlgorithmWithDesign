package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 非递归的二叉树中序遍历_145 {
/**
 * 输入: [1,null,2,3]  
	   1
	    \
	     2
	    /
	   3 
	
	输出: [1,3,2]
 */
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	//思路:中序遍历,根左右
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> ret = new ArrayList<>();
	    if (root == null) return ret;
	    Stack<TreeNode> stack = new Stack<>();
	    //将root指向当前值
	    TreeNode cur =root;
	    while(cur != null || !stack.isEmpty()) {
	    	//模拟树不断的想左子节点深入
	    	while(cur!=null) {
	    		stack.add(cur);//压栈
	    		cur = cur.left;//一直向左深入
	    	}
	    	//出栈
	    	TreeNode node = stack.pop();
	    	ret.add(node.val);
	    	//回溯到上一个节点,在指向右子节点
	    	cur=node.right;
	    }
	    return ret;
	}
}
