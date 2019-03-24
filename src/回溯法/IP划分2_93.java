package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class IP划分2_93 {
	/*
	 * Given "25525511135",
		return ["255.255.11.135", "255.255.111.35"]
	 */
	private List<String> ret;
	
	public List<String> restoreIpAddresses(String s) {
	    ret = new ArrayList<>();
	    doRestore(0, "", s);
	    return ret;
	}
	//k为每一段ip的长度,path为总路径,
	private void doRestore(int k, String path, String s) {
		//结束条件
	    if (k == 4 || s.length() == 0) {
	    	//添加结果
	        if (k == 4 && s.length() == 0) {
	            ret.add(path);
	        }
	        return;
	    }
	    for (int i = 0; i < s.length() && i <= 2; i++) {
	    	//每一段IP地址开头不能为0
	        if (i != 0 && s.charAt(0) == '0') break;
	        //
	        String part = s.substring(0, i + 1);
	        if (Integer.valueOf(part) <= 255) {
	            doRestore(k + 1, path.length() != 0 ? path + "." + part : part, s.substring(i + 1));
	        }
	    }
	}

}
