package 排序算法2;

import java.util.Arrays;

import 排序算法.MergeSort;

public class 交换排序_冒泡排序 {
	
	public static void main(String[] args) {

		int[] arr = { 2, 7, 8, 3, 1,1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void sort(int[] a) {
			//时间复杂度:平均n2 最好n 最差 n2 空间复杂度: 1 稳定
		
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j <a.length-1-i; j++) {
				if(a[j]>a[j+1]) {
					int temp =a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
		}
			}
	}
}
