package 贪心算法;

import java.util.Arrays;

public class 投飞镖刺破气球_452 {
	 public int findMinArrowShots(int[][] points) {
	        if(points == null || points.length < 1) return 0;
	        //根据x轴来进行排序
	        Arrays.sort(points, (a, b)->(a[0]-b[0]));
	        //射出去的箭,至少为会命中1个气球
	        int result = 1;
	        //重合点,假设(0,1为重合点)
	        int end = points[0][1];
	        //遍历气球有多少行
	        for(int i = 1; i < points.length; i ++) {
	            //结束的位置大于重合点,表示不能为最大射出时间
	        	if(points[i][0] > end) {
	                result ++;
	                end = points[i][1];//将结束的位置赋给飞镖
	            } else {
	                end = Math.min(end, points[i][1]);//将位置最小的值给飞镖
	            }
	        }
	        return result;
		 
	    }

}
