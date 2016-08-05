package tengxun2017shixi;

import java.util.Scanner;

/**
 * ����һ���ַ���s������Դ���ɾ��һЩ�ַ���ʹ��ʣ�µĴ���һ�����Ĵ������ɾ������ʹ�û��Ĵ���أ� �����Ҫɾ�����ַ�������
 *
 * �ַ�����������򳣼��ַ����㷨���룬����˼��ԭ�͡����籾�������������Ӵ�Ϊ˼��ԭ��
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
