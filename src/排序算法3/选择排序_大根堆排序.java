package 排序算法3;

import java.util.Arrays;
import java.util.PriorityQueue;

import 排序算法.MergeSort;

public class 选择排序_大根堆排序 {
	
	public static void main(String[] args) {

		int[] arr = { 9,6,8,7,0,1,10,4,2 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) -> a-b);
		queue.offer(2);
		queue.offer(2);
		queue.offer(3);
		queue.offer(5);
		queue.offer(9);
		queue.offer(7);
		queue.offer(1);
		for (Integer i : queue) {
			System.out.print(i+" ");
		}
	}


	public static void sort(int[] a) {
		//最好nlog2n 平均nlog2n 最差nlog2n 空间O1 不稳定
		//建堆
		int start =(a.length-1)/2;
		for(int i=start;i>=0;i--) {
			maxHeap(a, a.length, i);
		}
		//排序
		for (int i = a.length-1; i >0; i--) {
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			maxHeap(a, i, 0);
		}
		
	}
	
	
	//size大根堆的长度,index第一个非叶子节点的父节点,(此方法只是构造大根堆,顺序为大根堆的顺序)
	private static void maxHeap(int[] a,int size,int index) {
		int left =2*index+1;
		int right =2*index+2;
		int max =index;
		if(left<size && a[left]>a[max]) {
			max=left;
		}
		if(right<size && a[right]>a[max]) {
			max=right;
		}
		if(max!=index) {
			int temp=a[index];
			a[index]=a[max];
			a[max]=temp;
			maxHeap(a, size, max);
	}
	}
		
		

}
