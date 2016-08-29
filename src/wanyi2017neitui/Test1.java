package wanyi2017neitui;

import java.util.*;

/**
 * 有 n 个学生站成一排，每个学生有一个能力值， 牛牛想从这 n 个学生中按照顺序选取 k 名学生， 要求相邻两个学生的位置编号的差不超过 d， 使得这
 * k个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * 
 * 动态规划思想：主要是找准状态转移方程，
 * 注意：不一定dp[n][k]就是最终解！！我们可以用re变量求最大值
 * @author zhoucong
 *
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			int d = sc.nextInt();
			long max = method(a, n, k, d);
			System.out.println(max);
		}
	}

	public static long method(int[] a, int n, int k, int d) {
		// max[i][j]表示以i+1号学生为结尾的j+1个学生能力最大乘积
		long[][] max = new long[n][k];
		// min[i][j]表示以i+1号学生为结尾的j+1个学生能力最小乘积
		long[][] min = new long[n][k];
		long re = Integer.MIN_VALUE;
		max[0][0] = a[0];
		min[0][0] = a[0];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if (j == 0) {
					max[i][j] = a[i];
					min[i][j] = a[i];
				} else {
					max[i][j] = Integer.MIN_VALUE;
					min[i][j] = Integer.MAX_VALUE;
					for (int l = 1; l <= d; l++) {
						if (i - l < j - 1)
							break;
						max[i][j] = Math.max(max[i][j], Math.max(max[i - l][j - 1] * a[i], min[i - l][j - 1] * a[i]));
						min[i][j] = Math.min(min[i][j], Math.min(max[i - l][j - 1] * a[i], min[i - l][j - 1] * a[i]));
					}
				}
				if (max[i][j] > re)
					re = max[i][j];
			}
		}
		return re;
	}
}
