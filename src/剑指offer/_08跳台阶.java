package 剑指offer;

public class _08跳台阶 {
	/*
	 * 跳台阶 
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
	 */
    //思路:,斐波那列数列规律
    //1,2,3,5(4级台阶等于上2级台阶和上3级台阶之和,因为可以跳1级台阶,也可以跳2级台阶)
	public int JumpFloor(int target) {
		if (target < 2) {
			return target;
		}
		// 1 2 3 5
		int result = 0;
		int preOne = 0;
		int preTwo = 1;
		for (int i = 1; i <= target; i++) {
			result = preOne + preTwo;
			preOne = preTwo;
			preTwo = result;
		}

		return result;

	}

}
