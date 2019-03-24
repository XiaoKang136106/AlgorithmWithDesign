package 前缀树;

public class 前缀树_208 {
/*	前缀树(字典树):用于判断字符串是否存在或者是否具有某种字符串前缀。
	它有三个基本性质，根节点不包含字符，除根节点外每一个节点都只包含一个字符，从根节点到某一节点，路径上经过的字符连接起来，
	为该节点对应的字符串，每个节点的所有子节点包含的字符都不相同。

	字典树的插入，删除和查找都非常简单，用一个一重循环即可。 
	1. 从根节点开始一次搜索 
	2. 取得要查找关键词的第一个字母，并根据该字母选择对应的子树并转到该子树继续进行检索 
	3. 在相应的子树上，取得要查找关键词的第二个字母，并进一步选择对应的子树进行检索 
	4. 迭代上述过程… 
	5. 在某个节点处，关键词的所有字母已被取出，则读取附在该节点上的信息，即完成查找*/

	/*
	实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

	示例:

	Trie trie = new Trie();

	trie.insert("apple");
	trie.search("apple");   // 返回 true
	trie.search("app");     // 返回 false
	trie.startsWith("app"); // 返回 true
	trie.insert("app");   
	trie.search("app");     // 返回 true

	*/
		//创建Node节点
	  private class Node{
	       //存放26个字母开头的数值
	        Node[] childs = new Node[26];
	        //是否为叶子节点,判断是否只有一个元素
	        boolean isLeaf;
	    }

	    private Node root = new Node();

	    /** Initialize your data structure here. */
	    public 前缀树_208() {
	    	
	    }

	    /** Inserts a word into the trie. */
		//插入的思路:判断是否为root,是的话需要创建node,在判断是否为isLeaf,否则,截取字符串将当前的node.childs[idx]带入进去
	    public void insert(String word) {
	        int idx = word.charAt(0) - 'a';
	        insert(word, root);
	    }

	    private void insert(String word, Node node){
	        int idx = word.charAt(0) - 'a';
		//为根节点的话,创建null的Node
	        if(node.childs[idx] == null){
	            node.childs[idx] = new Node();
	        }
	        //判断是否只有一个元素
	        if(word.length() == 1) node.childs[idx].isLeaf = true;
	       //插入当前节点,并每次截取掉当前的元素,用于下一次递归
	        else insert(word.substring(1), node.childs[idx]);
	    }

	    /** Returns if the word is in the trie. */
		//判断node是否为null,判断node.childs[idx]是否匹配,匹配需要判断是否为isLeaf,最后进行同上递归
	    public boolean search(String word) {
	        return search(word, root);
	    }

	    private boolean search(String word, Node node){
		//判断root是否为null
	        if(node == null) return false;
		//匹配第一个节点
	        int idx = word.charAt(0) - 'a';
	        if(node.childs[idx] == null) return false;
		//判断是否只有一个元素
	        if(word.length() == 1) return node.childs[idx].isLeaf;
		//继续向下搜索
	        return search(word.substring(1), node.childs[idx]);
	    }
		//思路:node是否为null,prefix的长度是否为0,然后同上递归

	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        return startWith(prefix, root);
	    }

	    private boolean startWith(String prefix, Node node){
		//判断root是否为null
	        if(node == null) return false;
		//没有前缀了,说明匹配成功
	        if(prefix.length() == 0) return true;
	        int idx = prefix.charAt(0) - 'a';
	        return startWith(prefix.substring(1), node.childs[idx]);
	    }
}
