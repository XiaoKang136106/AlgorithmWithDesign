package 剑指offer;

import java.util.ArrayList;

public class _64滑动窗口的最大值 {
	
	/*
	 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
	 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
	 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
	 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
	 */
	
	/*
	 * 思路：两个for循环，第一个for循环滑动窗口，第二个for循环滑动窗口中的值，寻找最大值。还可以使用时间
		  复杂度更低的双端队列求解
	 */
	 public ArrayList<Integer> maxInWindows(int [] num, int size)
	    {
		 ArrayList<Integer> list =new ArrayList<Integer>();
		 if(num.length ==0 || num.length<size || size<1) {
			 return list;
		 }
		 //需要滑动的几次
		 int length=num.length-size+1;
		 //开始滑动
		 for (int i = 0; i < length; i++) {
			//获取每次滑动窗口最后的索引
			 int current = size+i;
			 //假设起始的滑动窗口为最大的值
			 int max = num[i];
			 //从i+1开始
			 for (int j = i+1; j < current; j++) {
				 //交换
				 if(num[j]> max) {
					 max = num[j];
				 }
			}
			 list.add(max);
			 
	    }
		 return list;
	    }
}
