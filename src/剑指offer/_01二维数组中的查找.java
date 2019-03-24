package 剑指offer;

public class _01二维数组中的查找 {
	/*
	 * 二维数组中的查找
	 * 在一个二维数组中（每个一维数组的长度相同），
	 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 */
	public boolean Find(int target, int [][] array) {
		if(array ==null||array.length==0) {
				return false;
			}
			int row =0;
			int column = array[0].length-1;
			//从右上角开始遍历
			while(row<array.length && column >=0) {
				
				if(array[row][column] ==target) {
					return true;
				}
				//开始查找,当前位置的数字大于target,column--
				if(array[row][column]>target) {
					column --;
				}else {
					//否则,直接进入下一行
					row++;
				}
			}
			return false;
	}


}
