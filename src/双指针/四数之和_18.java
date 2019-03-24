package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 四数之和_18 {
	
public static List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();//利用set来去除重复的数组
	        List<List<Integer>> result = new ArrayList<>();//保存结果
        for(int i=0;i<nums.length;i++){
            //去重
            if(i>0 && nums[i]==nums[i-1]) continue;
            //四转三
            for(int j=i+1;j<nums.length;j++){
              if(j>i+1 && nums[j]==nums[j-1]) continue;  
                //三转二
                int left =j+1;
                int right =nums.length-1;
                while(left<right){
                int tempSum=nums[left]+nums[right]+nums[i]+nums[j];
                if(tempSum ==target){
                    List<Integer> temp = new ArrayList<>();
	                temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[left]);temp.add(nums[right]);
	                set.add(temp);
                    //去重
                    int lnum = nums[left];
                    int rnum=nums[right];
                    if(lnum ==nums[left]){
                        left++;
                           if(left>=right)
	                            break;
                    }
                      if(rnum ==nums[right]){
                        right--;
                           if(left>=right)
	                            break;
                    }
                }else if(tempSum<target){
	                    left++;
	            }else{
	                    right--;
	                }
            }
                
            }
            
        }
        for(List<Integer> list:set){//遍历set集合,将结果存入result中
	            result.add(list);
	        }
	        return result;
        
    }

public static void main(String[] args) {
	fourSum(new int[] {1,0,-1,0,-2,2},0);
}
        

}
