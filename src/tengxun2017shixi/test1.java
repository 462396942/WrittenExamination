package tengxun2017shixi;

import java.util.Scanner;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？ 输出需要删除的字符个数。
 *
 * 字符串问题可以向常见字符串算法上想，构建思想原型。比如本题可以以最长公共子串为思想原型
 * 
 * @author zc
 *
 */
public class test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String a = sc.next();
			int i = method(a);
			System.out.println(i);
		}
	}

	public static int method(String a) {
		String b = reverse(a);
		int len = a.length();
		int[][] dp = new int[len + 1][len + 1];
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j <= len; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else {
					if (a.charAt(i - 1) == b.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1] + 1;
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return len - dp[len][len];
	}

	public static String reverse(String a) {
		StringBuilder sb = new StringBuilder();
		int len = a.length();
		for (int i = len - 1; i >= 0; i--) {
			sb.append(a.charAt(i));
		}
		return sb.toString();
	}

}
