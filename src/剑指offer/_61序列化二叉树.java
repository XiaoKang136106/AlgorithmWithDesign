package 剑指offer;

public class _61序列化二叉树 {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}
	// 请实现两个函数，分别用来序列化和反序列化二叉树

	/*
	 * 序列化：前序遍历二叉树存入字符串中；反序列化：根据前序遍历重建二叉树
	 */
	/*
	 * String Serialize(TreeNode root) { StringBuffer sb = new StringBuffer(); if
	 * (root == null) { sb.append("#,"); return sb.toString(); } sb.append(root.val
	 * + ","); sb.append(Serialize(root.left)); sb.append(Serialize(root.right));
	 * return sb.toString(); }
	 * 
	 * public int index = -1;
	 * 
	 * public TreeNode Deserialize(String str) {
	 *  index++; 
	 *  int len = str.length();
	 * String[] strr = str.split(","); 
	 * TreeNode node = null; 
	 * if (index >= len)
	 * return null; //是否等于结束标志 
	 * if (!strr[index].equals("#")) { 
	 * node = new TreeNode(Integer.valueOf(strr[index])); 
	 * node.left = Deserialize(str);
	 * node.right = Deserialize(str); 
	 * } 
	 * return node; 
	 * }
	 */
	/*
	 * 思路:序列化的时候使用sb来存放前序遍历的节点,使用"#"作为结束标志,每次添加元素增加","分隔符
	 * 反序列化的时候利用索引来获取每个元素的信息,当获取到"#"就返回
	 */
	String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		// 开始前序遍历
		if (root == null) {
			// 添加结束标志
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ","); // 根
		sb.append(Serialize(root.left)); // 左
		sb.append(Serialize(root.right)); // 右
		return sb.toString();

	}

	public int index = -1;

	TreeNode Deserialize(String str) {
		// 用于获取字符数组的下标
		index++;
		// 进行分割,也包含#结束标志
		String[] strr = str.split(",");

		// 获取长度
		int len = strr.length;
		if (index >= len)
			return null;
		//创建一个头结点
		TreeNode node =null;
		
		//不等于结束标记一直进行反序列化
		if(!strr[index].equals("#")) {
			
			node = new TreeNode(Integer.valueOf(strr[index])); //根
			node.left = Deserialize(str);//左
			node.right =Deserialize(str);//右
		}
		return node;
		
	}

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		sb.append("1,");
		sb.append("2,");
		sb.append("3,");
		sb.append("4,");
		sb.append("5,");
		System.out.println(sb.toString().length());
		String[] split = sb.toString().split(",");
		System.out.println(split.length);

	}
}
