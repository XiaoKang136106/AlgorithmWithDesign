package 剑指offer;

import java.util.Arrays;

public class _37数字在排序数组中出现的次数 {
	
	/*
	 * 统计一个数字在排序数组中出现的次数
	 */
	//思路:利用二分查找+递归思想，进行寻找。当目标值与中间值相等时进行判断,因为为排序数组找到数字后,判断左右相邻的数字是否还为该数字
	 public int GetNumberOfK(int [] array , int k) {

		 int mid = array.length >>1;
		 //初始化判断
		 if(array == null || array.length == 0) {
			 return 0;
		 }else if(array.length == 1) {
			 
			 if(array[0] == k) {
				 return 1;
			 }else {
				 return 0;
			 }
		 }
		 
		 int result =0;
		 //二分查找
		 if(k < array[mid]) {
			 result += GetNumberOfK(Arrays.copyOfRange(array, 0, mid), k);
		 }else if (k > array[mid]) {
			result += GetNumberOfK(Arrays.copyOfRange(array, mid+1, array.length), k);
		 }else {
			 //找到的数字遍历后面
			 for(int i = mid;i<array.length;i++) {
				 if(array[i] ==k){
					 result++;
				 }else {
					 break;
				 }
			 }
			 //找到的数字遍历前面
			 for(int i =mid-1;i>=0;i--) {
				 if(array[i] ==k){
					 result++;
				 }else {
					 break;
				 }
			 }
		 }
		 return result;
	 }

}
