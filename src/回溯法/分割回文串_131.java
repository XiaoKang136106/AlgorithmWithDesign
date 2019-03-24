package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串_131 {
	/**
	 * 
	 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

		返回 s 所有可能的分割方案。
		
		示例:
		
		输入: "aab"
		输出:
		[
		  ["aa","b"],
		  ["a","a","b"]
		]
	 * 
	 */
/*	
	private List<List<String>> ret;

	public List<List<String>> partition(String s) {
	    ret = new ArrayList<>(); //创建一个数组
	    doPartion(new ArrayList<>(), s);
	    return ret;
	}
	
	private void doPartion(List<String> list, String s) {
	    //终止条件
		if (s.length() == 0) {
	        ret.add(new ArrayList<>(list));
	        return;
	    }
	    for (int i = 0; i < s.length(); i++) {
	    	//判断是否为回文
	    	if (isPalindrome(s, 0, i)) {
	            list.add(s.substring(0, i + 1));
	            doPartion(list, s.substring(i + 1));
	            list.remove(list.size() - 1);
	        }
	    }
	}

	private boolean isPalindrome(String s, int begin, int end) {
	    while (begin < end) {
	        if (s.charAt(begin++) != s.charAt(end--)) return false;
	    }
	    return true;
	}*/
public List<List<String>> partition(String s) {
        
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        
        doPartition(list,s,ret);
        return ret;
    }
    
    public void doPartition(List<String> list,String s,List<List<String>> ret){
        //终止条件
        if(s.length()==0){
            ret.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i=0;i<s.length();i++){
            //判断是否为回文
            if(isPartition(s,0,i)){
           
                list.add(s.substring(0,i+1));
                //进行递归
                doPartition(list,s.substring(i+1),ret);
                list.remove(list.size()-1);
            }
        }
        
    }
    public boolean isPartition(String s,int start,int end){
        while(end > start){
            
            if(s.charAt(start++)!= s.charAt(end--)) return false;
            
        }
        return true;
        
    }

}
