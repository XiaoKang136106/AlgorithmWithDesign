package 剑指offer;
/*
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class _17树的子结构 {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	/*
	 * 思路:若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，则利用递归分别在左右子树中查找
	 * (子结构的意思就是要么为左边的结构,要么为右边的结构)
	 */
	/* public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	        
		 boolean result = false;
		 if (root2 != null && root1 != null) {
			 //从根节点开始,利用递归比较他们的子树是否相等，若根节点不相等，则利用递归分别在左右子树中查找
		 if(root1.val == root2.val){
			 //递归遍历是否相等
			 result = doesTree1HaveTree2(root1,root2);
		 } 
		 
		 if (!result)
			 	//只要满足一个就返回true
		 		return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
		 }
		 	return result;
		 } 
	 
	 public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
		
		 if (node2 == null) {
			 return true;
		 } 
		 if (node1 == null) {
			 return false;
		 } 
		 if (node1.val != node2.val) {
			 return false;
		 } 
		 	return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
		 }*/
		 
	//思路:利用递归思想查找,先从root节点进行查找,如果不相等,则从子节点开始查找
    //直到找到为其子结构就返回True;
	//判断是否为子结构,进行递归node2为null返回true,node1为null 返回false;node1.val!=node2.val返回false;否则继续递归
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		 boolean result =false;
		 if(root1 != null && root2 !=null) {
		 
		 //从根节点开始判断是否val相等
		 if(root1.val == root2.val) {
			 //递归,判断,下面的节点是否相同
			 result = doesTree1HaveTree2(root1, root2);
		 }
		 //如果不相等,一直查找,判断是左子树结构,还是右子树结构
		 if(!result) {
			 return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
		 }
		 }
		 return result;
	 
	 }
	 //遍历是否相等
	private boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
		//node2一定要放在前面
		if(node2 == null) {
			return true;
		}	
		if(node1 == null) {
				return false;
			}
			
			if(node1.val != node2.val) {
				return false;
			}else {
				//分别递归,左右节点
				return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
			}
		
	}
}
