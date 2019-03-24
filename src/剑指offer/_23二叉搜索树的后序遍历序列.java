package 剑指offer;

import java.util.Arrays;

/*
 * 					左右根          左<根<右
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class _23二叉搜索树的后序遍历序列 {
	
	
	/*
	采用分治法的思想，找到根结点、左子树的序列、右子树的序列，
	分别判断左右子序列是否为二叉树的后序序列。

	由题意可得：
	1. 后序遍历序列的最后一个元素为二叉树的根节点；
	2. 二叉搜索树左子树上所有的结点均小于根结点、右子树所有的结点均大于根结点。

	算法步骤如下：
	1. 找到根结点；
	2. 遍历序列，找到第一个大于等于根结点的元素i，则i左侧为左子树、i右侧为右子树；
	3. 我们已经知道i左侧所有元素均小于根结点，那么再依次遍历右侧，看是否所有元素均大于根结点；若出现小于根结点的元素，则直接返回false；
	        若右侧全都大于根结点，则：
	4. 分别递归判断左/右子序列是否为后序序列；
	*/
	public boolean VerifySquenceOfBST3(int [] sequence) {
	        if(sequence.length == 0){
	            return false;
	        }
	        if(sequence.length == 1){
	            return true;
	        }
	        return judge(sequence,0,sequence.length-1);
	    }
	     
	    public boolean judge(int[] a,int start,int end){
	        
	    	//到尾了,还没有找到不满足的条件返回true
	    	if(start >= end){
	            return true;
	        }
	        //定义i从start开始,查找右子序列
	        int i = start;
	        //查找第一个右序列的节点,左子节点都小于根节点
	        while(a[i] < a[end]){
	            ++i;
	        }
	        //从右序列开始
	        for(int j=i;j<end;j++){
	        	//右序列都会大于根节点的
	            if(a[j] < a[end]){
	                return false;
	            }
	        }
	        //每次都需要去掉根节点
	        return judge(a,start,i-1) && judge(a,i,end-1);
	    }

	
	
	
	
	
	
	

	/*public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0)
			return false;
		int rstart = 0;
		int length = sequence.length;
		//从0开始遍历,除了最后一个
		for (int i = 0; i < length - 1; i++) {
			//每次遍历都判断是否小于最后一个(右)
			if (sequence[i] < sequence[length - 1])
				//true -> rstart++
				rstart++;
		}
		if (rstart == 0) {
			//数组中的元素从大到小,排序的,递归调用自己
			VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
		} else {
			for (int i = rstart; i < length - 1; i++) {
				if (sequence[i] <= sequence[length - 1]) {
					return false;
				}
			}
			//归并
			VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rstart));
			VerifySquenceOfBST(Arrays.copyOfRange(sequence, rstart, length - 1));
		}
		return true;

	}*/
	//二叉树的后序遍历:(左,右,根)左节点小于右节点,并且最后一个数是最小的
	//思路:先找到右子树的开始位置，然后分别进行左右子树递归处理。
	/*
	
	/非递归 
	//非递归也是一个基于递归的思想：
	//左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
	//最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件
	//即可，即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理
	 */
	public boolean VerifySquenceOfBST(int[] sequence) {
		if(sequence ==null || sequence.length==0)
			return false;
		int rstart = 0; //作为右子树开始的索引位置
		int length = sequence.length;
		//从0开始遍历
		for(int i=0;i<length-1;i++) {
			//左子树的索引都是小于右子树的索引
			if(sequence[i]< sequence[length-1]) {
				rstart++;
			}
		}
		//rstart=0说明前面的数都大于后面的数,可能是某个右子树链,继续遍历,如果是的话,就进行遍历
		if(rstart == 0) {
			//递归下一个开始
			VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, length-1));
		}else {
			//找到右子树开始的索引位置
			for(int i=rstart;i<length -1; i++) {
				//如果右子树的值小于根,直接返回false
				if(sequence[i]<=sequence[length-1]) {
					return false;
				}
			}
			//左右递归处理
			VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rstart));
			VerifySquenceOfBST(Arrays.copyOfRange(sequence, rstart, length-1));
		}
			return true;
	}
	

	

}
