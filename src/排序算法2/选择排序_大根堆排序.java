package 排序算法2;

import java.util.Arrays;

import 排序算法.MergeSort;

public class 选择排序_大根堆排序 {
	
	public static void main(String[] args) {

		int[] arr = { 9,6,8,7,0,1,10,4,2 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

/*
　　空间复杂度:o(1)；

　　时间复杂度:建堆：o(n)，每次调整o(log2n)，故最好、最坏、平均情况下：o(n*log2n);

　　稳定性：不稳定
	 */
	public static void sort(int[] a) {
		//时间复杂度:平均nlogn 最好nlogn 最差 nlogn 空间复杂度: 1 稳定
		//开始位置是最后第一个非叶子节点的父节点(log2n)
		int start = (a.length-1)/2;
		for (int i = start; i >=0; i--) {
			maxHeap(a,a.length,i);
		}
		//最大的数字在后面,进行交换(n)
		for (int i = a.length-1; i >0; i--) {
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			maxHeap(a, i, 0);
		}
		
		
	}
	
	
	//size需要构造大根堆的个数,index第一个非叶子节点的父节点,(此方法只是构造大根堆,顺序为大根堆的顺序)
	private static void maxHeap(int[] a,int size,int index) {
		//左子节点
		int leftNode = 2*index+1;
		//右子节点	
		int rightNode = 2*index+2;
		
		int max =index;
		//和两个节点对比,找出最大的节点
		if(leftNode<size && a[leftNode] >a[max]) {
			max =leftNode;
		}
		if(rightNode<size && a[rightNode] >a[max]) {
			max =rightNode;
		}
		//交换位置
		if(max != index) {
			int temp=a[index];
			a[index]=a[max];
			a[max]=temp;
			//不为max,需要重新调整
			maxHeap(a, size, max);
		}
		
	}
	

}
