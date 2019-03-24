package 剑指offer;

public class _35数组中的逆序对 {
		/*
		 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
		 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
		 */
//思路：本质是归并排序，在比较时加入全局变量count进行记录逆序对的个数，若data[start] >= data[index]
//则count值为mid+1-start,(因为:则前面数组array[start]~array[mid]都是大于array[j]的，count += mid+1 - start)
	int count =0;
    public int InversePairs(int [] array) {
        if(array ==null || array.length==0){
            return  0;
        }
        sort(array, 0, array.length - 1);
        return count;
    }
    private  void sort(int[] arr, int low, int high) {
			
			if(low<high) {
			int mid =(low+high)>>1;	
			sort(arr, low, mid);
			sort(arr, mid+1, high);
			merge(arr, low, mid, high);
			}
	}

	private  void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high-low+1];
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=high) {
			if(arr[i]<arr[j]) {
				temp[k++]=arr[i++];
			}else {
				temp[k++]=arr[j++];
                count =count + mid+1-i;
                count %= 1000000007;
			}
		}
		while(i<=mid) {
			temp[k++]=arr[i++];
		}
		while(j<=high) {
			  temp[k++]=arr[j++];
		}
		for (int l = 0; l < temp.length; l++) {
			arr[low+l]=temp[l];
		}
	}
	
}
