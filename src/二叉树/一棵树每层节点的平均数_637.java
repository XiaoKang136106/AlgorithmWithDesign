package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 一棵树每层节点的平均数_637 {
/**
 * Input: 
3 
/ \ 
9 20 
/ \ 
15 7

Output: [3, 14.5, 11]

Explanation: 
The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 
	//思路:层次遍历
	public List<Double> averageOfLevels(TreeNode root) {
	    List<Double> ret = new ArrayList<>();//返回值
	    if(root == null) return ret;
	    Queue<TreeNode> queue = new LinkedList<>();//存放数据的队列
	    
	    queue.add(root);
	    
	    while(!queue.isEmpty()){
	        int cnt = queue.size();
	        double sum = 0;
	        for(int i = 0; i < cnt; i++){
	            TreeNode node = queue.poll();
	            sum += node.val;//该层的总合
	            if(node.left != null) queue.add(node.left);
	            if(node.right != null) queue.add(node.right);
	        }
	        ret.add(sum / cnt);//平均值添加到结果
	    }
	    return ret;
	}
}
