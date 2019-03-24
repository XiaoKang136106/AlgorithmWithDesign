package 剑指offer;

public class _58对称的二叉树 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}
	/*
	 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
	 */
	/*
	 * 思路：利用递归进行判断，若左子树的左孩子等于右子树的右孩子且左子树的右孩子等于右子树的左孩子，并
			且左右子树节点的值相等，则是对称的
	左节点的val==右节点的val && 左节点的左子孩子==右节点的右孩子 &&左节点的右子孩子 ==右节点的左孩子
	 */
	boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot == null)
			return true;
		return isCommon(pRoot.left,pRoot.right);
	}
	private boolean isCommon(TreeNode left, TreeNode right) {
		if(left ==null && right ==null)
			return true;
		if(left !=null && right !=null)
			return left.val == right.val && isCommon(left.left, right.right) && isCommon(left.right, right.left);
		return false;
	}

}
