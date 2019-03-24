package 排序算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @ClassName: BaseSort
 * @Description: TODO(基数排序/桶排序) 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 *               然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 *               先将各各数值的低位开始进行一次排序,在慢慢往高位逐渐地进行排序
 * @author xiaok
 * @date 2018年10月4日 下午6:02:55
 *
 */
public class RadixSort {
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 基数排序
		sort(a);
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" " );
		
		System.out.println( 500 % (int) Math.pow(10, 3) / (int) Math.pow(10, 2));
	}

	private static void sort(int[] array) {
		/*// 找到最大数，确定要排序几趟
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		// 判断位数
		int times = 0;
		while (max > 0) {
			max = max / 10;
			times++;
		}
		// 建立十个队列(其实就是一个二维数组,数组加桶结构的)
		//queue({0,0,...,0}<桶>,{1},{2},{3}....,{9})queue中包含10个数组
		List<ArrayList> queue = new ArrayList<ArrayList>();
		//使用Queue1保存0~9
		for (int i = 0; i < 10; i++) {
			ArrayList queue1 = new ArrayList();
			queue.add(queue1);
		}
		// 进行times次分配和收集
		for (int i = 0; i < times; i++) {
			// 分配(也就是排序)
			//遍历数组
			for (int j = 0; j < array.length; j++) {
				//Math.pow(10, i + 1) 表示10^(i+1)次方 此收集该位置的数值  5 结果5 50 结果为5 500结果为5
				int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList queue2 = queue.get(x); //假设x=5
				queue2.add(array[j]); //收集相同位置的数值  
				queue.set(x, queue2); 	//将假设的索引为5的位置添加数组为5,如果有重复的也可以添加进来

			}
			// 收集
			int count = 0;
			for (int j = 0; j < 10; j++) {
				//判断queue1中是否有重复的元素,在相同的位数上是否有重复的元素
				while (queue.get(j).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(j);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}*/
		//找到最大值
		// 找到最大数，确定要排序几趟
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		// 判断位数
		int times = 0;
		while (max > 0) {
			max = max / 10;
			times++;
		}
		//定义数组加桶(数组的长度为10(0~9))
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for(int i=0;i<10;i++) {
			ArrayList<ArrayList> queue1 = new ArrayList<ArrayList>();
			queue.add(queue1);
		}
		//分配
		//进行遍历
		for(int i=0;i<times;i++) {
			for(int j=0;j<array.length;j++) {
				int x =array[j]%(int)Math.pow(10, i+1)/(int) Math.pow(10, i);
				
				//获取相应位置的桶
				ArrayList queue2 = queue.get(x);
				//添加到桶里面
				queue2.add(array[j]);
				queue.set(x, queue2);
			}	
		
		int count=0;
		//收集
		for(int j = 0; j < 10; j++) {
			//判断桶中是否有元素
			while(queue.get(j).size()>0) {
				//将桶中的元素添加原集合中
				ArrayList<Integer> queue3 = queue.get(j);
				array[count] = queue3.get(0);
				queue3.remove(0);
				count++;
				
			}
		}
		}
	
	}
		
}
