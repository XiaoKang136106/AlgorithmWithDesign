package 数组与矩阵;

public class 移动零_283 {
/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

	示例:
	
	输入: [0,1,0,3,12]
	输出: [1,3,12,0,0]
	
	把数组中的 0 移到末尾
 */
	
	public void moveZeroes(int[] nums) {
	    int n = nums.length;
	    int idx = 0;//定义一个指针,次指针为不为0的指针
	    //遍历 [0,1,0,3,12]
	    for(int i = 0; i < n; i++){
	    	//不为0,都移动到前面
	        if(nums[i] != 0) nums[idx++] = nums[i];
	    }
	    //结果 [1,3,12]
	    //后面补0
	    while(idx < n){
	        nums[idx++] = 0;
	    }
	}
}
