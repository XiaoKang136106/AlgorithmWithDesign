package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 三数之和_15 {
	 public List<List<Integer>> threeSum(int[] nums) {
	        Set<List<Integer>> set = new HashSet<>();//利用set来去除重复的数组
	        List<List<Integer>> result = new ArrayList<>();//保存结果
	        Arrays.sort(nums);//对数组进行排序,才能用二分查找法
	        for(int i=0;i<nums.length-2;i++){
	        	//left为i+1是因为前面已经被选完了
	            int left=i+1,right=nums.length-1;//left和right当做两个指针
	            while(left<right){
	                int tempSum=nums[i]+nums[left]+nums[right];
	                if(tempSum==0){
	                    List<Integer> temp = new ArrayList<>();
	                    temp.add(nums[i]);temp.add(nums[left]);temp.add(nums[right]);
	                    set.add(temp);
	                    //跳过与当前数字重复的数字,例如[-1,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,-1,-4]
	                    int j=nums[left],k=nums[right];
	                    while(j==nums[left]){
	                        left++;
	                        if(left>=right)
	                            break;
	                    }
	                    while(k==nums[right]){
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
