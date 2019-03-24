package 剑指offer;

import 剑指offer._38二叉树的深度.TreeNode;

public class _39平衡二叉树 {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	/*
	 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树(AVL树,别于AVL算法)。
	 * 它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树等。 
	 * 最小二叉平衡树的节点总数的公式如下 F(n)=F(n-1)+F(n-2)+1
	 *  这个类似于一个递归的数列，可以参考Fibonacci(斐波那契)数列，1是根节点，F(n-1)是左子树的节点数量，F(n-2)是右子树的节点数量。
	 */
	// 思路:平衡因子的绝对值<= 1
	

		  
		    private boolean isBalanced=true;
		    public boolean IsBalanced_Solution(TreeNode root) {
		         
		        getDepth(root);
		        return isBalanced;
		    }
		    public int getDepth(TreeNode root){
		        if(root==null)
		            return 0;
		        int left=getDepth(root.left);
		        int right=getDepth(root.right);
		         
		        if(Math.abs(left-right)>1){
		            isBalanced=false;
		        }
		        return right>left ?right+1:left+1;
		    }
}
