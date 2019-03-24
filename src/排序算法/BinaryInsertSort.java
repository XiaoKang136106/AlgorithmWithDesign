package 排序算法;
/**
 * 
* @ClassName: BinaryInsertSort 
* @Description: TODO(插入排序:二分插入) 
* 	思路:二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，
* 	可以减少比较的次数
*  * 根据排序原则，每次我们都是在一个有序序列中插入一个新的数字
*   * 那么我们可以将这个有序序列进行二分。
*  * 左游标left为0，右游标right为i-1(i是这个数字在原数组中的位置)  middle初始为0。
*   * 当left<=right时 , middle是left和right的中值。 我们作如下操作。如果array[i]的值比array[middle]值大。
*    * 那么我们就移动左游标令值为middle+1 ,否则就移动右游标为middle-1
*     * 移动完成后,我们需要将i-1到left之间的值进行依次向后移动给array[i]空出一个位置然后将array[i]插入
* @author xiaok 
* @date 2018年10月3日 下午8:44:08 
*
 */
public class BinaryInsertSort {
    public static void main(String[] args)
    {
        int[] a = { 49, 38, 65, 97, 176, 1000,213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        // 二分插入排序
        binartInsertSort2(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }

	private static void binartInsertSort(int[] a) {
		//for(int i=0;i<a.length;i++) //原代码
		for(int i=1;i<a.length;i++) 
        {
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
        	while(left <=right) {
				mid = (left+right)/2;
				if(temp<a[mid]) {
					right =mid-1; //插入点在低半区
				}else {
					left = mid+1; //插入点在高半区
				}
			}
            for (int j = i - 1; j >= left; j--)
            {
                a[j + 1] = a[j]; //记录后移
            }
            if (left != i)
            {
                a[left] = temp; //插入
            }


		}
		

		
		
	}
	
	private static void binartInsertSort2(int[] a) {
		
		for (int i = 1; i < a.length; i++) {
		 int temp = a[i];
		 int left = 0;
		 int right =i-1;
		 int mid=0;
		 while(left<=right) {
			 mid=(left+right)/2;
			 if(temp<a[mid]) {
				 right =mid-1;
			 }else {
				 left =mid+1;
			 }
		 }
		 for (int j = i-1; j>=left; j--) {
			a[j+1]=a[j];
		}
		 if (left != i)
         {
             a[left] = temp; //插入
         }
		
	
	}

	}
}
