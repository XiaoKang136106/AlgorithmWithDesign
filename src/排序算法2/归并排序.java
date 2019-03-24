package 排序算法2;

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

		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		归并排序.sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int low, int high) {
		//时间复杂度:平均nlogn 最好nlogn 最差 nlogn 空间复杂度: n 稳定
		if (low < high) {
			int mid = (low + high) /2;
			// 分
			sort(arr, low, mid); // 左边归并排序
			sort(arr, mid + 1, high);// 右边归并排序
			// 左右归并(合)
			merge(arr, low, mid, high);

		}

	}

	private static void merge(int[] arr, int low, int mid, int high) {
		
		  //创建一个临时的数组,用于保存合并后的积
		   int[] temp = new int[high-low+1];	
			int i=low; //左指针 ,左边需要归并数组起始的位置		
			int j= mid+1; //右指针 ,右边数组需要归并数组起始的位置
		    int k =0; //临时的指针
		  //进行左右遍历合并
		  //把较小的值放到数组中
		   while(i <= mid &&j <= high) {
			   
			   if(arr[i] < arr[j]) {
				   temp[k++] = arr[i++];
			   }else {
				   temp[k++] = arr[j++];
			   }
		    
		   }
		  //把左边剩余的数据放入Temp中 while(i <= mid) {
		   while(i<=mid) {
			   temp[k++] = arr[i++];
		   }
		  //把右边剩余的数据放入Temp中 
		   while(j <= high)
		    {
			   temp[k++]=arr[j++];
			} 
			//把temp数值的数据重新写回arr中(每次合并后排序成有序的)
		   for (int k2 = 0; k2 < temp.length; k2++) {
				arr[k2 + low] = temp[k2];
			}
		 
		/*	int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = arr[j++];
		}

		// 把新数组中的数覆盖arr数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			arr[k2 + low] = temp[k2];
		}*/

	}

}
