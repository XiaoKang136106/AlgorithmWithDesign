package 排序算法;
/**
 * 
* @ClassName: DirectInserSort 
* @Description: TODO(插入排序:直接插入排序,时间复杂度平均O(n2),最坏O(n2),最好O(n),空间复杂度0(1),稳定)
* 基本思路:将未排序的数组插入到需要排序的数组中,从1开始遍历数组,,如果为合适的位置就插入进去 
* @author xiaok 
* @date 2018年10月3日 下午8:21:20 
*
 */
public class DirectInserSort {
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        //直接插入排序
        for(int i=1;i<a.length;i++) {
        	
        	int temp =a[i];
        	//i元素直接和i前面的元素进行比较
        	int j;
        	for(j=i-1;j>=0;j--) {
        		//大于temp的往后移一位
        		if(a[j]>temp) {
        			a[j+1]=a[j];
        		}else {
        			//退出循坏
        			break;
        		}
        	}
        	//将数据插入a[j]的后面
        	a[j+1]=temp;
        }
        
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
        	System.out.print(a[i] + " ");
        }
	}

 }


