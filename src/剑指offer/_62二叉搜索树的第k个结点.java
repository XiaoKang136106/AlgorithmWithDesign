package 剑指offer;

public class _62二叉搜索树的第k个结点 {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	/*
	 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如,（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
	 */
	/*
	 * 思路：二叉搜索树按照中序遍历(左根右)的顺序打印出来正好就是排序好的顺序，第k个结点就是第K大的节点，分别递
		  归查找左右子树的第K个节点，或使用非递归借用栈的方式查找，当count=k时返回根节点。
	 */
	//int count =0;
    int index =0;
	TreeNode KthNode(TreeNode pRoot, int k){
       /* if(pRoot == null || k<1)
        	return null;
        	count++;
        	//二叉搜索树按照中序遍历(左根右)的顺序打印出来
         
          //从左(小)开始递归查找,找到就返回
          	TreeNode leftNode = KthNode(pRoot.left, k);
        	if(leftNode != null) {
        		return leftNode;
        	}
        	 if(count ==k) {
        	return pRoot;
          }
          //从左没有的话,就从往右边开始查找
        	TreeNode rightNode =KthNode(pRoot.right, k);
        	if(rightNode !=null) {
        		return rightNode;
        	}
        	return null;*/
    		 //开始遍历
		
		/*

我觉得应该是这样的 如果没有if(node != null)这句话  那么那个root就是返回给上一级的父结点的，
而不是递归结束的条件了,有了这句话过后，一旦返回了root，那么node就不会为空了，就一直一层层的递归出去到结束了。
举第一个例子{8,6,5,7,},1 答案应该是5，如果不加的时候，开始，root=8，node=kth（6,1），
继续root=6，node=kth（5,1）root =5 返回null，这时向下执行index=k=1了，
返回 5给root=6递归的时候的node，这时回到root=8了，往后面调右孩子的时候为空而把5给覆盖了。
现在就为空了，有了这句话后虽然为空，但不把null返回，而是继续返回5，个人理解
		 */
    		 if(pRoot != null){ //中序遍历寻找第k个
    		       TreeNode node = KthNode(pRoot.left,k); //左
    		     //从左(小)开始递归查找,找到就返回
    		      //if(index == k)，此时找到对应节点，但是递归并没有结束，所以需要将结果逐层返回，所以return node。
    		       if(node != null)
    		           return node;
    		            index ++;
    		        	//由于索引是从0开始的 ++ 后等于根节点
    		            if(index == k) //根
    		                return pRoot;
    		            node = KthNode(pRoot.right,k); //右
    		            if(node != null)
    		                return node;
    		        }
    		        return null;
    }
}
