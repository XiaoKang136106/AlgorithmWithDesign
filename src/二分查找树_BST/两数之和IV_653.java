package 二分查找树_BST;

import java.util.ArrayList;
import java.util.List;


public class 两数之和IV_653 {
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 /*
	  * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
		输入: 
		    5
		   / \
		  3   6
		 / \   \
		2   4   7
		
		Target = 9
		
		输出: True
		输入: 
		    5
		   / \
		  3   6
		 / \   \
		2   4   7
		
		Target = 28
		
		输出: False
	  */
	 //中序遍历:左根右,创建一个list刚刚好变成有顺序了
	 public boolean findTarget(TreeNode root, int k) {
		 List<Integer> nums = new ArrayList<>();
		    inOrder(root, nums);
		    int i = 0, j = nums.size() - 1;
		    while(i < j){
		        int sum = nums.get(i) + nums.get(j);
		        if(sum == k) return true;
		        if(sum < k) i++;
		        else j--;
		    }
		    return false;
		}

		private void inOrder(TreeNode root, List<Integer> nums){
		    if(root == null) return;
		    inOrder(root.left, nums);
		    nums.add(root.val);
		    inOrder(root.right, nums);
		}

}
