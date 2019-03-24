package 剑指offer;

/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class _13调整数组顺序使奇数位于偶数前面 {
	
	//利用辅助数组,先遍历一边数组,求出奇数的个数,此位置后面的都是偶数
	//遍历数组,奇数从0开始,偶数从oddcount开始存入复制数组,最后,在复制给该数组
	 public void reOrderArray2(int [] array) {
	        if(array.length==0||array.length==1) return;
	        int oddCount=0,oddBegin=0;
	        int[] newArray=new int[array.length];
	        for(int i=0;i<array.length;i++){
	            if((array[i]&1)==1) oddCount++;//奇数的个数
	        }
	        for(int i=0;i<array.length;i++){
	            if((array[i]&1)==1) newArray[oddBegin++]=array[i];
	            //从oddCount后面都是偶数
	            else newArray[oddCount++]=array[i];
	        }
	        for(int i=0;i<array.length;i++){
	            array[i]=newArray[i];
	        }
	    }

	// 思路:每次只和前面一个数交换位置。
	public void reOrderArray(int[] array) {
/*			if (array == null)
			return;
		//从1开始,遍历
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1; //前1个索引
			//奇数
			if (array[i] % 2 != 0) {
				while (j >= 0) {
					//前一个也为奇数,退出当前的循环
					if (array[j] % 2 != 0) {
						break;
					}
				//10	12 15
					//前一个为偶数,交换
					if (array[j] % 2 == 0) {
						int t = array[j + 1];
						array[j + 1] = array[j];
						array[j] = t;
						j--;
					}
				}
			}
			array[j + 1] = temp;
		}*/
		
		//思路前一个数字进行交换,直到无法交换为止
	       //思路:根据%2==0来判断为偶数还是奇数,从1开始,如果为奇数并且在偶数后面就交换,
        //先遍历的时候,先获取当前位置的值,以及上一个索引的值(j),判断当前的值是否为奇数,true->循环j>0一直向前寻找是否为偶数,
        //只有当前面的值为奇数时,就退出,退后将交换的值赋给当前的值
		//最终将当前位置的值(temp)放到j+1上,完成一次遍历.
		if (array == null)
			return;
		//从1开始遍历
		for(int i=1;i<array.length;i++) {
			//获取当前位置的数
			int temp = array[i];
			//获取前一个数的索引
			int j=i-1;
			//判断当前的位置是奇数还是偶数,只有为奇数才需要交换
			if(array[i]%2 != 0 ) {
				//遍历前面位置的数字
				while(j >= 0) {
					//前一个也为奇数,退出当前的循环	
					if(array[j]%2 !=0) {
						break;
					}
					//前一个为偶数
					if(array[j]%2 ==0) {
						//进行交换(注意不能使用i)
						int t = array[j+1];
						array[j+1] = array[j];
						 array[j]=t;
						 j--; //继续循环判断前面是否还有偶数没有
					}
					
				}
			}
			array[j+1] =temp;//由于每次都j--,所以,需要加1,理解(最终把array[j]和temp的位置进行交换)
		}
	}
	


}
