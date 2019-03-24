package 数学;

public class 数组中出现次数多于一半的元素_169 {
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

	你可以假设数组是非空的，并且给定的数组总是存在众数。
	
	示例 1:
	
	输入: [3,2,3]
	输出: 3
	示例 2:
	
	输入: [2,2,1,1,1,2,2]
	输出: 2
 */
	/**
	 * ：使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素不相等时，令 cnt--。如果前面查找了 i 个元素，且 cnt == 0 ，
	 * 说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
	 * 此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
	 */
	public int majorityElement(int[] nums) {
	    int cnt = 0, majority = 0;
	    for(int i = 0; i < nums.length; i++){
	        if(cnt == 0) {
	            majority = nums[i];
	            cnt++;
	        }
	        else if(majority == nums[i]) cnt++;
	        else cnt--;
	    }
	    return majority;
	}
}
