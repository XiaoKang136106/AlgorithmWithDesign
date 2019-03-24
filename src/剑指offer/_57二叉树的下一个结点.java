package 剑指offer;

public class _57二叉树的下一个结点 {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序(左根右)的下一个结点并且返回。 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
	 */
	/*
	1、有右子树的，那么下个结点就是右子树最左边的点；（eg：D，B，E，A，C，G） 
	2、没有右子树的(遍历到底了)，也可以分成两类，a)是父节点左孩子（eg：N，I，L） ，那么父节点就是下一个节点 ； 
							 b)是父节点的右孩子（eg：H，J，K，M）找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置(因为为中序遍历的顺序,所以pNode.next为其父节点)。如果没有eg：M，那么他就是尾节点。
	 */
	//pNode:为排好顺序的中序遍历
/*	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
			//是否有右子树
		if (pNode.right != null) {
			//将当前节点指向下一个节点
			pNode = pNode.right;
			
			while (pNode.left != null) {
				//遍历到左叶子结点
				pNode = pNode.left;
			}
			return pNode;
		}
			//没有右子树
		while (pNode.next != null) {
			// 找第一个当前节点是父节点左孩子的节点
				//左根右
				//判断是否父节点的左节点是否为当前节点
			if (pNode.next.left == pNode)
				return pNode.next;
			pNode = pNode.next;
		}
		return null;

	}*/
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode ==null)
			return null;
		if(pNode.right !=null) {
			pNode = pNode.right;
			while(pNode.left !=null) {
				pNode = pNode.left;
			}
			return pNode;
		}
		
		while(pNode.next !=null) {
			
			if(pNode.next.left == pNode) {
				return pNode.next;
			}
			pNode = pNode.next;
		}
		return null;

	}

}
