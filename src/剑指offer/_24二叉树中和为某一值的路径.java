package 剑指offer;

import java.util.ArrayList;

/*
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class _24二叉树中和为某一值的路径 {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	private ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();
	//题目的意思:target刚刚好为一个二叉树到叶子节点的路径和 5 = 1->2->3 | 1->3->2;
	//思路:先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子节点，打印路径中的值
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null)
			return resultList;

		list.add(root.val);
		target -= root.val;//每次获取到该节点的值,路径就减该节点的值
		//判断此整数是否刚好为叶子节点,寻找的条件
		if (target == 0 && root.left == null && root.right == null) {
			//添加此路径
			//不重新new的话从始至终resultList中所有引用都指向了同一个一个list......
			resultList.add(new ArrayList<>(list));
		} else {
			//往左边进行查找
			FindPath(root.left, target);
			//往右边进行查找
			FindPath(root.right, target);
		}
		// 每返回上一层一次就要回退一个节点(回退)
		list.remove(list.size() - 1);//将最后一个移除
		return resultList;

	}

}
