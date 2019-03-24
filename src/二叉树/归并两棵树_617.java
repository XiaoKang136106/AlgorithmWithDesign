package 二叉树;

import 二叉树.翻转树_226.TreeNode;

public class 归并两棵树_617 {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
/**
 * 输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 */
	  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	     if(t1 == null && t2 == null) return null;   
	     if(t1 == null ) return t2;   
	     if(t2 == null ) return t1;
	     TreeNode root = new TreeNode(t1.val+t2.val);
	     root.left=mergeTrees(t1.left,t2.left);
	     root.right=mergeTrees(t1.right,t2.right);
	     return root;
	    }
}
