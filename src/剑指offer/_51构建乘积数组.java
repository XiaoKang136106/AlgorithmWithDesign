package 剑指offer;

import java.util.Arrays;

public class _51构建乘积数组 {
	
	
	/*
	 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
	 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法(除了A[I]别的都包含)。
	 */
	
	/*
	借助两个数组lefts和rights，一个记录B[i]值的左乘结果A[0]*A[1]*...*A[i-1]，
	一个记录B[i]值的右乘结果A[i+1]*A[i+2]*...*A[n-1]，然后B[i]=lefts[i]*rights[i];
 */

	 public static int[] multiply(int[] A) {
	      int n=A.length;
	        int[] B = new int[n];
	        Arrays.fill(B,1);
	        int left=1;
	        for(int i=1;i<n;i++){
	            left*=A[i-1];
	            B[i]*=left;
	        }
	        int right=1;
	        for(int i=n-2;i>=0;i--){
	            right *=A[i+1];
	            B[i] *=right;
	        }
	        return B;
	    }	

}
