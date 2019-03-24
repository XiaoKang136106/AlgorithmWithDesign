package 排序算法2;

import java.util.Arrays;

import 排序算法.MergeSort;

public class 插入排序_二分插入 {
	
	public static void main(String[] args) {

		int[] arr = { 2, 7, 8, 3, 1,1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	//基本思想：二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，
	//这里是按二分法找到合适的位置，可以减少比较的次数。
	public static void sort(int[] a) {
			//时间复杂度:平均n2 最好n2 最差 n2 空间复杂度: 1 不稳定
			for (int i = 1; i < a.length; i++) {
				int temp = a[i];
				int left =0;
				int right =i-1;
				int mid = 0;
				//二分查找到要插入的位置
				while(left<=right) {
					mid =(left+right)>>1;
					if(temp < a[mid]) {
						right = mid-1;
					}else {
						left = mid+1;
					}
				}
				//left右边的数都要向右移一位
				for (int j = i-1; j >= left; j--) {
						a[j+1]=a[j];
				}
				
				if(left!=i) {
					
					a[left] = temp;
				}
		
			}
	}
}
