package wanyi2017neitui;

import java.util.*;

/**
 * 牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，
 * 机关每次会显示两个字符串 s 和 t，根据古老的传说，牛牛需要每次都回答t 是否是 s 的子序列。
 * 注意，子序列不要求在原字符串中是连续的，
 * 例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc,
 * abc} 8 种。
 * 
 * @author zhoucong
 *
 */
public class Test6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			String re = method(s1, s2);
			System.out.println(re);
		}
	}

	public static String method(String s1, String s2) {
		int j = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(j))
				j++;
			if (j == s2.length())
				return "Yes";
		}
		return "No";
	}

}
