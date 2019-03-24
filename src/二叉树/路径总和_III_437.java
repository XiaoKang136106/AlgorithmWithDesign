package 二叉树;

import 二叉树.路径总和_112.TreeNode;

public class 路径总和_III_437 {

/*
  root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

	      10
	     /  \
	    5   -3
	   / \    \
	  3   2   11
	 / \   \
	3  -2   1
	
	Return 3. The paths that sum to 8 are:
	
	1.  5 -> 3
	2.  5 -> 2 -> 1
	3. -3 -> 11
	找出路径和等于给定数值的路径总数,路径不需要从根节点开始，
	也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
*/
		
	
	
	
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	//思路:分3种情况,直接从root开始查询,不从root开始(左节点开始向下查询,右节点开始向下查询),查找的条件就是sum==root.val
	public int pathSum(TreeNode root, int sum) {
	    if(root == null) return 0;
	    int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	    return ret;
	}

	private int pathSumStartWithRoot(TreeNode root, int sum){
	    if(root == null) return 0;
	    int ret = 0;
	    if(root.val == sum) ret++;
	    //可能下面的组合数还会等于sum
	    ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
	    return ret;
	}
}
