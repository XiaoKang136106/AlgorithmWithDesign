package 链表;
/**
 * 单向链表包含多个节点
 * @author xiaok
 *
 */
public class SingleLinkedList {
	private int size; // 链表的大小

	private Node head; // 链表的头结点

	public SingleLinkedList() {
		// 初始化
		size = 0;
		head = null;
	}

	class Node {

		private Object data; // 每个节点的数据

		private Node next;// 每个节点指向下一个节点的连接

		public Node(Object data) {
			this.data = data;
		}
	}
		// 在链表头添加元素

		public Object addHead(Object obj) {
			Node newNode = new Node(obj);

			// 判断单向链表是否存在head
			if (size == 0) {
				head = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}
			size++;
			return obj;
		}

		// 在链表头删除元素

		public Object removeHead() {
			if (size == 0) {
				return null;
			} else {
				Object obj = head.data;
				if (obj != null) {
					head = head.next;
				}
				size--;
				return obj;
			}
		}

		// 查找指定元素，找到了返回节点Node，找不到返回null
		public Node find(Object obj) {

			if (size == 0) {
				return null;
			}
			// 获取head和size,赋给临时值
			Node current = head;
			int currentSize = size;
			while (currentSize > 0) {
				if (obj.equals(current.data)) {
					return current;
				}
				current = current.next;// 把当前的节点赋给自己
				currentSize--;
			}

			return null;

		}

		// 删除指定的元素，删除成功返回true
		public Boolean removeNode(Object obj) {
			if (size == 0) {
				return false;
			}
			Node current = head; // 用于遍历
			 Node previous = head;//前一个节点
			while (current.data != obj) {
				if (current.next == null) {
					return false;
				} else {
					previous=current; //把当前的节点赋给前一个节点
					current = current.next;// 调到下一个节点
				}
			}
			//如果删除的是第一个
			if(current == head) {
				head=current.next;
				size--;
			}else {
				//不是第一个,previous的next指向current.next
				previous.next=current.next;
				size--;
			}
			return true;
		}

		// 判断链表是否为空
		public boolean isEmpty() {
			return (size == 0);
		}

		// 显示节点信息
		public void display() {
			if (size > 0) {
				Node node = head;
				int tempSize = size;
				if (tempSize == 1) {// 当前链表只有一个节点
					System.out.println("[" + node.data + "]");
					return;
				}
				while (tempSize > 0) {
					if (node.equals(head)) {
						System.out.print("[" + node.data + "->");
					} else if (node.next == null) {
						System.out.print(node.data + "]");
					} else {
						System.out.print(node.data + "->");
					}
					node = node.next;
					tempSize--;
				}
				System.out.println();
			} else {// 如果链表一个节点都没有，直接打印[]
				System.out.println("[]");
			}

		}

	public static void main(String[] args) {
		 SingleLinkedList singleList = new SingleLinkedList();
		   	singleList.addHead("A");
		    singleList.addHead("B");
		    singleList.addHead("C");
		    singleList.addHead("D");
		    //打印当前链表信息
		    singleList.display();
		    //删除C
		    singleList.removeNode("C");
		    singleList.display();
		    //查找B
		    System.out.println(singleList.find("B"));
	}

}
