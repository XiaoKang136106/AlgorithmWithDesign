package 剑指offer;

/*
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
   要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
import java.util.Stack;
public class _26二叉搜索树与双向链表 {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	   /* //思路:定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
	    public TreeNode Convert(TreeNode pRootOfTree) {
		 
		 TreeNode lastlist = covertNode(pRootOfTree,null);
		 TreeNode pHead = lastlist;
		 while (pHead != null && pHead.left != null) {
		 pHead = pHead.left;
		 }
		 return pHead;
		 }
	 
	 
	    public TreeNode covertNode(TreeNode root, TreeNode lastlist) {
			 if (root == null)
			 return null;
			 
			 TreeNode cur = root;
			 
			 if (cur.left != null) {
			 lastlist = covertNode(cur.left,lastlist);
			 } 
			 
			 cur.left = lastlist;
			 
			 if (lastlist != null) {
			 lastlist.right = cur;
			 } 
			 lastlist = cur;
			 
			 if (cur.right != null) {
				 
			 
			 lastlist = covertNode(cur.right,lastlist);
			
			 } 
			 return lastlist;
	    }
	    
	    
	    --------------------------------------------------
	    (推荐)
	     TreeNode tail = null;//head是排序后的最后一个结点，命名为tail更易懂
         TreeNode realHead = null;//realHead是每个子树排序后的第一个结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }
     
    private void ConvertSub(TreeNode pRootOfTree) {


        if(pRootOfTree==null) return;
        //左
        ConvertSub(pRootOfTree.left);
        //没有node,realhead和tail都指向pRootOfTree
        if (tail == null) {
            tail = pRootOfTree; 
            realHead = pRootOfTree;
        } else {
            //改变二叉树的位置
            //构造双向链表
            tail.right = pRootOfTree;//pRootOfTree指向tail的右边
            pRootOfTree.left = tail;	//tail指向pRootOfTree左边
            tail = pRootOfTree;	//pRootOfTree指向tail,始终在尾部.用于下一轮遍历
        }
        //右
        ConvertSub(pRootOfTree.right);
    }
*/
	
	
	    	/*方法一：非递归版
	    	解题思路：
	    	1.核心是中序遍历的非递归算法。
	    	2.修改当前遍历节点与前一遍历节点的指针指向。*/
	    	   
	    	    public TreeNode ConvertBSTToBiList(TreeNode root) {
	    	        if(root==null)
	    	            return null;
	    	        Stack<TreeNode> stack = new Stack<TreeNode>();
	    	        TreeNode p = root;
	    	        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
	    	        boolean isFirst = true;
	    	        while(p!=null||!stack.isEmpty()){
	    	            while(p!=null){
	    	            	//压栈
	    	                stack.push(p);
	    	                p = p.left;
	    	            	}
	    	            	//出栈
	    	            p = stack.pop();
	    	            if(isFirst){
	    	                root = p;// 将中序遍历序列中的第一个节点记为root
	    	                pre = root;
	    	                isFirst = false;
	    	            }else{
	    	                pre.right = p;
	    	                p.left = pre;
	    	                pre = p;
	    	            }      
	    	            p = p.right;
	    	        }
	    	        return root;
	    	    }
	    	/*方法二：递归版
	    	解题思路：
	    	1.将左子树构造成双链表，并返回链表头节点。
	    	2.定位至左子树双链表最后一个节点。
	    	3.如果左子树链表不为空的话，将当前root追加到左子树链表。
	    	4.将右子树构造成双链表，并返回链表头节点。
	    	5.如果右子树链表不为空的话，将该链表追加到root节点之后。
	    	6.根据左子树链表是否为空确定返回的节点。*/
	    	    public TreeNode Convert(TreeNode root) {
	    	        if(root==null)
	    	            return null;
	    	        if(root.left==null&&root.right==null)
	    	            return root;
	    	        // 1.将左子树构造成双链表，并返回链表头节点
	    	        TreeNode left = Convert(root.left);
	    	        TreeNode p = left; //p指向了头节点
	    	        // 2.定位至左子树双链表最后一个节点
	    	        while(p!=null&&p.right!=null){
	    	            p = p.right;
	    	        }
	    	        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
	    	        if(left!=null){
	    	            p.right = root;
	    	            root.left = p;
	    	        }
	    	        // 4.将右子树构造成双链表，并返回链表头节点
	    	        TreeNode right = Convert(root.right);
	    	        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
	    	        if(right!=null){
	    	            right.left = root;
	    	            root.right = right;
	    	        }
	    	        return left!=null?left:root;       
	    	    }
	    	/*方法三：改进递归版
	    	解题思路：
	    	思路与方法二中的递归版一致，仅对第2点中的定位作了修改，新增一个全局变量记录左子树的最后一个节点。*/
	    	    // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
	    	    protected TreeNode leftLast = null;
	    	    public TreeNode Convert2(TreeNode root) {
	    	        if(root==null)
	    	            return null;
	    	        if(root.left==null&&root.right==null){
	    	            leftLast = root;// 最后的一个节点可能为最右侧的叶节点
	    	            return root;
	    	        }
	    	        // 1.将左子树构造成双链表，并返回链表头节点
	    	        TreeNode left = Convert(root.left);
	    	        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
	    	        if(left!=null){
	    	            leftLast.right = root;
	    	            root.left = leftLast;
	    	        }
	    	        leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
	    	        // 4.将右子树构造成双链表，并返回链表头节点
	    	        TreeNode right = Convert(root.right);
	    	        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
	    	        if(right!=null){
	    	            right.left = root;
	    	            root.right = right;
	    	        }
	    	        return left!=null?left:root;       
	    	    }

}
