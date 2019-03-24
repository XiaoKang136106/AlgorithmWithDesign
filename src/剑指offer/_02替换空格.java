package 剑指offer;

public class _02替换空格 {
	/*
	 * 替换空格
	 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
	 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 */
	 //思路:使用String.equals()方法进行查找空格,在利用sb的append()方法对其进行构造一个新函数
	public String replaceSpace(StringBuffer str) {
	       if(str ==null){
	        return null;
	       }
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<str.length();i++){
	            //需要先将char转换成Str才能使用equals()方法
	           if(String.valueOf(str.charAt(i)).equals(" ")){
	               sb.append("%20");
	           } else{
	                    sb.append(str.charAt(i));
	           }

	            
	       
	        }
	        
	    	return new String(sb);
	    }

}
