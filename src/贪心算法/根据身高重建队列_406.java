package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 根据身高重建队列_406 {

	/*
	 * 406
	 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

		注意：
		总人数少于1100人。
		
		示例
		
		输入:
		[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
		
		输出:
		[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	 */
	/*
	 * 为了在每次插入操作时不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入第 k 个位置可能会变成第 k+1 个位置。
	   身高降序、k 值升序，然后按排好序的顺序插入队列的第 k 个位置中。
	 */
	/*
	 * people： 
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]] 
排序后： 
[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]] 
然后从数组people第一个元素开始，放入到数组result中，放入的位置就是离result开始位置偏移了元素第二个数字后的位置。如下： 
1. 
people: [7,0] 
插入到离开始位置偏移了0个距离的位置。 
result: [[7,0]] 
2. 
people: [7,1] 
插入到离开始位置偏移了1个距离的位置，即插入到[7,0]的后面。 
result: [[7,0], [7,1]] 
3. 
people: [6,1] 
插入到离开始位置偏移了1个距离的位置，即插入到[7,0]的后面。 
result: [[7,0], [6,1], [7,1]] 
4. 
people: [5,0] 
插入到离开始位置偏移了0个距离的位置，即插入到[7,0]的前面。 
result: [[5,0], [7,0], [6,1], [7,1]] 
5. 
people: [5,2] 
插入到离开始位置偏移了2个距离的位置，即插入到[7,0]的后面。 
result: [[5,0], [7,0], [5,2], [6,1], [7,1]] 
5. 
people: [4,4] 
插入到离开始位置偏移了4个距离的位置，即插入到[6,1]的后面。 
result: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	 */
	   public static int[][] reconstructQueue(int[][] people) {
		   if(people == null || people.length == 0 || people[0].length == 0) return new int[0][0];

		    Arrays.sort(people, new Comparator<int[]>() {
		       public int compare(int[] a, int[] b) {
		           if(a[0] == b[0]) return a[1] - b[1]; //升序
		           return b[0] - a[0]; //降序
		       }
		    });
		    //(7,0),(7,1),(6,1),(5,0),(5,2),(4,4)
		    //获取people的身高数,4
		    int n = people.length;
		    //定义一个临时的list
		    List<int[]> tmp = new ArrayList<>();
		    for(int i = 0; i < n; i++) {
		        tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
		    }
		    //有n个一维数组的长度为2
		    int[][] ret = new int[n][2];
		    for(int i = 0; i < n; i++) {
		        ret[i][0] = tmp.get(i)[0];
		        ret[i][1] = tmp.get(i)[1];
		    }
		    return ret;
	        
	    }
	   
	   public   int[][] reconstructQueue2(int[][] people) {
		  //进行非空判断
		   if(people.length==0 || people == null || people[0].length ==0) return new int[0][0];
		   
		//进行排序
		   Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				if(a[0] == b[0] ) return a[1] -b[1];  //降序
 				return b[0] - a[0]; //降序
			}
		   });
		   int n =people.length;
		   List<int[]> temp = new ArrayList<>();
		   for (int i = 0; i < n; i++) {
			   temp.add(people[i][1], new int[]{people[i][0], people[i][1]});
		}
		   int[][] ret = new int[n][2];
		    for(int i = 0; i < n; i++) {
		        ret[i][0] = temp.get(i)[0];
		        ret[i][1] = temp.get(i)[1];
		    }
		    return ret;
	   }
	   public static void main(String[] args) {
		   int[][] test = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		   reconstructQueue(test);
	}
}
