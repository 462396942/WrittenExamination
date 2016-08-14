package saima2017;

import java.util.*;

/**
 * 给了小B两个整数序列M和N，均按非递减顺序排列。 面试官的问题是能否从序列M中找到p个连续元素构成一个子序列，
 * 同时从序列N中找到q个连续元素构成另一个子序列，使得它们满足条件：
 *  p个元素中的任何一个元素均小于q个元素中的任何一个？ 小B请你帮忙分析并编写这个程序。
 * 
 * @author zhoucong
 *
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			int[] a = new int[n1];
			int[] b = new int[n2];
			for (int i = 0; i < n1; i++)
				a[i] = sc.nextInt();
			for (int i = 0; i < n2; i++)
				b[i] = sc.nextInt();
			method(a, b, p, q);
		}
	}

	public static void method(int[] a, int[] b, int p, int q) {
		int aMax = Integer.MIN_VALUE;
		for (int i = 0; i < p; i++) {
			if (a[i] > aMax)
				aMax = a[i];
		}
		int bMin = Integer.MAX_VALUE;
		for (int i = b.length - 1; i >= b.length - q; i--) {
			if (b[i] < bMin)
				bMin = b[i];
		}
		if (aMax < bMin)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
