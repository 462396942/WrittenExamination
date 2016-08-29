package jinritoutiao2017kehuduanshixi;

import java.util.*;

/**
 * 给出 n 个字符串，对于每个 n 个排列 p，按排列给出的顺序(p[0] , p[1] … p[n-1])依次连接这 n
 * 个字符串都能得到一个长度为这些字符串长度之和的字符串。所以按照这个方法一共可以生成 n! 个字符串。 一个字符串的权值等于把这个字符串循环左移 i
 * 次后得到的字符串仍和原字符串全等的数量，i 的取值为 [1 , 字符串长度]。求这些字符串最后生成的 n! 个字符串中权值为 K 的有多少个。
 * 注：定义把一个串循环左移 1 次等价于把这个串的第一个字符移动到最后一个字符的后面。
 * 
 * 运行超时 gg
 * @author zhoucong
 *
 */
public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int K = sc.nextInt();
			String[] a = new String[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.next();
			int re = method(n, K, a);
			System.out.println(re);
		}
	}

	static List<List<Integer>> list = new ArrayList<List<Integer>>();

	public static int method(int n, int K, String[] s) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = i;
		pailie(a, 0, n - 1);
		int sum = 0;
		int re = 0;
		for (List<Integer> l : list) {
			StringBuilder sb = new StringBuilder();
			for (int i : l)
				sb.append(s[i]);
			for (int i = 1; i <= sb.length(); i++) {
				String before = sb.substring(0, i);
				String after = sb.substring(i);
				if ((after + before).equals(sb.toString()))
					sum++;
				if (sum > K)
					break;
			}
			if (sum == K)
				re++;
			sum = 0;
		}
		return re;
	}

	public static void pailie(int[] a, int s, int e) {
		if (s == e) {
			List<Integer> l = new ArrayList<Integer>();
			for (int i : a)
				l.add(i);
			list.add(l);
			return;
		}
		for (int i = s; i <= e; i++) {
			swap(a, s, i);
			pailie(a, s + 1, e);
			swap(a, s, i);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
