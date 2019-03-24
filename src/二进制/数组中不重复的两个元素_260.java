package 二进制;

public class 数组中不重复的两个元素_260 {
/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

	示例 :
	
	输入: [1,2,1,3,2,5]
	输出: [3,5]
 */
	/*两个不相等的元素在位级表示上必定会有一位存在不同。

	将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。

	diff &= -diff 得到出 diff 最右侧不为 0 的位(不相同至少有一位为1)，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
	利用这一位就可以将两个元素区分开来。
	 */
	public int[] singleNumber(int[] nums) {
	    int diff = 0;
	    for(int num : nums) diff ^= num;
	    // 得到最右一位
	    diff &= -diff;
	    int[] ret = new int[2];
	    for(int num : nums) {
	        if((num & diff) == 0) ret[0] ^= num;
	        else ret[1] ^= num;
	    }
	    return ret;
	}
}
