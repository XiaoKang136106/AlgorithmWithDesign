package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class 最长和谐序列_594 {
/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。

	现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
	
	示例 1:
	
	输入: [1,3,2,2,5,2,3,7]
	输出: 5
	原因: 最长的和谐数组是：[3,2,2,2,3].
 */
	public int findLHS(int[] nums) {
	    Map<Long, Integer> map = new HashMap<>();
	    for (long num : nums) {
	    	//遍历数组,key为nums的值,value为个数
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }
	    int result = 0;
	    //遍历map
	    for (long key : map.keySet()) {
	        //map中的key存在当前key+1的数
	    	if (map.containsKey(key + 1)) {
	    		//进行比较当前的key和key+1的value和之前的结果那个更大
	            result = Math.max(result, map.get(key + 1) + map.get(key));
	        }
	    }
	    return result;
	}
}
