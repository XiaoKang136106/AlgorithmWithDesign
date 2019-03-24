package 排序;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 数组中的第K个最大元素_215 {
	/**
	 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

		示例 1:
		
		输入: [3,2,1,5,6,4] 和 k = 2
		输出: 5
		示例 2:
		
		输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
		输出: 4
		说明:
		
		
		
	 */
	
	//1.使用Arrays.sort()方法,O(nlogn)
	public int findKthLargest(int[] nums, int k) {
        int l = nums.length;
        Arrays.sort(nums);
        
        return nums[l-k];
    }
	
	//使用堆排序O(nlgK),空间复杂度O(k)
	public int findKthLargest2(int[] nums, int k) {
		//定义一个堆
		PriorityQueue<Integer> pq = new PriorityQueue<>();//默认为小顶堆
	    //进行遍历
		for(int val : nums) {
	        pq.offer(val);
	        if(pq.size() > k) {
	            pq.poll();//去掉小的
	        }
	    }
	    return pq.peek();
    }

}
