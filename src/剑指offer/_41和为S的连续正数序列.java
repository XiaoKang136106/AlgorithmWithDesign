package 剑指offer;

import java.util.ArrayList;

public class _41和为S的连续正数序列 {
	/*
	 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
	 */
	// 9~16 =100     18~22=100
	// 思路:定义两个指针，分别递增，寻找和为s的序列
	//思路:定义1个list用于保存结果list,所以,需要定义2个list,定义2个值small,big,small一定会小于(sum+1)/2,循环,累加
    //small和big的值,累加的值等于sum就add,这里需要做清空list的操作,不等于,判断累加的值大于sum还是小于sum
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	     //定义一个返回的LIst
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> arrayList= new ArrayList<Integer>();//用于存放数据的list
			//最小为3=1+2
			if(sum<3) {
				return list;
				
			}
			int small =1;
			int big =2;
			//循环49+50 = 99 (99+1)/2
			while(small <(sum+1)/2) {
				int s=0;
				for (int i = small; i <= big; i++) {
					s+=i ;
				}
				if(s==sum) {
					for (int i = small; i <= big; i++) {
						arrayList.add(i);
					}
					//如果不创建一个新的list的话,每次都是该list
					list.add(new ArrayList<Integer>(arrayList));
					arrayList.clear();
					small++;
				}else {
					if(s <= sum) {
						big ++;
					}else {
						small++;
					}
				}
			}
			
			return	list;
	    }

}
