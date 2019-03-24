package 双指针;

public class 合并两个有序数组_88 {
	
	/*
	 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

		说明:
		
		初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
		你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
		示例:
		
		输入:
		nums1 = [1,2,3,0,0,0], m = 3
		nums2 = [2,5,6],       n = 3
		
		输出: [1,2,2,3,5,6]
	 * 
	 */
	  public void merge(int[] nums1, int m, int[] nums2, int n) {
		  int i = m - 1, j = n - 1; // 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值
		    int idx = m + n - 1; //总索引
		    while(i >= 0 || j >= 0){
		    	//从后往前添加数据
		        //i的个数小于j
		    	if(i < 0) nums1[idx] = nums2[j--]; //将j的剩下的数字放入
		        else if(j < 0) nums1[idx] = nums1[i--];//将i剩下的数字放入
		    	//大的放到后面
		        else if(nums1[i] > nums2[j]) nums1[idx] = nums1[i--];
		        else nums1[idx] = nums2[j--];
		        idx--;
		    }		 
			 
		 }

}
