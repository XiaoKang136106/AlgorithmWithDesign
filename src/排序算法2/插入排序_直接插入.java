package 排序算法2;

import java.util.Arrays;

import 排序算法.MergeSort;

public class 插入排序_直接插入 {
	
	public static void main(String[] args) {

		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	//1、基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。

	public static void sort(int[] a) {
			//时间复杂度:平均n2 最好n 最差 n2 空间复杂度: 1 
			for (int i = 1; i < a.length; i++) {
				int temp = a[i];
				int j;
				//从后往前查找
				for (j = i-1; j >=0; j--) {
					if(temp<a[j]) {
						//把自己的位置让出
						a[j+1]=a[j];
						
					}else {
						//进行查找
						break;
					}
				}
				//向前没找到,那么就插入到当前位置(所以为i+1)
				a[j+1]=temp;
			}
	}
}
