package 剑指offer;

import java.util.Scanner;

public class 头条第二题{
	/*
	 * 简单模拟。去掉三连重复（aaa）的最后一个，两对（aabb）的最后一个，而且符合最后匹配，
	 * 所以直接从左开始模拟，两个bool，一个表示当前位前1，2位是否相等，另一个表示当前位的前2，3位是否相同。
	 */
	
	public static void main(String[] args) {
			solve();
	}
	 private static void solve(){
	        Scanner cin = new Scanner(System.in);
	        int N = Integer.parseInt(cin.nextLine());
	        StringBuilder sb = null;
	        for(int i=0; i<N; ++i){
	            sb = new StringBuilder();
	            String source = cin.nextLine();
	            boolean pIsDouble = false, ppIsDouble = false;
	            int n = source.length();
	            char pre = ' ';

	            for(int j=0; j<n; j++){
	                if(pIsDouble && source.charAt(j) == pre){ //三连
	                    continue;
	                }else if(!pIsDouble && ppIsDouble && source.charAt(j) == pre) {//两对
	                    continue;
	                }else{
	                    ppIsDouble = pIsDouble;
	                    if(pre == source.charAt(j)){
	                        pIsDouble = true;
	                    }else {
	                        pIsDouble = false;
	                    }
	                    pre = source.charAt(j);
	                    sb.append(source.charAt(j));
	                }
	            }
	            System.out.println(sb);
	        }
	    }
}
