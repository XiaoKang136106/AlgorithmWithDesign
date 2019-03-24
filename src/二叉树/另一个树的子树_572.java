package 二叉树;

import 二叉树.归并两棵树_617.TreeNode;

public class 另一个树的子树_572 {
/*
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4 
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。
 */
	//和leetcode上的那道不太一样,这里必须为底节点
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        boolean result =false;
		 if(root1 != null && root2 !=null) {
		 
		 //从根节点开始判断是否val相等
		 if(root1.val == root2.val) {
			 //递归,判断,下面的节点是否相同
			 result = doesTree1HaveTree2(root1, root2);
		 }
		 //如果不相等,一直查找,判断是左子树结构,还是右子树结构
		 if(!result) {
			 return isSubtree(root1.left,root2) || isSubtree(root1.right,root2);
		 }
		 }
		 return result;
    }
    //遍历是否相等
	private boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
		//node2一定要放在前面
		    if(node1 == null && node2 == null) return true;
		    if(node1 == null || node2 == null) return false;
			
			if(node1.val != node2.val) {
				return false;
			}else {
				//分别递归,左右节点
				return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
			}
		
	}
}
