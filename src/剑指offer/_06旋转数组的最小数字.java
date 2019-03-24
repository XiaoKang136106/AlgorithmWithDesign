package 剑指offer;

public class _06旋转数组的最小数字 {
	/*
	 * 旋转数组的最小数字
	 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，
	 *  输出旋转数组的最小元素。
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
	 */
	//思路:使用二分法查找,需要考虑三种情况：
	/*
		
		采用二分法解答这个问题，
		mid = low + (high - low)/2
		需要考虑三种情况：
		(1)array[mid] > array[high]:
		出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
		low = mid + 1
		(2)array[mid] == array[high]:
		出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
		还是右边,这时只好一个一个试 ，
		high = high - 1
		(3)array[mid] < array[high]:
		出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
		边。因为右边必然都是递增的。
		high = mid
		注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
		比如 array = [4,6]
		array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
		如果high = mid - 1，就会产生错误， 因此high = mid
	 */
	public int minNumberInRotateArray(int[] nums) {
	    if (nums.length == 0)
	        return 0;
	    int l = 0, h = nums.length - 1;
	    while (l < h) {
	        int m = l + (h - l) / 2;
	        //有重复,进行判断
	        if (nums[l] == nums[m] && nums[m] == nums[h])
	            return minNumber(nums, l, h);
	        //左边有序   4560123
	        else if (nums[m] <= nums[h])
	            h = m;
	        else
	            l = m + 1;
	    }
	    return nums[l];
	}

	private int minNumber(int[] nums, int l, int h) {
	    for (int i = l; i < h; i++)
	        if (nums[i] > nums[i + 1])
	            return nums[i + 1];
	    return nums[l];
	}
	/*public int minNumberInRotateArray(int[] array) {
		//复杂度是O（logN)
		if (array == null || array.length == 0)
			return 0;
		int left = 0;
		int right = array.length - 1;
		int mid = 0;
		//确保旋转
		while (array[left] >= array[right]) {
			//分界点
			if (right - left <= 1) {
				mid = right;
				break;
			}
			//二分查找
			mid = (left + right) / 2;
			//三者相同
			if (array[left] == array[mid] && array[mid] == array[right]) {
				//
				if (array[left + 1] != array[right - 1]) {
					//判断最小值在左边还是在右边
						// array[left] array[right] array[mid]三者相等
						// 无法确定中间元素是属于前面还是后面的递增子数组
						// 只能顺序查找
					mid = array[left + 1] < array[right - 1] ? left + 1 : right - 1;
				} else {
					left++;
					right--;
				}
			} else {
				 // 中间元素位于前面的递增子数组
	            // 此时最小元素位于中间元素的后面
				if (array[left] <= array[mid]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}
		return array[mid];

	}*/

}
