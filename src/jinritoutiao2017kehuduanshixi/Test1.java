package jinritoutiao2017kehuduanshixi;

import java.util.*;

/**
 * 现在有一个字符串，你要对这个字符串进行 n 次操作，每次操作给出两个数字：(p, l) 表示当前字符串中从下标为 p 的字符开始的长度为 l
 * 的一个子串。你要将这个子串左右翻转后插在这个子串原来位置的正后方，求最后得到的字符串是什么。字符串的下标是从 0 开始的，你可以从样例中得到更多信息。
 * 
 * @author zhoucong
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			int n = sc.nextInt();
			int[][] a = new int[n][2];
			for (int i = 0; i < n; i++) {
				a[i][0] = sc.nextInt();
				a[i][1] = sc.nextInt();
			}
			String re = method(new StringBuilder(s), n, a);
			System.out.println(re);
		}
	}

	public static String method(StringBuilder s, int n, int[][] a) {
		for (int i = 0; i < n; i++) {
			StringBuilder before = new StringBuilder(s.substring(0, a[i][0] + a[i][1]));
			String cur = s.substring(a[i][0], a[i][0] + a[i][1]);
			String after = s.substring(a[i][0] + a[i][1]);
			char[] c = cur.toCharArray();
			String mid = reverse(c);
			s = before.append(mid).append(after);
		}
		return s.toString();
	}

	public static String reverse(char[] a) {
		int i = 0, j = a.length - 1;
		char temp = ' ';
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return new String(a);
	}

}
