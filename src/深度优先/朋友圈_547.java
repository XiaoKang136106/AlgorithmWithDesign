package 深度优先;

public class 朋友圈_547 {
/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
 * 那么我们可以认为 A也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:
	
	输入: 
	[[1,1,0],//1和2为朋友
	 [1,1,0],//2和1为朋友
	 [0,0,1]]//3都不与他们为朋友
	输出: 2 
	说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
	第2个学生自己在一个朋友圈。所以返回2。
	示例 2:
	
	输入: 
	[[1,1,0],
	 [1,1,1],
	 [0,1,1]]
	输出: 1
	说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
	注意：
	
	N 在[1,200]的范围内。
	对于所有学生，有M[i][i] = 1。
	如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 */
	/*public int findCircleNum(int[][] M) {
	    int n = M.length; //row,表示每个人的朋友集合
	    int ret = 0; //记录
	    boolean[] hasFind = new boolean[n]; //定义一个Boolean数组
	    //遍历
	    for(int i = 0; i < n; i++) {
	        //为0,进入, 没有访问到，就把当前的组+1，并把可以包含在朋友圈的所有的有关系的好友标记出来
	    	if(!hasFind[i]) {
	            dfs(M, i, hasFind);//在去找这个好友的好友
	            ret++;
	        }
	    }
	    return ret;
	}

	private void dfs(int[][] M, int i, boolean[] hasFind) {
	    hasFind[i] = true; //假设row为1
	    int n = M[0].length;//同学数
	    for(int k = 0; k < n; k++) {
	    	//为1,为k为位置上为0,为朋友但他们的朋友圈不都相同
	        if(M[i][k] == 1 && !hasFind[k]) {
	            dfs(M, k, hasFind);//在去找这个好友的好友
	        }
	    }
	}*/
	
	
    public int findCircleNum(int[][] M) {
     int ret =0;
     int n = M.length;
     boolean[] hasFind = new boolean[n];
     for (int i = 0; i <n; i++) {
    	 
    	 //为0肯定不为一个朋友圈
    	 //不为0
    	 if(!hasFind[i]) {
    		 dfs(M,i,hasFind);
    		 ret++;
    	 }
	}
     	return ret;
    }

	private void dfs(int[][] M, int i, boolean[] hasFind) {
		int n = M.length;
		hasFind[i] = true; 
		for(int k=0;k<n;k++) {
			if(M[i][k] ==1 && !hasFind[k]) {
				dfs(M, k, hasFind);
			}
		}
		
	}
}
