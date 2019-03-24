package 剑指offer;

public class _54字符流中第一个不重复的字符 {
	/*
	 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
	 * 第一个只出现一次的字符是"g"。
	 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
	 * 如果当前字符流没有存在出现一次的字符，返回#字符。
	 */
	char[] chars = new char[256]; //创建一个可以存放数组位置的数组
	StringBuilder sb = new StringBuilder();
	public void Insert(char ch)
    {
		sb.append(ch);
		chars[ch]++; //
        
    }
    public char FirstAppearingOnce()
    {
    	char[] charArray = sb.toString().toCharArray();
    	for (char c : charArray) {
			if(chars[c] ==1) {
				return c;
			}
		}
    	return '#';
    }
}
