package 剑指offer;

import java.util.ArrayList;
import java.util.TreeSet;

/*
 *  输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 *  则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
	输入描述:
	输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
 * 
 */
public class _27字符串的排列 {

	// 思路：将当前位置的字符和前一个字符位置交换，递归。
/*	public ArrayList<String> Permutation(String str) {

		ArrayList<String> result = new ArrayList<String>();
		if (str == null || str.length() == 0)
			return result;
		//将字符串转换成字符
		char[] chars = str.toCharArray();
		//封装每一种顺序的字符串
		TreeSet<String> temp = new TreeSet<>();
		//将chars中排好序放入到Temp中
		Permutation(chars, 0, temp);
		result.addAll(temp);
		return result;
	}

	public void Permutation(char[] chars, int index, TreeSet<String> result) {
		if (chars == null || chars.length == 0)
			return;
		if (index < 0 || index > chars.length - 1)
			return;
		//遍历到尾部,添加结果
		if (index == chars.length - 1) {
			result.add(String.valueOf(chars));
		} else {
			for (int i = index; i <= chars.length - 1; i++) {
				swap(chars, index, i);
				Permutation(chars, index + 1, result);
				// 回退(递归调用swap交换前后两个字符，在最后交换完成入List之后再交换回来，回到初始状态再进下一个循环)
				swap(chars, index, i);
			}
		}
	}

	public void swap(char[] c, int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}*/
	
		// 思路：将当前位置的字符和前一个字符位置交换，递归。
	/*
	 * 思路:使用回溯法来求解,将每种情况放入TreeSet中,最后调用ArrayList的addAll()将每种情况的字符串放入,进行查找
     * 终止条件chars为null或者为0,index<0或者大于char的长度,当index==chars.length-1,添加到TreeSet中
     * 否则交换index与i位置的值,在递归查找下一个(index+1),最后回溯(在重新swap一次)
     * 交换退回一步
	 */
		public ArrayList<String> Permutation(String str) {
			//1.创建一个数组
			ArrayList<String> result = new ArrayList<String>();
			if(str ==null || str.length() == 0) {
				return result;
			}
			//将字符串转换后才能数组
			char[] chars = str.toCharArray();
			//创建一个临时的集合
			TreeSet<String> temp = new TreeSet<String>();
			//进行排序,排序后的各种不同的结果放入到temp中
			Permutation(chars,0,temp);
			result.addAll(temp);
			
			return result;
		}

		public void Permutation(char[] chars, int index, TreeSet<String> result) {
			if(chars == null ||chars.length==0 ) {
				return;
			}
			if(index<0 || index > chars.length-1) {
				return;
			}
			//遍历到尾部,添加结构
			if(index == chars.length-1) {
				result.add(String.valueOf(chars));
			}
			//开始遍历
			for(int i=index ; i< chars.length ;i++) {
				
				//交换
				swap(chars, index, i);
				//将递归下一层
				Permutation(chars, index+1, result);
				//交换回退
				swap(chars, index, i);
			}
		
		}

		public void swap(char[] c, int a, int b) {
			char temp =c[a];
			c[a]=c[b];
			c[b]= temp;
		}

}
