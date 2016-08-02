package tengxun2017shixi;

import java.util.*;

/**
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。 你能帮帮小Q吗？
 *
 * 思想原型，插入排序
 * 
 * @author zc
 *
 */
public class test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			String re = method(s);
			System.out.println(re);
		}
	}

	public static String method(String s) {
		char[] ch = s.toCharArray();
		int j = 0;
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLowerCase(ch[i])) {
				char temp = ch[i];
				j = i - 1;
				while (j >= 0 && Character.isUpperCase(ch[j])) {
					ch[j + 1] = ch[j];
					j--;
				}
				ch[j + 1] = temp;
			}
		}
		return new String(ch);
	}
}