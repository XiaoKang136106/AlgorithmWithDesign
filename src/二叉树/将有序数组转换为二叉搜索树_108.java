package 二叉树;


public class 将有序数组转换为二叉搜索树_108 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
	    return toBST(nums, 0, nums.length - 1);
	}

	private TreeNode toBST(int[] nums, int sIdx, int eIdx){
	    if(sIdx > eIdx) return null;
	    int mIdx = (sIdx + eIdx) / 2;
	    TreeNode root = new TreeNode(nums[mIdx]);
	    root.left =  toBST(nums, sIdx, mIdx - 1);
	    root.right = toBST(nums, mIdx + 1, eIdx);
	    return root;
	}

}
