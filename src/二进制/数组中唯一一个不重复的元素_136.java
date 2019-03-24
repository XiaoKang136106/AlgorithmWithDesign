package 二进制;

public class 数组中唯一一个不重复的元素_136 {
	//两个相同的数异或的结果为 0，对所有数进行异或操作，最后的结果就是单独出现的那个数。
	 public int singleNumber(int[] nums) {
		 
		 int ret =0;
		 for (int i : nums) {
			ret = ret^i;
		}
		 return ret;
	  }
}
