package 排序算法;

import java.util.Arrays;

/**
 * 最坏情况下每一个节点需比較log2(n)次。因此其最坏情况下时间复杂度为nlog2(n)。堆排序为不稳定排序，不适合记录较少的排序。
* @ClassName: HeapSort 
* @Description: TODO(堆排序:) 
* (右子节点-1)/2 获取父节点
* (父节点*2)+1 左子节点 (父节点*2)+2 右子节点
* a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;

　　b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;

　　c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
* 思路:初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。
* 	然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。
* 	依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
*	 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。
*          一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数
* @author xiaok 
* @date 2018年10月3日 下午11:01:12 
*
 */
public class MaxHeapSort {

	 public static void main(String[] args)
	    {
	        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64 };
	        int arrayLength = a.length;
	        // 循环建堆
	        for (int i = 0; i < arrayLength - 1; i++)
	        {
	            // 建堆(为每次循环的最后一个元素建立)
	            buildMaxHeap(a, arrayLength - 1 - i);
	            // 交换堆顶和最后一个元素
	            swap(a, 0, arrayLength - 1 - i);
	            System.out.println(Arrays.toString(a));
	        }
	    }

	    // 对data数组从0到lastIndex建大顶堆
	    public static void buildMaxHeap(int[] data, int lastIndex)
	    {
	      /*  // 从lastIndex处节点（最后一个节点）的父节点开始
	        for (int i = (lastIndex - 1) / 2; i >= 0; i--)
	        {
	            // k保存正在判断的节点
	            int k = i;
	            // 如果当前k节点的子节点存在
	            while (k * 2 + 1 <= lastIndex)
	            {
	                // k节点的左子节点的索引
	                int biggerIndex = 2 * k + 1;
	                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
	                if (biggerIndex < lastIndex)
	                {
	                    // 如果右子节点的值较大
	                    if (data[biggerIndex] < data[biggerIndex + 1])
	                    {
	                        // biggerIndex总是记录较大子节点的索引
	                        biggerIndex++;
	                    }
	                }
	                // 如果k节点的值小于其较大的子节点的值
	                if (data[k] < data[biggerIndex])
	                {
	                    // 交换他们数据交换(k中为大值,biggerIndex为小值)
	                    swap(data, k, biggerIndex);
	                    // 索引交换,将biggerIndex赋予k(k的值和索引都在最大的子节点的位置)，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
	                    k = biggerIndex;
	                }
	                else
	                {
	                    break;
	                }
	            }
	        }*/
	    	//从最后一个节点的父节点开始
	    	for(int i=(lastIndex-1)/2;i>=0;i--) {
	    		//正在判断的节点
	    		int k =i;
	    		//判断当前的子节点是否存在
	    		while(2*k+1 <= lastIndex) {
	    			
	    			//存在,获取子节点的最大值
	    			int biggerIndex = 2*k+1;
	    			
	    			if(biggerIndex < lastIndex) {
	    				if(data[biggerIndex]<data[biggerIndex+1]) {
		    				biggerIndex++;
		    			}
	    			}
	    			//如果K的值小于子节点,进行交换二个的值,在将k指向最大值的子节点,
		    		if(data[k]<data[biggerIndex]) {
		    			swap(data, k, biggerIndex);
		    			k=biggerIndex;
		    		}else {
		    			break;
		    		}
	    			
	    		}
	    		
	    		
	    	}
	    }

	    // 交换
	    private static void swap(int[] data, int i, int j)
	    {
	        int tmp = data[i];
	        data[i] = data[j];
	        data[j] = tmp;
	    }
	}

