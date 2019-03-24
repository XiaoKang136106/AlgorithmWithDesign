package 二叉树;

public class 对称二叉树_101 {
	/**
	 * 给定一个二叉树，检查它是否是镜像对称的。

		例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
		
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
		
		    1
		   / \
		  2   2
		   \   \
		   3    3
	 */

	
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 
	 public boolean isSymmetric(TreeNode root) {
	       if (root ==null) return true;
	       return isSymmetric(root.left,root.right);
	    }

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left ==null && right==null ) return true; //
		if(left ==null ||right ==null) return false;//判断二者其中的一者为空,另一者不为空,返回false,不会判断二者都为null,因为上面已经判断过了
		if(left.val !=right.val ) return false;
		return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
	}
	
}
