package 图论;

import java.util.ArrayDeque;
import java.util.Arrays;

import 图论.BinaryTree.TreeNode;

/*
 * Breadth FirstSearch(广度优先算法)
 * 其过程检验来说是对每一层节点依次访问，访问完一层进入下一层，
 * 而且每个节点只能访问一次。
 * 
 */
public class BinaryTree {
	/*
	 * 首先将A节点插入队列中，队列中有元素（A）;

	　  将A节点弹出，同时将A节点的左、右节点依次插入队列，B在队首，C在队尾，（B，C），此时得到A节点；

　   　 	   继续弹出队首元素，即弹出B，并将B的左、右节点插入队列，C在队首，E在队尾（C,D，E），此时得到B节点；

　	　 继续弹出，即弹出C，并将C节点的左、中、右节点依次插入队列，（D,E,F,G,H），此时得到C节点；

　　       将D弹出，此时D没有子节点，队列中元素为（E,F,G,H），得到D节点；

　     　。。。以此类推。。
	 */
	public class TreeNode{
		int value =0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	
		TreeNode root;
		
		public BinaryTree(int[] array) {
			//构建二叉树,索引从1开始
			root = makeBinaryTreeByArray(array,1);
		}
		 /**
	     * 采用递归的方式创建一颗二叉树
	     * 传入的是二叉树的数组表示法
	     * 构造后是二叉树的二叉链表表示法
	     */

		private TreeNode makeBinaryTreeByArray(int[] array, int index) {
			
			
			 if(index<array.length){
				 
				 int value=array[index];
				 if(value!=0){
					 //构建新节点
					 TreeNode t=new TreeNode(value);//将array中的值赋给新节点
					 array[index]=0;//清空array中的值
					 t.left=makeBinaryTreeByArray(array,index*2);//左节点的索引
					 t.right=makeBinaryTreeByArray(array,index*2+1);//右节点的索引
					 return t;   
					 }
				 }    
			 return null;
		}
		
		/**
	     * 深度优先遍历(Depth First Search)，相当于先根遍历
	     * 采用非递归实现
	     * 需要辅助数据结构：栈
	     * 步骤:
	     * 其过程简要来说是对每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。对于上面的例子来说深度优先遍历的结果就是：A,B,D,E,I,C,F,G,H.(假设先走子节点的的左侧)。
			深度优先遍历各个节点，需要使用到栈（Stack）这种数据结构。
			stack的特点是是先进后出。整个遍历过程如下：	
			先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
			首先将A节点压入栈中，stack（A）;
			将A节点弹出，同时将A的子节点C，B压入栈中，此时B在栈的顶部，stack(B,C)；
			将B节点弹出，同时将B的子节点E，D压入栈中，此时D在栈的顶部，stack（D,E,C）；
			将D节点弹出，没有子节点压入,此时E在栈的顶部，stack（E，C）；
			将E节点弹出，同时将E的子节点I压入，stack（I,C）；
			...依次往下，最终遍历完成。
	     */
		public void depthOrderTraversal() {
			
			if(root == null) {
				System.out.println("empty tree");
				return ;
			}
			//创建一个栈
			ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
			//压栈
			stack.push(root);
			//循环判断栈是否为空
			//	=>不为空
			while(stack.isEmpty() == false) {
				//弹栈
				TreeNode node = stack.pop();
				System.out.print(node.value+" ");
				//将右节点进行压栈
				if(node.right !=null) {
					stack.push(node.right);
				}
				//将左节点进行压栈
				if(node.left !=null) {
					stack.push(node.left);
				}
			}
			System.out.println();
		}
		   /**
	     * 广度优先遍历
	     * 采用非递归实现
	     * 需要辅助数据结构：队列
	     * 思路:先添加左节点在添加右节点
	     */
		public void levelOrderTraversal() {
			
			if(root ==null) {
				System.out.println("empty tree");
				return;
			}
			//创建队列
			ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
			//将root添加进来
			queue.add(root);
			//循环遍历队列
			//  =>不为空
			while(queue.isEmpty() ==false) {
				//出队列
				TreeNode node = queue.remove();
				System.out.print(node.value+" ");
				//判断是否有左节点
				if(node.left != null) {
					//添加到队列
					queue.add(node.left);
				}
				//判断是否有右节点
				if(node.right != null) {
					//添加到队列
					queue.add(node.right);
				}
			}
			System.out.println();
		}
		/**                      
					   13           
					  /  \         
					 65   5     
					/  \   \           
				   97  25  37          
				  /   / \  /         
				 22  4  28 32     
		 * */
		public static void main(String[] args) {
			int[] arr = {0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
			System.out.println(Arrays.toString(arr));
			BinaryTree tree = new BinaryTree(arr);
			System.out.println(Arrays.toString(arr));
			tree.depthOrderTraversal(); //深度优先算法
			tree.levelOrderTraversal(); //广度优先算法
			
		}


		

}
