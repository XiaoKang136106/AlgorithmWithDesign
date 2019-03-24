package 剑指offer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _30连续子数组的最大和 {
	/*
	 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
	 * 当向量全为正数的时候,问题很好解决。 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
	 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
	 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
	 * 
	 */
	//思路:创建一个sum和tempSum,都指向第一个1数(防止,数组的值为<0的情况),从1开始向后遍历,
	//如果tempSum<0,就不要,只要array[i]
    //否则为tempSum+array[i],比较tempSum和sum
	
	
	// 思路:若和小于0，则将最大和置为当前值，否则计算最大和。
	public int FindGreatestSumOfSubArray(int[] array) {

		if (array.length == 0)
			return 0;
		int sum = array[0];
		int tempsum = array[0]; // 注意初始值 不能设为0 ,防止只有负数的情况
		for (int i = 1; i < array.length; i++) // 从1开始 因为0的情况在初始化时完成了
		{
			tempsum = (tempsum < 0) ? array[i] : tempsum + array[i];
			sum = (tempsum > sum) ? tempsum : sum;
		}
		return sum;

	}

}
