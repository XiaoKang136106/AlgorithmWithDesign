package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 非递归的二叉树前序遍历_144 {
/**
 * 输入: [1,null,2,3]  
	   1
	    \
	     2
	    /
	   3 
	
	输出: [1,2,3]
 */
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	//思路:利用栈的思想(后进先出),来解决,先添加right,在添加left
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> ret = new ArrayList<>();
	    if (root == null) return ret;
	    Stack<TreeNode> stack = new Stack<>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        TreeNode node = stack.pop();
	        ret.add(node.val);
	        if (node.right != null) stack.push(node.right);
	        if (node.left != null) stack.push(node.left); // 先添加右子树再添加左子树，这样是为了让左子树在栈顶
	    }
	    return ret;
	}
}
