package 剑指offer;

public class _53表示数值的字符串 {
	/*
	 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
	 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
	 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
	 * 
	 */
	// 思路：逐个字符进行判断，e或E和小数点最多出现一次(无法共存)，而e或E的前一个必须是数字，且不能是第一个或最后一个字符，
	// 符号的前一个字符不能是e或E。也可用正则表达式判断！
	/*
	 * 思路:定义ecount 和 pcount  先判断第一个数是否为'-' 或者'+',遍历str
	 * 后面的数字判断'-'或者'+'的前面是否为'e或者'E',
	 * 判断e/E出现的次数,出现一次eCount 和pCount 都要+1,判断eCount >1 -> false,判断e的位置是否合法(不能为首尾,前面必须是数字) ,不满足false,都满足continue

	 *  判断'.'出现的次数,eCount>1,false否则continue继续遍历
	 *  判断是否合法(为数字<48~57,e,E>)
	 *  
	 */
	/*public boolean isNumeric(char[] str) {
		if (str == null)
			return false;
		int index = 0;
		int ecount = 0;
		int pcount = 0;
		//如果第一个字符是符号就跳过
		if (str[0] == '-' || str[0] == '+')
			index++;
			
		for (int i = index; i < str.length; i++) {
			if (str[i] == '-' || str[i] == '+') {
				if (str[i - 1] != 'e' && str[i - 1] != 'E')
					return false;
				continue;
			}
			if (str[i] == 'e' || str[i] == 'E') {
				ecount++;
				if (ecount > 1)
					return false;
				if (i == 0 || str[i - 1] < 48 || str[i - 1] > 57 || i == str.length - 1)

					return false;
				pcount++;
				continue;
			}
			if (str[i] == '.') {
				pcount++;
				if (pcount > 1)
					return false;
				continue;
			}
			// 出现非数字且不是e/E则返回false（小数点和符号用continue跳过了）
			if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e') && (str[i] != 'E'))
				return false;
		}
		return true;
	}
*/
		public boolean isNumeric(char[] str) {
			  if(str ==null)
				return false;
			 int ecount=0; //e的个数
			 int pcount=0; //p的个数
			 int index =0; //首字母是否为正负
			 //判断第一个位置是否为-|+
			 if(str[0] =='-' || str[0] =='+')
				 index =1;
			 for (int i = index; i < str.length; i++) {
				 //数组中后面的位置出现了正负前面必须为e,E
				if(str[i] == '-' || str[i] == '+') {
					if (str[i-1] != 'e' && str[i-1] != 'E') {
						return false;
					}
					continue;
				}
				//判断存在几个e|E
				if( str[i] =='e' || str[i] =='E' ) {
					ecount++;
					if(ecount>1)
						return false;
					//判断e的前后条件
					if(i==0 || i==str.length-1 ||str[i-1] <48 ||str[i-1] >57)
						return false;
					//存在e或者E就不能有小数
					pcount++;
					continue;
				}
				//判断是否存在小数
				if(str[i] =='.') {
					pcount++;
					if(pcount >1)
						return false;
					continue;
				}
				// 出现非数字且不是e/E(因为前面是根据e/E来判断的,可能前面出现了E,后面有e)则返回false（小数点和符号用continue跳过了）
				if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e') && (str[i] != 'E'))
					return false;
			}
			 return true;
	}
}
