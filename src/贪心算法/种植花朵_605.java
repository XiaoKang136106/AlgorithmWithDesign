package 贪心算法;

public class 种植花朵_605 {
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
	    int cnt = 0;
	    for(int i = 0; i < flowerbed.length; i++){
	        if(flowerbed[i] == 1) continue;
	        int pre = i == 0 ? 0 : flowerbed[i - 1];
	        int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
	        if(pre == 0 && next == 0) {
	            cnt++;
	            flowerbed[i] = 1;
	        }
	    }
	    return cnt >= n;
	}
}
