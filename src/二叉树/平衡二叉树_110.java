package 二叉树;

public class 平衡二叉树_110 {
	/**
	 * 平衡树左右子树高度差都小于等于 1
	 */
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	   public boolean isBalanced(TreeNode root) {
		    int result = maxDepth(root);
		   
		   return result ==0?false:true;
	    }

	private int maxDepth(TreeNode root) {
		if(root ==null) return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		if(Math.abs(l-r)>1) return 0;
		return Math.max(l, r);
	}
}
