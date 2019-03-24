package 剑指offer;

/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class _28数组中出现次数超过一半的数字 {

	/*
	 * 思路：将首次出现的数count+1，与之后的数进行比较，相等则+1，否则—1，超过长度一半的话count>=1
	 * 		最后进行校验是否超过长度的一半,防止最后一个数为1的情况比如,一个数组中每个数字都不相同
	 */
	//令第一个数为最大的值,设置count=1,从索引为1遍历,如果不相等,先判断count是否为0,如果为0,
	//将当前的值设置为最大值,重置count,否则就count--;遍历时,判断count是否>=1,如果>=1说明已经为新的maxNumber了
	//之后再验证MaxNubmer的出现的次数*2是否大于array.length
	/*public int MoreThanHalfNum_Solution(int[] array) {

		int maxNumber = array[0];	
		int number = array[0]; //从第一个数字开始,判断
		int count = 1;//初始化出现的次数
		//从第二个数字开始
		for (int i = 1; i < array.length; i++) {
			//判断该遍历的数字是否等于遍历的数字
			if (number != array[i]) {
				//出现的次数等于0的话
				if (count == 0) {
					//将当前的遍历的数字赋给number;
					number = array[i];
					//初始化出现的次数
					count = 1;
				} else {
					count--;
				}
			} else {
				count++;
			}
			if (count >= 1) {
				//出现的次数最大的那个数
				maxNumber = number;
			}
		}
		// 验证
		int num = 0;
		for (int j = 0; j < array.length; j++) {
			if (array[j] == maxNumber) {
				num++;
			}
		}
		if (num * 2 > array.length) {
			return maxNumber;
		}
		return 0;
	}*/
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array == null || array.length ==0) {
			return 0;
		}
		int maxNumber =array[0];
		int number = array[0];
		int count = 1;
		
		for(int i=1;i<array.length;i++) {
			//相等
			if(number == array[i]) {
				count++;
			}else {
				//不相等
				if(count == 0) {
					number=array[i];
					count =1;
				}else {
					count --;
				}
			}
		}
		
		//校验
		if(count >= 1) {
			maxNumber = number;
		}
		int num =0;
		for(int i=0;i<array.length ; i++) {
			if(maxNumber == array[i]) {
				num++;
			}
		}
		if(num*2>array.length) {
			return maxNumber;
		}
		return 0;
		
	}
}
