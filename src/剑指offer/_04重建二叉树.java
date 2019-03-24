package 剑指offer;

import java.util.Arrays;


public class _04重建二叉树 {
	
	/*
	 *  重建二叉树
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
	 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 */
	   //思路:因为前序遍历根左右,后序遍历左根右的特点,找到根节点,来进行划分区间
       //利用递归的思想来求解,每次递归当成一颗新的树来找到根节点进行划分,最终遍历完就返回
      //先列出终止条件
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 /*
	  *	递归思想，每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找，
	  *	前序的开始结束索引通过计算中序中左右子树的大小来计算，然后递归求解，直到startPre>endPre||startIn>endIn
	  	*说明子树整理完了。
	  *	方法每次返回左子树和右子树的根节点
	  */
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	      if (pre == null || in == null) {
	          return null;
	          }
	      if (pre.length == 0 || in.length == 0) {
	          return null;
	          }
	      if (pre.length != in.length) {
	          return null;
	          }
	      //获取root节点
	      //前序 根 左 右 			中序  左 根 右
	      
	      TreeNode root = new TreeNode(pre[0]); //获取第一个元素
	      for(int i =0;i<in.length;i++) {
	    	  
	          if(pre[0] == in[i]) {
	        	  //2,4,7            4,7,2
	              root.left = reConstructBinaryTree(
	                      Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
	              	//注意in的i为root所以都是从i+1开始
	              root.right = reConstructBinaryTree(
	                      Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
	               
	          }
	         
	           
	      }
	       
	      return root;
	         
	         
	    }

}
