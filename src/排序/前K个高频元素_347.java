package 排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 前K个高频元素_347 {
	/**
	 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

		示例 1:
		
		输入: nums = [1,1,1,2,2,3], k = 2
		输出: [1,2]
		示例 2:
		
		输入: nums = [1], k = 1
		输出: [1]
		说明：
		
		你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
		你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
	 * 
	 */
	
	public List<Integer> topKFrequent(int[] nums, int k) {

		//定义返回list
		List<Integer> ret = new ArrayList<>();
	    Map<Integer, Integer> map = new HashMap<>();
	    //遍历
	    for(int num : nums) {
	        //key为num 	value为num出现的次数
	    	map.put(num, map.getOrDefault(num, 0) + 1);
	    }
	    //定义一个比num大的数
	    List<Integer>[] bucket = new List[nums.length + 1];
	    //进行遍历
	    for(int key : map.keySet()) {
	        //frequency为nums出现的次数
	    	int frequency = map.get(key);
	        if(bucket[frequency] == null) {
	            bucket[frequency] = new ArrayList<>();
	        }
	        //这样做的话bucket的索引为出现的次数,值为num
	        bucket[frequency].add(key);
	    }
	    //开始从大到小遍历
	    for(int i = bucket.length - 1; i >= 0 && ret.size() < k; i--) {
	        if(bucket[i] != null) {
	        	List<Integer> list = bucket[i];
	            ret.addAll(bucket[i]);
	        }
	    }
	    return ret;
	}
	
	
	

}
