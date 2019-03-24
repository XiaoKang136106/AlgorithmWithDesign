package 剑指offer;

import java.util.Arrays;

public class Test {
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
	 public static void main(String[] args) {
		 int[] multiply = multiply(new int[] {1,2,3,4,5});
		 for (int i : multiply) {
			System.out.print(i+":");
		}
	}

}
