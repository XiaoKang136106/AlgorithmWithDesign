package test;

public class 最小覆盖子串_78 {

	
	   public static String minWindow(String s, String t) {

	        
           if(t.contains(s)){
               return s;
           }
   
       int min=s.length();
       int index=0;
       for(int i=0;i<s.length();i++){
           int j=i+t.length()+1;
           while(j<s.length()&& !(s.substring(i,j).contains(t))){
               j++;
           }
           if((j-i)<min){
               min=j-i;
               index=i;
           }
       }
     StringBuilder  sb= new StringBuilder();
       for(int i=0;i<min;i++){
           sb.append(s.charAt(i+index));
       }
       return sb.toString();
   }
	   public static void main(String[] args) {
		   String minWindow = minWindow("s","ss");
		   System.out.println(minWindow);
	}
}
