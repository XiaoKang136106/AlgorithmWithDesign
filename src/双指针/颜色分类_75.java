package 双指针;

public class 颜色分类_75 {
	/*
	Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
	 */
	//0，1，2 排序。一次遍历，如果是0，则移动到表头，如果是2，则移动到表尾，不用考虑1。0和2处理完，1还会有错吗？
	//nums[i]==0,low和i的指针进行交换并且low和i都加1
	//nums[i]==1,i++
	//nums[i]==2,high和i交换,high--
	   public void sortColors(int[] nums) {
		   int low =0; 
		   int high=nums.length-1;
		   int i=0;
		   while(i<=high) {
			   
			   if(nums[i]==0) {
				   int temp=nums[low];
				   nums[low]=nums[i];
				   nums[i]=temp;
				   low++;
				   i++;
			   }else if(nums[i]==1) {
				   ++i;
			   }else if(i<=high&&nums[i]==2){
				   int tmp = nums[i];
	                nums[i] = nums[high];
	                nums[high] = tmp;
	                --high;
			   }
			   
		   }
		   
		   
	   }

}
