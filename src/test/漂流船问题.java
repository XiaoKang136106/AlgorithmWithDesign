package test;

import java.util.Arrays;
import java.util.Scanner;

public class 漂流船问题 {
	/**
	 * 公司组织团建活动，到某漂流圣地漂流，现有如下情况：
	   员工各自体重不一，第 i 个人的体重为 people[i]，每艘漂流船可以承载的最大重量为 limit。
	   每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
	   为节省开支，麻烦帮忙计算出载到每一个人所需的最小船只数(保证每个人都能被船载)
	 */
	
	    public static void  main(String[] args) {
	    	
	    	Scanner sc = new Scanner(System.in);
	    	String str = sc.nextLine().trim();//获取员工的体重
	    	int limit = sc.nextInt();
	    	String[] ss =str.split(" ");
	    	int[] arr = new int[ss.length];
	    	for(int i=0;i<ss.length;i++){
	            arr[i] = Integer.valueOf(ss[i]);
	        }
	    	int n=0;
	    	Arrays.sort(arr);
	    	for(int i=arr.length-1;i>=0;i--) {
	    		if(arr[i]!=0 &&arr[i]<=limit) {
	    			for(int j=i-1;j>=0;j--) {
	    				if(arr[j]+arr[i]<=limit) {
	    					arr[j]=0;
	    					break;
	    				}
	    			}
	    			arr[i]=0;
	    			n++;
	    		}
	    	}
	    	
	    	System.out.println(n);
	    	
	    }

}
