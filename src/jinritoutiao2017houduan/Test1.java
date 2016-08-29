package jinritoutiao2017houduan;

import java.util.*;

public class Test1 {
	// 是否访问
	static boolean[] vi;
	// va[i]=j表示i的字母对应值为j
	static int[] va;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			vi = new boolean[10];
			va = new int[10];
			Arrays.fill(va, -1);
			String[] a = new String[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.next();
			Set<Character> s = new HashSet<Character>();
			for (String ss : a)
				s.add(ss.charAt(0));
			try {
				dfs(a, 0, s);
				System.out.println(max);
			} catch (Exception e) {
				System.out.println(0);
			}
		}
	}

	public static void dfs(String[] a, int n, Set<Character> set) {
		if (n == 10) {
			int sum = getSum(a);
			if (sum > max)
				max = sum;
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!vi[i]) {
				vi[i] = true;
				va[n] = i;
				if (!isOk(set)) {
					vi[i] = false;
					va[n] = -1;
					continue;
				}
				dfs(a, n + 1, set);
				vi[i] = false;
				va[n] = -1;
			}
		}
	}

	public static boolean isOk(Set<Character> set) {
		for (char c : set) {
			if (va[c - 'A'] == 0)
				return false;
		}
		return true;
	}

	public static int getSum(String[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			char[] c = a[i].toCharArray();
			for (int j = 0; j < c.length; j++) {
				c[j] = (char) (va[c[j] - 'A'] + '0');
			}
			sum += Integer.parseInt(new String(c));
		}
		return sum;
	}
}
