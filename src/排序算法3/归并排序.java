package 排序算法3;

import java.util.Arrays;

/**
 * 
 * @ClassName: MergeSort
 * @Description: TODO(归并排序)
 *               基本思想:归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
 * @author xiaok
 * @date 2018年10月4日 下午3:10:14
 *
 */
public class 归并排序 {

	// 归并排序的实现
	public static void main(String[] args) {
		//平均nlog2n 最好nlog2n 最差 nlog2n 空间 n2 复杂
		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		归并排序.sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int low, int high) {
			
			if(low<high) {
			int mid =(low+high)>>1;	
			sort(arr, low, mid);
			sort(arr, mid+1, high);
			merge(arr, low, mid, high);
			}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high-low+1];
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=high) {
			if(arr[i]<arr[j]) {
				temp[k++]=arr[i++];
			}else {
				temp[k++]=arr[j++];
			}
		}
		while(i<=mid) {
			temp[k++]=arr[i++];
		}
		while(j<=high) {
			  temp[k++]=arr[j++];
		}
		for (int l = 0; l < temp.length; l++) {
			arr[low+l]=temp[l];
		}
	}
	//注意：新建的temp长度和原数组是一样的，所以额外空间是O（n），temp数组一开始并未赋值，在合并时慢慢给其填充数值，所以说一共只有一个temp数组
	public void mergeSort(int[] arr) {
	        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	    }

	    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
	        if (left < right) {  // Java则通过左右指针来判断
	            int center = (left + right) / 2;
	            mergeSort(arr, temp, left, center); // 左边
	            mergeSort(arr, temp, center + 1, right); // 右边
	            merge(arr, temp, left, center + 1, right); // 合并两个有序
	        }
	    }
	    private static void merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd) {
	        int leftEnd = rightPos - 1; // 左边结束下标
	        int tempPos = leftPos; // 从左边开始算
	        int numEle = rightEnd - leftPos + 1; // 元素个数
	        while (leftPos <= leftEnd && rightPos <= rightEnd) {
	            if (arr[leftPos] <= arr[rightPos])
	                temp[tempPos++] = arr[leftPos++];
	            else
	                temp[tempPos++] = arr[rightPos++];
	        }
	        while (leftPos <= leftEnd) {  // 左边如果有剩余
	            temp[tempPos++] = arr[leftPos++];
	        }
	        while (rightPos <= rightEnd) { // 右边如果有剩余
	            temp[tempPos++] = arr[rightPos++];
	        }
	        // 将temp复制到arr，覆盖原来这里的位置
	        for (int i = 0; i < numEle; i++) {
	            arr[rightEnd] = temp[rightEnd];
	            rightEnd--;
	        }
	    }

}
