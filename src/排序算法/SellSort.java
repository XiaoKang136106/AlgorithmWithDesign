package 排序算法;
/**
 * 
* @ClassName: SellSort 
* @Description: TODO(插入排序:希尔排序:时间复杂度平均O(n1.3),最坏O(n2),最好O(n),空间复杂度0(1),不稳定) 
* 思路::希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
*
* 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，取第二个增量d2
* @author xiaok 
* @date 2018年10月3日 下午9:22:55 
*
 */
public class SellSort {
	public static void main(String[] args) {
		   int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
	        System.out.println("排序之前：");
	        for (int i = 0; i < a.length; i++)
	        {
	            System.out.print(a[i] + " ");
	        }
	        //思路:先使用步长大致的排一次,等步长为1全部排一次
	        //希尔排序
	        int d = a.length;
	        while (true)
	        {
	            d = d / 2; //步长
	            for (int x = 0; x < d; x++)
	            {
	                //直接插入排序
	            	for (int i = x + d; i < a.length; i = i + d)
	                {
	                    int temp = a[i];
	                    int j;
	                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d)
	                    {
	                        a[j + d] = a[j];
	                    }
	                    a[j + d] = temp;
	                }
	            }
	            //循环退出条件
	            if (d == 1)
	            {
	                break;
	            }
	        }
	        
	        System.out.println();
	        System.out.println("排序之后：");
	        for (int i = 0; i < a.length; i++)
	        {
	            System.out.print(a[i] + " ");
	        }





	}

}
