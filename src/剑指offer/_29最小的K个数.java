package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class _29最小的K个数 {
	/*
	 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
	 * 则最小的4个数字是1,2,3,4
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
		//使用红黑树在进行排序,nlogn
        ArrayList<Integer>arrayList=new ArrayList<>();
        if(input==null || input.length==0 ||k==0 ||k>input.length)return arrayList;

        TreeSet<Integer> treeSet=new TreeSet<>();


        for(int i=0;i<input.length;i++){
        	//前n项小于k,直接添加到treeSet中
            if(treeSet.size()<k){
                treeSet.add(input[i]);
            }
            //超过了k后,如果小于树中最大的值,取出最大值,在添加
            else {

                if(input[i]<treeSet.last()){
                    treeSet.pollLast();
                    treeSet.add(input[i]);
                }
            }
        }

        for(Integer x:treeSet){
        arrayList.add(x);

        }
        return arrayList;

    }
	
	

	// 思路:先将前K个数放入数组，进行堆排序，若之后的数比它还小，则进行调整
/*	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

		ArrayList<Integer> list = new ArrayList<>();
		if (input == null || k <= 0 || k > input.length) {
			return list;
		}
		//将前k的数放入数组
		int[] kArray = Arrays.copyOfRange(input, 0, k);
		// 创建大根堆
		buildHeap(kArray);
		//从k开始
		for (int i = k; i < input.length; i++) {
			//如果后面有比大根堆还小的数值话,继续构建大根堆,然后在遍历
			//4,3,2,1
			if (input[i] < kArray[0]) {
				kArray[0] = input[i];
				maxHeap(kArray, 0);
			}
		}
		//kArray={1,2,3,4}
		for (int i = kArray.length - 1; i >= 0; i--) {
			list.add(kArray[i]);
		}
		return list;
	}

	public void buildHeap(int[] input) {
		//根节点的位置
		for (int i = input.length / 2 - 1; i >= 0; i--) {
			maxHeap(input, i); //构建大根堆
		}
	}

	private void maxHeap(int[] array, int i) {
		int left = 2 * i + 1;
		int right = left + 1;
		int largest = 0;
		if (left < array.length && array[left] > array[i])
			largest = left;  //左边的数值为最大
		else
			largest = i; 	//根的数值为最大
		
		if (right < array.length && array[right] > array[largest])
			largest = right; //右边的数值为最大
		//最大数不为根
		if (largest != i) {
			//交换位置
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			//交换位置后继续进行递归找最大堆,递归的作用:每次都将双亲节点作为参数,带入,双亲节点一点点大于左右子节点从而构建大根堆
			maxHeap(array, largest);
		}
	}*/
	/*
	 * 思路:使用大根堆来求解(第一个数最大),先创建一个为k大根堆,从k开始遍历,和大根堆的根进行比较,如果小于的话,大根堆的索引0为当前值,在重新构建大根堆
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
	
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(input == null || k<=0 || k > input.length) {
			return result;
		}
		 int[] kArrays = Arrays.copyOfRange(input, 0, k);
		buildHeap(kArrays);//创建大根堆
		for(int i=k;i<input.length;i++) {
			if(input[i]<kArrays[0]) {
				kArrays[0]=input[i];
				maxHeap(kArrays, 0);
			}
		}
		for(int i=kArrays.length-1;i>=0;i--) {
			result.add(kArrays[i]);
		}
		return result;

	}
	public void buildHeap(int[] input) {
		//只需要获取一半就可以构建成功,从后面开始向前构建
		for(int i=input.length / 2 - 1;i>=0;i--) {
			maxHeap(input, i);
		}
	}

	private void maxHeap(int[] array, int i) {
		int left =	2*i+1;//左子节点
		int right = 2*i+2;//右子节点
		int largest = 0;
		if(left<array.length && array[left] > array[i]) {
			largest = left;
		}else {
			largest = i;
		}
		if(right<array.length && array[right] >array[i]) {
			largest = right;
		}
		
		if(largest != i) {
			//交换
			int temp =array[i];
			array[i] =array[largest];
			array[largest] = temp;
			maxHeap(array, largest);
		}
		
	}
	
		//冒泡排序	
		/*public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		        ArrayList<Integer> al = new ArrayList<Integer>();
		        if (k > input.length) {
		            return al;
		        }
		        for (int i = 0; i < k; i++) {
		            for (int j = 0; j < input.length - i - 1; j++) {
		                if (input[j] < input[j + 1]) {
		                    int temp = input[j];
		                    input[j] = input[j + 1];
		                    input[j + 1] = temp;
		                }
		            }
		            al.add(input[input.length - i - 1]);
		        }
		        return al;
		    }
	*/
}
