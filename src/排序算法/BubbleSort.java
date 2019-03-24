package 排序算法;
/**
 * 
* @ClassName: BubbleSort 
* @Description: TODO(冒泡排序) 
* @author xiaok 
* @date 2018年10月3日 下午11:09:00 
*
 */
public class BubbleSort {
	public static void main(String[] args) {
		 int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
	        System.out.println("排序之前：");
	        for (int i = 0; i < a.length; i++)
	        {
	            System.out.print(a[i] + " ");
	        }
	        //冒泡排序
	        //外层控制排序趟数
	        /*for(int i=0;i<a.length-1;i++) {
	        	//内层控制排序次数
	        	for(int j =0;j<a.length-1-i;j++) {
	        		if(a[j]>a[j+1]) {
	        			int temp = a[j+1];
	        			a[j+1]=a[j];
	        			a[j]=temp;
	        		}
	        		
	        	}
	        }*/
	        for (int i = 0; i < a.length-1; i++) {
				
	        	for (int j = 0; j < a.length-1-i; j++) {
	        		if(a[j]>a[j+1]) {
	        			int temp=a[j];
	        			a[j]=a[j+1];
	        			a[j+1]=temp;
	        		}
	        	
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
