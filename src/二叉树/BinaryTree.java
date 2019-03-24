package 二叉树;

import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * 
 * @ClassName: BinaryTree
 * @Description: TODO(二叉树的构建)
 * @author xiaok
 * @date 2018年10月5日 下午2:08:53
 *
 */
public class BinaryTree {
	// 定义节点
	class Node {
		int value; // 数据

		Node leftChild; // 左节点

		Node rightChild; // 右节点

		Node(int value) {
			this.value = value;
		}

		public void display() {
			System.out.print(this.value + "\t");
		}
	}

	// 定义二叉树
	private Node root = null;

	BinaryTree(int value) {

		this.root = new Node(value);
		root.leftChild = null;
		root.rightChild = null;
	}

	// 查找数据
	public Node findKey(int value) {
		// 从根节点开始查找
		Node currentNode = root;
		// 循环查找
		while (true) {
			if (currentNode.value == value) {
				return currentNode;
			} else if (currentNode.value < value) {
				// 值大于当前的节点上的值
				currentNode = currentNode.rightChild;
			} else if (currentNode.value > value) {
				// 值小于当前的节点上的值
				currentNode = currentNode.leftChild;
			}
			// 到达叶子节点
			if (currentNode == null) {
				return null;
			}

		}

	}

	// 插入
	public String insert(int value) {

		/*String error = null;
		// 创建节点
		Node newNode = new Node(value);
		// 判断是否有root节点
		if (root == null) {
			root = newNode;
			root.leftChild = null;
			root.rightChild = null;
		} else {
			// 从root开始
			Node currentNode = root;
			Node parentNode = null;// 定义一个父节点
			// 循环遍历,进行插入
			while (true) {
				// 当前节点的值大于插入的值
				if (currentNode.value > value) {
					// 当前节点为父节点
					parentNode = currentNode;
					currentNode = currentNode.leftChild;// 左节点为当前的节点
					if (currentNode == null) {
						// 只有当前节点为空才能赋值
						currentNode = newNode;
						break;
					}
				} // 当前节点的值小于插入的值
				else if (currentNode.value < value) {
					// 当前节点为父节点
					parentNode = currentNode;
					currentNode = currentNode.rightChild;// 右节点为当前的节点
					if (currentNode == null) {
						// 只有当前节点为空才能赋值
						currentNode = newNode;
						break;
					}
				} else {
					error = "having same value in binary tree";
				}
			}
		}
		return error;*/
				String error = null;
				
				Node node = new Node(value);
				if (root == null) {
					root = node;
					root.leftChild  = null;
					root.rightChild = null;
				} else {
					Node current = root;
					Node parent = null;
					while (true) {
						if (value < current.value) {
							parent = current;
							current = current.leftChild;
							if (current == null) {
								parent.leftChild = node;
								break;
							}
						} else if (value > current.value) {
							parent = current;
							current = current.rightChild;
							if (current == null) {
								parent.rightChild = node;
								break;
							}
						} else {
							error = "having same value in binary tree";
						}	
					} // end of while
				}
				return error;
	}

	// 前序遍历 根 -> 左 -> 右
	public void preOrderTraverse() {
		System.out.print("前序遍历:");
		preOrderTraverse(root);
		System.out.println();
	}

	private void preOrderTraverse(Node node) {
		if (node == null)
			return;
		node.display(); // 根,访问这个节点
		preOrderTraverse(node.leftChild); // 左
		preOrderTraverse(node.rightChild); // 右
	}

	/*
	 * 前序遍历非递归操作
	 * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
	 * 2）若左子树为空，栈顶节点出栈，将该节点的右子树置为current 3) 重复1、2步操作，直到current为空且栈内节点为空。
	 */
	public void preOrderByStack() {
		System.out.print("前序非递归遍历:");
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current.display();
				current = current.leftChild;
			}
			if (!stack.isEmpty()) {
				current = stack.pop();
				current = current.rightChild;
			}
		}
		System.out.println();
	}

	// 中序遍历递归操作,左->根->右
	public void inOrderTraverse() {
		System.out.print("中序遍历:");
		inOrderTraverse(root);
		System.out.println();

	}

	private void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.leftChild); // 左
		node.display(); // 根,访问这个节点
		inOrderTraverse(node.rightChild); // 右
	}

	/*
	 * 中序遍历非递归操作 1，首先从根节点出发一路向左，入栈所有的左节点；
	 * 2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
	 * 3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作； 4，直到节点为null，且栈为空。
	 */
	public void inOrderByStack() {
		System.out.print("中序非递归遍历:");
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.leftChild;
			}
			if (!stack.isEmpty()) {
				current = stack.pop();
				current.display();
				current = current.rightChild;
			}
		}
		System.out.println();

	}

	// 后序遍历 左 ->右 ->根
	public void postOrderTraverse() {
		System.out.print("后序遍历:");
		postOrderTraverse(root);
		System.out.println();
	}

	private void postOrderTraverse(Node node) {
		postOrderTraverse(node.leftChild); // 左
		postOrderTraverse(node.rightChild); // 右
		node.display(); // 根,当前节点

	}

	/*
	 * 后序非递归遍历：
	 * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
	 * 2）若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点 3)
	 * 重复1、2步操作，直到current为空且栈内节点为空。
	 */
	public void postOrderByStack() {
		System.out.print("后序非递归遍历:");
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		Node preNode = null;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.leftChild;
			}
			if (!stack.isEmpty()) {
				current = stack.peek().rightChild;
				if (current == null || current == preNode) {
					current = stack.pop();
					current.display();
					preNode = current;
					current = null;
				}
			}
		}
		System.out.println();

	}

	// 得到最小(大)值,最小值在叶子节点的最左边,最大值在叶子节点的最右边
	public int getMinValue() {
		if (root == null)
			return -1; // 表示没有节点
		Node currentNode = root;
		while (true) {
			if (currentNode.leftChild == null) {
				return currentNode.value;
			}

			currentNode = currentNode.leftChild;
		}

	}
	// 删除
	public boolean delete(int value) {
		Node current = root;    
		//需要删除的节点		
		Node parent = null;     
		//需要删除的节点的父节点		
		boolean isLeftChild = true;   
		//需要删除的节点是否父节点的左子树				
		while (true) {			
			if (value == current.value) {				
				break;			
				} else if (value < current.value) {				
					isLeftChild = true;				
					parent = current;				
					current = current.leftChild;			
					} else {				
						isLeftChild = false;				
						parent = current;				
						current = current.rightChild;			
						}						
			//找不到需要删除的节点，直接返回			
			if (current == null)				
				return false;		
			}				
			//分情况考虑		
			//1、需要删除的节点为叶子节点		
			if (current.leftChild == null && current.rightChild == null) {			
				//如果该叶节点为根节点，将根节点置为null			
				if (current == root) {				
					root = null;			
					} else {				
						//如果该叶节点是父节点的左子节点，将父节点的左子节点置为null				
						if (isLeftChild) {					
							parent.leftChild  = null;				
							} else { 
								//如果该叶节点是父节点的右子节点，将父节点的右子节点置为null					
								parent.rightChild = null;				
								}			
						}		
				} 		
			//2、需要删除的节点有一个子节点，且该子节点为左子节点		
			else if (current.rightChild == null) {			
				//如果该节点为根节点，将根节点的左子节点变为根节点			
				if (current == root) {				
					root = current.leftChild;			
					} else {				
						//如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点				
						if (isLeftChild) {					
							parent.leftChild = current.leftChild;				
							} else { 
								//如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点					
								parent.rightChild = current.leftChild;				
								}			
						}		
				}		
			//2、需要删除的节点有一个子节点，且该子节点为右子节点		
			else if (current.leftChild == null) {			
				//如果该节点为根节点，将根节点的右子节点变为根节点			
				if (current == root) {				
					root = current.rightChild;			
					} else {				
						//如果该节点是父节点的左子节点，将该节点的右子节点变为父节点的左子节点				
						if (isLeftChild) {					
							parent.leftChild = current.rightChild;				
							} else {  
								//如果该节点是父节点的右子节点，将该节点的右子节点变为父节点的右子节点					
								parent.rightChild = current.rightChild;				
								}			
						}		
				}		
			//3、需要删除的节点有两个子节点，需要寻找该节点的后续节点替代删除节点		
			else {			
				Node successor = getSuccessor(current);			
				//如果该节点为根节点，将后继节点变为根节点，并将根节点的左子节点变为后继节点的左子节点			
				if (current == root) {				
					root = successor;			
					} else {				
						//如果该节点是父节点的左子节点，将该节点的后继节点变为父节点的左子节点				
						if (isLeftChild) {					
							parent.leftChild = successor;				
							} else {  
								//如果该节点是父节点的右子节点，将该节点的后继节点变为父节点的右子节点			
								parent.rightChild = successor;
								}			
						}		
				}		
			current = null;
			return true;


	} 

	/**	
	 *  得到后继节点，即删除节点的左后代	 
	 */	
	private Node getSuccessor(Node delNode) {		
		Node successor = delNode;		
		Node successorParent = null;		
		Node current = delNode.rightChild;				
		while (current != null) {			
			successorParent = successor;			
			successor = current;			
			current = current.leftChild;		
			}				
		//如果后继节点不是删除节点的右子节点时，		
		if (successor != delNode.rightChild) {			
			//要将后继节点的右子节点指向后继结点父节点的左子节点，			
			successorParent.leftChild = successor.rightChild;			
			//并将删除节点的右子节点指向后继结点的右子节点			
			successor.rightChild = delNode.rightChild;		
			}		
		//任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点		
		successor.leftChild = delNode.leftChild;				
		return successor;	
		}
	public static void main(String[] args) {		
		BinaryTree bt = new BinaryTree(52);		
		bt.insert(580);		
		bt.insert(12);		
		bt.insert(50);		
		bt.insert(58);		
		bt.insert(9);		
		bt.insert(888);		
		bt.insert(248);		
		bt.insert(32);		
		bt.insert(666);		
		bt.insert(455);		
		bt.insert(777);		
		bt.insert(999);		
		bt.inOrderTraverse();		
		bt.preOrderTraverse();		
		bt.postOrderTraverse();		
		System.out.println(bt.findKey(32));		
		System.out.println(bt.findKey(81));		
		System.out.println("最小值:" + bt.getMinValue());		
		//bt.delete(32);      //删除叶子节点//		
		//bt.delete(50);      //删除只有一个左子节点的节点		
		//bt.delete(248);      //删除只有一个右子节点的节点		
		//bt.delete(248);      //删除只有一个右子节点的节点		
		//bt.delete(580);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点的左后代		
		//bt.delete(888);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点		
		bt.delete(52);       //删除有两个子节点的节点，且删除节点为根节点				
		bt.inOrderTraverse();	    
		}


}
