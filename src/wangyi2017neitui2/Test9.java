package wangyi2017neitui2;

import java.util.*;

/**
 * Fibonacci数列是这样定义的： F[0] = 0 F[1] = 1 for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13,
 * ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-
 * 1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 * 
 * 这里可以用一个大小为2的数组求斐波那契数
 * @author zhoucong
 *
 */
public class Test9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int re = method(n);
			System.out.println(re);
		}
	}

	public static int method(int n) {
		int[] a = new int[2];
		a[0] = 0;
		a[1] = 1;
		while (true) {
			int i = a[0] + a[1];
			a[0] = a[1];
			a[1] = i;
			if (a[1] > n)
				break;
		}
		return Math.min(a[1] - n, n - a[0]);
	}

}
