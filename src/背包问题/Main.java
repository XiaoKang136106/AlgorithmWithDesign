package 背包问题;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int[] arr=new int[m];
			for (int j = 0; j < arr.length; j++) {
					arr[j]=sc.nextInt();
			}
				int[] ret = new int[arr.length];
		        Arrays.fill(ret,1);
		        //从前往后
		        for(int j=1;j<arr.length;j++){
		            if(arr[j]>arr[j-1] &&ret[j]<=ret[j-1] ){
		                ret[j]=ret[j-1]+1;
		            }
		        }
		        //从后往前
		        for (int j =ret.length-2; j >=0 ; j--) {
		        	if(arr[j]>arr[j+1] &&ret[j]<=ret[j+1] ){
		                ret[j]=ret[j+1]+1;
		            }
					
				}
		        int count=0;
		        for(int num:ret){
		            count+=num;
		        }
		        
		        list.add(count);
		}
		for(int count :list) {
			System.out.println(count);
		}
       
	}

}
