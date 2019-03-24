package 排序算法2;

import java.util.Arrays;

import 排序算法.MergeSort;

public class 交换排序_快速排序 {
	
	public static void main(String[] args) {

		int[] arr = { 2, 7, 8, 3, 1,1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void sort(int[] a) {
			//时间复杂度:平均nlog2n 最好nlog2n 最差 n2 空间复杂度: log2n 不稳定
		quickSort(a,0,a.length-1);
	}
	
	
	public static void quickSort(int[] a,int low,int high) {
		if(low<high) {
			int mid =getMiddle(a, low, high);
			quickSort(a,0,mid-1);
			quickSort(a,mid+1,high);
		
		}
	}
	 private static int getMiddle(int[] a, int low, int high)
	    {
			int temp = a[low];
			while(low<high) {
				
				while(low<high && a[high]>temp) {
					high--;
				}
				a[low] = a[high];
				while(low<high && a[low] <=temp ) {
					low++;
				}
				a[high] = a[low];
			}
			a[low] = temp;
			return low;	
	    }
}
