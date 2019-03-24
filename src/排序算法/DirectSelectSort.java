package 排序算法;
/**
 * 
* @ClassName: DirectSelectSort 
* @Description: TODO(选择排序:直接选择排序,每趟从待排序的记录序列中选择关键字最小的记录放置到已排序表的最前位置，直到全部排完。 )
*  基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
* @author xiaok 
* @date 2018年10月3日 下午10:19:24 
*
 */
public class DirectSelectSort {
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        //直接选择排序
        for(int i=0;i<a.length;i++) {
        	int min =a[i];//假设第一个数为最小值
        	int n=i; //最小值的索引
        	for(int j =i+1;j<a.length;j++) {
        		//向后找出最小值
        		if(a[j]<min) {
        			//交换
        			min=a[j];
        			n=j;
        		}
        		
        	}
        	//i和n上的值进行交换
        	a[n]=a[i];
        	a[i]=min;
        	
        }
        
        
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }


	}

}
