package 深度优先;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径_257 {
/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
	
	说明: 叶子节点是指没有子节点的节点。
	
	示例:
	
	输入:
	
	   1
	 /   \
	2     3
	 \
	  5
	
	输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> ret = new ArrayList<String>();
       if(root ==null) return ret;
       dfs(root,"",ret);
       return ret;
    }

	private void dfs(TreeNode root, String prefix, List<String> ret) {
		if(root ==null) return;
		//为叶子节点
		if(root.left==null && root.right ==null) {
			ret.add(prefix+root.val);
		}
		prefix += root.val+"->";
		dfs(root.left, prefix, ret);
		dfs(root.right, prefix, ret);
	}

}
