package wanyi2017neitui;

import java.util.*;

/**
 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置
 * （不超过 10个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j]
 * 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
 * 
 * 深度优先，可以啊  感觉acm没白看 稍微会点了
 * @author zhoucong
 *
 */
public class Test7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			method(a, n, k);
			System.out.println(num);
		}
	}

	// 表示空格元素的下标
	static int[] index;
	// 表示剩余的数字(即不再给定数组中出现)
	static int[] left;
	// 表示剩下的数字是否被访问
	static boolean[] vi;
	static int num = 0;

	public static void method(int[] a, int n, int k) {
		// 统计一下0数量
		int c = 0;
		for (int i : a) {
			if (i == 0)
				c++;
		}
		index = new int[c];
		left = new int[c];
		vi = new boolean[c];
		int idx = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] == 0)
				index[idx++] = i;
		}
		idx = 0;

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++)
			set.add(a[i]);
		for (int i = 1; i <= n; i++) {
			if (!set.contains(i))
				left[idx++] = i;
		}
		// 初始顺序对个数
		int bk = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] < a[j] && a[i] != 0)
					bk++;
			}
		}
		dfs(a, c, bk, k);
	}

	public static void dfs(int[] a, int n, int bk, int k) {
		if (n == 0) {
			if (bk == k)
				num++;
			return;
		}
		for (int i = 0; i < left.length; i++) {
			if (!vi[i]) {
				vi[i] = true;
				a[index[n - 1]] = left[i];
				int cur = 0;
				for (int j = 0; j < a.length; j++) {
					if (a[j] < left[i] && a[j] != 0 && j < index[n - 1])
						cur++;
					if (left[i] < a[j] && j > index[n - 1])
						cur++;
				}
				dfs(a, n - 1, bk + cur, k);
				vi[i] = false;
				a[index[n - 1]] = 0;
			}
		}
	}
}
