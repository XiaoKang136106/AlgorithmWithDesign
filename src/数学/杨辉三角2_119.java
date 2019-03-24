package 数学;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角2_119 {
	//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
	
	//思路:先构造杨慧三角,在返回最后一行
	 public List<Integer> getRow(int rowIndex) {
		 int[][] arr= new int[rowIndex+1][rowIndex+1];
		 List<List<Integer>> ret = new ArrayList<List<Integer>>();
		 for (int i = 0; i <=rowIndex; i++) {
			 List<Integer> tem = new ArrayList<Integer>();
			 for (int j = 0; j <=i; j++) {
				 //起始项为1
				 if(j==0 ||i==j) {
					 arr[i][j]=1;
					 //最后一项也为1
				 }else if(i==j) {
					 arr[i][j]=1;
				 }else {
					 arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
				 }
				 tem.add(arr[i][j]);
			}
			 ret.add(tem);
		}
		 
		 return ret.get(rowIndex);
	 }

}
