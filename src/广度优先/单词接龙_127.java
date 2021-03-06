package 广度优先;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。

*
 */
public class 单词接龙_127 {
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		//去重
		HashSet<String> set = new HashSet<>(wordList);
		//不包含endWord直接返回
		if(!set.contains(endWord)) return 0;
		//定义一个HashMap(key为word,value为接龙的长度)
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put(beginWord,1);
		//定义一个队列进行BFS
		Queue<String> queue = new LinkedList<>();
		//添加开始单词进行接龙
		queue.add(beginWord);
		while(!queue.isEmpty()) {
			String word = queue.poll();
			//进行改变字母
			for(int i=0; i<word.length(); i++) {
				String newWord =word;
				for (char ch='a'; ch <='z'; ch++) {
					char[] charArray = newWord.toCharArray();
					charArray[i]=ch;//对每个位置进行从'a'->'z'改变
					newWord=String.valueOf(charArray);
					//endWord==newWord 并且集合中有newWord
					if(set.contains(newWord) && endWord.equals(newWord)) return map.get(word)+1;
					//集合中有newWord并且map中不存在newWord,添加到map中
					if(set.contains(newWord)&&!map.containsKey(newWord)) {
						queue.add(newWord);	
					  map.put(newWord, map.get(word)+1);
					}
				}
			 }
		}
		return 0;
	}
	
	/*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	    wordList.add(beginWord);
	    int N = wordList.size();
	    int start = N - 1;
	    int end = 0;
	    while (end < N && !wordList.get(end).equals(endWord)) {
	        end++;
	    }
	    if (end == N) {
	        return 0;
	    }
	    List<Integer>[] graphic = buildGraphic(wordList);
	    return getShortestPath(graphic, start, end);
	}

	private List<Integer>[] buildGraphic(List<String> wordList) {
	    int N = wordList.size();
	    List<Integer>[] graphic = new List[N];
	    for (int i = 0; i < N; i++) {
	        graphic[i] = new ArrayList<>();
	        for (int j = 0; j < N; j++) {
	            if (isConnect(wordList.get(i), wordList.get(j))) {
	                graphic[i].add(j);
	            }
	        }
	    }
	    return graphic;
	}

	private boolean isConnect(String s1, String s2) {
	    int diffCnt = 0;
	    for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
	        if (s1.charAt(i) != s2.charAt(i)) {
	            diffCnt++;
	        }
	    }
	    return diffCnt == 1;
	}

	private int getShortestPath(List<Integer>[] graphic, int start, int end) {
	    Queue<Integer> queue = new LinkedList<>();
	    boolean[] marked = new boolean[graphic.length];
	    queue.add(start);
	    marked[start] = true;
	    int path = 1;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        path++;
	        while (size-- > 0) {
	            int cur = queue.poll();
	            for (int next : graphic[cur]) {
	                if (next == end) {
	                    return path;
	                }
	                if (marked[next]) {
	                    continue;
	                }
	                marked[next] = true;
	                queue.add(next);
	            }
	        }
	    }
	    return 0;
	}*/

}
