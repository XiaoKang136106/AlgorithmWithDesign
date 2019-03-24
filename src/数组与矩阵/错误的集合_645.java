package 数组与矩阵;

public class 错误的集合_645 {
/**
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。

	给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
	
	示例 1:
	
	输入: nums = [1,2,2,4]
	输出: [2,3]
	set S的长度为n，无序存储了数字1-n，但由于data error，有一个数字出现了重复（同时意味着有一个数字缺失），找出重复数字和缺失的数字。 
	用一个map，第一遍循环，把set S过一遍，出现的数字用map标记，同时记录下重复的数字（已标记过的数字第二次读到为重复数字）。 
	第二遍循环，把map过一遍，查找缺失数字（没有被标记的数字）。 
	时间复杂度为o(n)。
 *
 */
	/**
	 * 思路:遍历数组，如果第 i 位上的元素不是 i + 1 ，那么就交换第 i 位 和 nums[i] - 1 位上的元素，使得 num[i] - 1 的元素为 nums[i] ，
	 * 也就是该位的元素是正确的。交换操作需要循环进行，因为一次交换没办法使得第 i 位上的元素是正确的。
	 * 但是要交换的两个元素可能就是重复元素，那么循环就可能永远进行下去，终止循环的方法是加上 nums[i] != nums[nums[i] - 1 条件。
	 * 
	 */
	  public int[] findErrorNums(int[] nums) {
		  int res[]=new int[2];//0位重复的数,1为缺失的数
	        //boolean类型默认初始化为false
	        boolean map[]=new boolean[nums.length+1];
	        for(int i=0;i<nums.length;i++)
	        	//
	            if(map[nums[i]]==false)
	                map[nums[i]]=true;//标记为true
	            else
	                res[0]=nums[i];//重复的数
	        for(int i=1;i<(nums.length+1);i++)
	        	//缺失的数为false,因为是从1开始的
	            if(map[i]==false){
	                res[1]=i;
	                break;
	            }
	        return res;
	    }
	  public static void main(String[] args) {
		错误的集合_645 错误的集合_645 = new 错误的集合_645();
		错误的集合_645.findErrorNums(new int[] {1,3,3,4});
	}
}
