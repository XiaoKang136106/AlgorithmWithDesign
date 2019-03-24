package 栈和队列;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 下一个更大元素_496 {
/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

	nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
	
	示例 1:
	
	输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
	输出: [-1,3,-1]
	解释:
	    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
	    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
	    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
	示例 2:
	
	输入: nums1 = [2,4], nums2 = [1,2,3,4].
	输出: [3,-1]
	解释:
	    对于num1中的数字2，第二个数组中的下一个较大数字是3。
	    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 */
	/**
	 * 使用栈，从后往前遍历nums[i]，每当栈不为空的时候，一直出栈直到遇到比nums[i]大的数字停止。
	 * 设立一个map<int, int> m，存储nums中每一个元素以及它对应的下一个最大元素构成的映射。
	 * 如果停止后栈为空就将m[nums[i]]标记为-1，否则就写栈的栈顶元素～
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		 //辅助栈，存放待查找结果的元素，查找到的立即出栈
        Stack<Integer> stack = new Stack<>();
        //key存放元素，value存放找到的第一个大于它的值
        Map<Integer, Integer> map = new HashMap<>();
        //当栈顶元素大于当前元素时，入栈；当栈顶元素小于当前元素时，说明栈顶元素找到了第一个大于的值，出栈，
        //然后继续出栈直到栈顶元素大于当前元素，将当前元素入栈。
        //	输入: nums1 = [2,4], nums2 = [1,2,3,4].
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
              
            	map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        //ans数组存放结果
        int[] ans = new int[nums1.length];
        //遍历findNums，在map中查找结果，不存在说明没有大于它的第一个元素，赋值为-1
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
		
	}
}
