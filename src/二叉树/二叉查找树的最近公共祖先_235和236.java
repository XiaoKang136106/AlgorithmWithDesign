package 二叉树;

import 二叉树.二叉树的直径_543.TreeNode;

public class 二叉查找树的最近公共祖先_235和236 {
/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
				（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * 
 */
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 //思路:满足左子树所有节点<根节点<右子树所有节点。假设p.val < q.val，那么它们的最近公共祖先节点r，一定满足：p.val <= r.val <=q.val。
	 
	   TreeNode res = null;
	    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
	        
	        lca(root, p , q);
	        return res;
	    }
	    
	    public void lca(TreeNode root, TreeNode p , TreeNode q){
	    	//root位于二者之间
	        if((root.val - p.val)*(root.val - q.val) <= 0){
	            res = root;
	        }else if(root.val < p.val && root.val < q.val){
	        	//小于需要增大
	            lca(root.right, p , q);
	        }else{
	        	//大于需要减小
	            lca(root.left, p , q);
	        }
	    }
	 
	 //二叉树leetcode_236
	 
	 //1.root =null 或者p,q的话, 最近公共祖先为root 2.left 为空 最近公共祖先为right  3.left不为空 右节点为空,最近公共祖先为左节点,不为空,为root节点
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		    if (root == null || root == p || root == q) return root;
		    TreeNode left = lowestCommonAncestor(root.left, p, q);
		    TreeNode right = lowestCommonAncestor(root.right, p, q);
		    return left == null ? right : right == null ? left : root;
		}


	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		 if(root ==null || root ==p || root ==q) return root;
		 //向下找是否到达子节点
	     TreeNode left = lowestCommonAncestor2(root.left,p,q);
	     TreeNode right = lowestCommonAncestor2(root.right,p,q);
	     return left ==null?right:(right ==null? left :root);
		}
	
}
