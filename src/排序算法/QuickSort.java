package 排序算法;
/**
 * 
* @ClassName: QuickSort 
* @Description: TODO(选择排序:快速排序)
* 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
* 	    将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。 
* 步骤:确定基准元素,左右各有一个指针,如果右指针的数值比基准元素大,进行向前移动,右指针的数值比基准元素小,则进行位置交换,切换到左指针,令左指针的元素和基准元素进行相同的方法比较,
* 	,在缩小基准元素的范围,这样就可以排好序了
* @author xiaok 
* @date 2018年10月4日 下午2:17:31 
*
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
	    System.out.println("排序之前：");
	    for (int i = 0; i < a.length; i++)
	    {
	        System.out.print(a[i] + " ");
	    }
	    // 快速排序
	    if (a.length > 0)
        {
            quickSort(a, 0, a.length - 1);
        }
	    System.out.println();
	    System.out.println("排序之后：");
	    for (int i = 0; i < a.length; i++)
	    {
	        System.out.print(a[i] + " ");
	    }
	}

	  /*  private static void quickSort(int[] a, int low, int high)
	    {
	        if (low < high)
	        { // 如果不加这个判断递归会无法退出导致堆栈溢出异常
	            int middle = getMiddle(a, low, high);//将基准元素放到中间.小于基准元素的值在左边,大于基准元素的值在右边
	            quickSort(a, 0, middle - 1);//基准元素左边进行快排
	            quickSort(a, middle + 1, high);//基准元素右边进行快排
	        }
	    }

	    private static int getMiddle(int[] a, int low, int high)
	    {
	        int temp = a[low];// temp为基准元素,保存基准元素,用于最后赋值给橡胶的中间元素
	        while (low < high)
	        {
	            // 找到比基准元素小的元素位置
	        	//从右指针开始向左寻找比基准元素小的值
	            while (low < high && a[high] >= temp)
	            {
	                high--;
	            }
	            a[low] = a[high];//右边比基准元素小的值放到基准元素的位置(和基准元素进行交换)
	            //左指针开始向右寻找比基准元素小的值
	            while (low < high && a[low] <= temp)
	            {
	                low++;
	            }
	            a[high] = a[low];//左边比基准元素大的值放到右边放到了基准元素的位置
	        }
	        //左右俩指针到了中间的位置
	        a[low] = temp;
	        return low;
	    }*/
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
				while(low<high & a[low] <=temp ) {
					low++;
				}
				a[high] = a[low];
			}
			a[low] = temp;
			return low;	
	    }
	}

