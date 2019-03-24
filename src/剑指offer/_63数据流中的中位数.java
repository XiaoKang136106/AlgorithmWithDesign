package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class _63数据流中的中位数 {

	/*
	 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
	 * 那么中位数就是所有数值排序之后位于中间的数值。
	 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
	 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
	 */
	/*
	 * 思路：创建优先级队列维护大顶堆和小顶堆两个堆，并且小顶堆的值都大于大顶堆的值，2个堆个数的差值小
	 * 于等于1，所以当插入第奇数个时：大顶堆个数就比小顶堆多1，中位数就是大顶堆堆头；当插入第偶数 个时，使大顶堆个数跟小顶堆个数一样，中位数就是
	 * 2个堆堆头平均数。也可使用集合类的排序方法
	 */
	//大根堆维护左边数组,小根堆维护右边数组
	private PriorityQueue<Integer> left =  new PriorityQueue<Integer>((o1,o2) -> o2-o1 );
	private PriorityQueue<Integer> right =  new PriorityQueue<Integer>();
	private int N=0;
	public void Insert(Integer num) {
		//偶数
		if(N%2==0) {
			left.add(num);
			right.add(left.poll());
		}else {
			right.offer(num);
			left.offer(right.poll());
		}
		N++;
	}
	
	 public Double GetMedian() {
		 if((N&1)==0) {
			 return (left.peek()+right.peek())/2.0;
		 }else {
			 return (double)right.peek();
		 }
		 
	 }

    /*private ArrayList<Integer> list = new ArrayList<Integer>();
    public void Insert(Integer num) {
    	list.add(num);
        Collections.sort(list);
    }

    public Double GetMedian() {
    
        if((list.size()&1)==0){
            int l =list.get(list.size()/2);
            int r = list.get(list.size()/2-1);
            return (l+r) / 2.0;
        }else{
            return list.get(list.size()/2)/1.0;
        }
        
    }*/
	
	/*int count = 0; // 标志位
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // 小根堆
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(16, new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// 降序
			return o2.compareTo(o1);
		}
	}); // 大根堆

	public void Insert(Integer num) {
		count++;
		// 如果为第奇数个,进入大根堆
		if ((count & 1) == 1) {
			minHeap.offer(num);
			// 每次获取小根堆最大的数
			maxHeap.offer(minHeap.poll());
		} else {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		}

	}

	public Double GetMedian() {
		if (count == 0) {
			return null;

		}
		// 奇数,为大根堆的头
		if ((count & 1) == 1) {
			return Double.valueOf(maxHeap.peek());
		} else {
			return Double.valueOf(maxHeap.peek() + minHeap.peek()) / 2; // 二个堆的头之和在/2
		}

	}
*/
}
