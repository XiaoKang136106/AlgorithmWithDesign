package 剑指offer;

import java.util.Arrays;

public class _45扑克牌顺子 {
	/*
	 * 一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)... 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
	 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
	 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
	 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),大小王为0
	 */
	// 思路：用数组记录五张扑克牌，将数组调整为有序的，若0出现的次数>=顺子的差值，即为顺子
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return false;
		int count = 0; //为0的有多少张
		int diff = 0; //前后相差的值为多少
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length - 1; i++) {
			//判断有多少个位0的牌
			if (numbers[i] == 0) {
				count++;
				continue;
			}
			
			if (numbers[i] != numbers[i + 1]) {
				diff += numbers[i + 1] - numbers[i] - 1;
			} else {
				//除0外,还有相同的纸牌,返回false
				return false;
			}
		}
		
		if (diff <= count)
			return true;
		return false;

	}

}
