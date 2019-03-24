
package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址_93 {
/*
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

	示例:
	
	输入: "25525511135"
	输出: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
	/*
	 * 利用回溯法的思想，从字符串第一个字符开始，分别检查从当前字符开始的第1、2、3位组成的数，
	 * 若该数符合要求即小于256则加入到结果IP中，然后再从当前数的后一位置递归向后寻找。若遍历到第四个数，则判断最后几位组成的数是否满足要求，符合则加入到最后的集合中。
	 * 注意当遇到当前数的起始位是0时，仅将0加入到字符串中就停止当前数的寻找，因为以‘0’开头的任何字符串转化成的数都会去掉前面的‘0’
	 */
/*	private List<String> ret;

	public List<String> restoreIpAddresses(String s) {
	    ret = new ArrayList<>();
	    doRestore(0, "", s);
	    return ret;
	}

	private void doRestore(int k, String path, String s) {
		//结束条件
	    if (k == 4 || s.length() == 0) {
	        if (k == 4 && s.length() == 0) {
	            ret.add(path);
	        }
	        return;
	    }
	    //IP地址的长度不能大于3
	    for (int i = 0; i < s.length() && i <= 2; i++) {
	     //i大于0并且开头的索引为0
	    	if (i != 0 && s.charAt(0) == '0') break;
	        String part = s.substring(0, i + 1);
	        if (Integer.valueOf(part) <= 255) {
	            doRestore(k + 1, path.length() != 0 ? path + "." + part : part, s.substring(i + 1));
	        }
	    }
	
	public static void main(String[] args) {
		复原IP地址_93 s = new 复原IP地址_93();
		s.restoreIpAddresses("25525511135");
	}*/
	
	//解法二:
	public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s.length()<4)
            return ret;

        findIp("",s,0,ret,0);
        return ret;

    }

    private void findIp(String strr, String s, int offset, List<String> ret,int i)
    {
    	//strr为每一个每个IP段,  i为每个点起始的位置,offset为偏移量
        System.out.println(strr);
        //大于或者等于4
        if(offset>=4)
        {	//刚刚为加上3个.的长度
            if(strr.length() == (s.length()+3))
            {
            	//添加
                ret.add(strr);
                return;
            }
            else
            {
                return;
            }
        }
        //开始遍历,最多3次
        for(int j = 1;j<=3;j++)
        {
            if(i+j<=s.length()&&Integer.parseInt(s.substring(i,i+j))<256&&String.valueOf(Integer.parseInt(s.substring(i,i+j))).equals(s.substring(i,i+j))) {

                    if (strr.length() == 0)
                        findIp(strr + s.substring(i, i + j), s, offset + 1, ret, i + j);
                    else
                        findIp(strr + "." + s.substring(i, i + j), s, offset + 1, ret, i + j);

            }
        }
    }
    public static void main(String[] args) {
		复原IP地址_93 s = new 复原IP地址_93();
		s.restoreIpAddresses("25525511135");
	}
}
