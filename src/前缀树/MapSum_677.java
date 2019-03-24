package 前缀树;

import java.util.HashMap;
import java.util.Map;

public class MapSum_677 {
    /*
     * leetcode(键值映射) 677
     * 实现一个 MapSum 类里的两个方法，insert 和 sum。

	对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，
	那么原来的键值对将被替代成新的键值对。
	
	对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
	
	示例 1:
	
	输入: insert("apple", 3), 输出: Null
	输入: sum("ap"), 输出: 3
	输入: insert("app", 2), 输出: Null
	输入: sum("ap"), 输出: 5
     */
	/*
	 * 思路:在Hashmap中每个键值对应一个数， 
	插入一个键值对时： 
	如果key不存在，则将键值对存进Hashmap中，并且将key的所有前缀连同数值组成新的键值对存进Hashmap mem中；
	对于一个前缀，如果在mem中已经存在，那么只需在原数值上加上当前键值对的数值，如果前缀原先不存在于mem中，则直接赋为当前键值对的数值； 
	如果key存在，则key的新值会取代旧值，因此要在mem中更新与key有关的前缀的值

	计算前缀对应的数值： 	
	由于mem维护所有前缀对应的数值并在插入过程中一直保持更新，所以对只需取出mem中对应前缀的数值
	 */
	
	    private class Trie {
	        int val;
	        Map<Character, Trie> childs;
	        boolean isWord;

	        Trie() {
	            childs = new HashMap<>();
	        }
	    }

	    private Trie root;

	    public MapSum_677() {
	        root = new Trie();
	    }

	    public void insert(String key, int val) {
	    	
	        Trie cur = root;
	        
	        for(char c : key.toCharArray()) {
	        	//当前的下一个节点不包含当前key,目的去重,比如app只保存ap
	            if(!cur.childs.containsKey(c)) {
	                Trie next = new Trie();
	                cur.childs.put(c, next);
	            }
	            //当前的值一直被更新,为next
	            cur = cur.childs.get(c);
	        }
	        cur.val = val;
	        cur.isWord = true;
	    }

	    public int sum(String prefix) {
	        Trie cur = root;
	        for(char c : prefix.toCharArray()) {
	            if(!cur.childs.containsKey(c)) return 0;
	            cur = cur.childs.get(c);
	        }
	        return dfs(cur);
	    }

	    private int dfs(Trie cur) {
	        int sum = 0;
	        if(cur.isWord) {
	            sum += cur.val;
	        }
	        for(Trie next : cur.childs.values()) {
	            sum += dfs(next);
	        }
	        return sum;
	    }
}
