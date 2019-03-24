package 剑指offer;

import java.util.Stack;

/*
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
	输入描述:
	二叉树的镜像定义：源二叉树 
		    	    8
		    	   /  \
		    	  6   10
		    	 / \  / \
		    	5  7 9 11
		    	镜像二叉树
		    	    8
		    	   /  \
		    	  10   6
		    	 / \  / \
		    	11 9 7  5
 */
public class _18二叉树的镜像 {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	/*
	 * 思路:使用递归或非递归方式交换每个节点的左右子树位置。
	 */
	//递归,利用层序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像
	public void Mirror(TreeNode root) {
	       TreeNode temp = null;
	        if(root !=null){
	            temp=root.left;
	            root.left = root.right;
	            root.right = temp;
	            if(root.left !=null){
	                Mirror(root.left);
	            }
	            if(root.right !=null){
	                Mirror(root.right);
	            }


	        }
	/*
	public void Mirror(TreeNode root) {
        if(root==null) return;
        TreeNode temp =root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left !=null){
	           Mirror(root.left);
	            }
	   if(root.right !=null){
	                Mirror(root.right);
	   }
    } 
	         */
	        
	    }
		//非递归,
	
	  public void Mirror2(TreeNode root) {

		  			if(root == null){
			              return;
			          }
			          Stack<TreeNode> stack = new Stack<TreeNode>();
			          stack.push(root);
			          //循环栈不为空
			          while(!stack.isEmpty()){
			              TreeNode node = stack.pop();
			              //left或者right一个不为空就交换
			              if(node.left != null||node.right != null){
			                  TreeNode temp = node.left;
			                  node.left = node.right;
			                  node.right = temp;
			              }
			              if(node.left!=null){
			                  stack.push(node.left);
			              }
			              if(node.right!=null){
			                  stack.push(node.right);
			              }
			          }
	        
	    }
}
