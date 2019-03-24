package 排序算法2;

import java.util.Arrays;

import 排序算法.MergeSort;

public class 选择排序_直接选择排序 {
	
	public static void main(String[] args) {

		int[] arr = { 2, 7, 8, 3, 1,1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * 思路:选择排序:直接选择排序,每趟从待排序的记录序列中选择关键字最小的记录放置到已排序表的最前位置，直到全部排完。 )
*  基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，
*  如此循环到倒数第二个数和最后一个数比较为止。
	 * 
	 */
	public static void sort(int[] a) {
			//时间复杂度:平均n2 最好n2 最差 n2 空间复杂度: 1 稳定
			for (int i = 0; i < a.length; i++) {
				int min =a[i];//最小数
				int n =i; 	//最小数的索引
				//向后开始查找
				for (int j = i+1; j < a.length; j++) {
					if(a[j]<min) {
						min =a[j];
						n=j;
					}
				}
				//找到了最小数了
				a[n]=a[i];
	        	a[i]=min;
			}
	}
}
