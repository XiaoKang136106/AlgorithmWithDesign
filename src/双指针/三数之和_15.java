package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 三数之和_15 {
	/*
    先排序,然后进行遍历,在遍历的时候定义两个指针,left=i+1,right=nums.length-1,
    当nums[left]+nums[right]+nums[i],就添加到一个Set集合中,
    优化,可以去掉重复的数
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();//利用set来去除重复的数组
	        List<List<Integer>> result = new ArrayList<>();//保存结果
        for(int i=0;i<nums.length;i++){
            int left =i+1;
            int right =nums.length-1;
            while(left<right){
              int tempSum=nums[i]+nums[left]+nums[right];
                if(tempSum ==0){
                    List<Integer> temp = new ArrayList<>();
	                temp.add(nums[i]);temp.add(nums[left]);temp.add(nums[right]);
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
                }else if(tempSum<0){
	                    left++;
	                }
	                else{
	                    right--;
	                }
            }
        }
        for(List<Integer> list:set){//遍历set集合,将结果存入result中
	            result.add(list);
	        }
	        return result;
       
    }

}
