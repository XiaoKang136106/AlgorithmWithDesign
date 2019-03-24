package 二分查找树_BST;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中的众数_501 {

	
	
	/*给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

	假定 BST 有如下定义：

	结点左子树中所含结点的值小于等于当前结点的值
	结点右子树中所含结点的值大于等于当前结点的值
	左子树和右子树都是二叉搜索树
	例如：
	给定 BST [1,null,2,2],

	   1
	    \
	     2
	    /
	   2

	   //思路:BST(中序遍历)
	   /*
分析：二叉搜索树的中序遍历的结果恰好是所有数的递增序列，根据中序遍历结果，对于当前遍历结点，标记maxCount为最大出现次数，tempCount为当前数字出现的次数，currentVal为当前保存的值。
首先，tempCount++表示当前的数字出现次数+1，如果当前结点的值不等于保存的值，就更新currentVal的值，并且将tempCount标记为1.
接下来，如果tempCount即当前数字出现的次数大于maxCount，就更新maxCount，并且将result数组清零，并将当前数字放入result数组中；
如果tempCount只是等于maxCount，说明是出现次数一样的，则将当前数字直接放入result数组中～

	   */
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	private int cnt = 1;  //当前的Count
	private int maxCnt = 1; //最大Count
	private TreeNode preNode = null; //前驱
	private List<Integer> list;	//临时的list,用于存放maxCnt的值

	public int[] findMode(TreeNode root) {
	    list = new ArrayList<>();
	    inorder(root);
	    int[] ret = new int[list.size()];
	    
	    int idx = 0;
	    for(int num : list){
		ret[idx++] = num;
	    }
	    //可能有相同的数,所以为数组
	    return ret;
	}
	//中序遍历
	private void inorder(TreeNode node){
	    if(node == null) return;
	    inorder(node.left);
	    //preNode不为空,相同则Cnt++,否则就置为1
	    if(preNode != null){
		if(preNode.val == node.val) cnt++;
		else cnt = 1;
	    }
	    //大于maxCnt,先清空list,在添加值
	    if(cnt > maxCnt){
		maxCnt = cnt;
		list.clear();
		list.add(node.val);
		//等于maxCnt只添加值
	    } else if(cnt == maxCnt){
		list.add(node.val);
	    }
	    //每次遍历都需要更换preNode
	    preNode = node;
	    inorder(node.right);
	}
}
