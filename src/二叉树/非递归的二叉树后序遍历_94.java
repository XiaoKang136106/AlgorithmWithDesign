package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 非递归的二叉树后序遍历_94 {
/**
 * 输入: [1,null,2,3]  
	   1
	    \
	     2
	    /
	   3 
	
	输出: [3,2,1]
 */
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	//思路:后序遍历,左右根,利用上题的根,右,左,在反转ret就可得到
	public List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> ret = new ArrayList<>();
	    if (root == null) return ret;
	    Stack<TreeNode> stack = new Stack<>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        TreeNode node = stack.pop();
	        ret.add(node.val);
	        if (node.right != null) stack.push(node.right);
	        if (node.left != null) stack.push(node.left); // 先添加左子树再添加右子树
	    }
	    Collections.reverse(ret);
	    return ret;
	}
}
