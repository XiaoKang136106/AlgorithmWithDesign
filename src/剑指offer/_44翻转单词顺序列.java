package 剑指offer;

public class _44翻转单词顺序列 {
	
	
	/*
	 * 	。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”
	 */
	public static String ReverseSentence(String str) {
		if(str.trim().equals("")) 
			return str;
		String[] split = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = split.length-1; i >=0; i--) {
			if(i==0) {
				sb.append(split[i]);
			}else{
				sb.append(split[i]+" ");
			}
			
			
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String reverseSentence = ReverseSentence("student. a am I");
		System.out.println(reverseSentence);
	}

}
