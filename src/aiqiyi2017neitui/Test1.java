package aiqiyi2017neitui;

import java.util.*;

/**
 * 01背包问题 此解法非常好！！类似硬币问题
 * 
 * @author zhoucong
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNextInt()) {
			int weight = s.nextInt();
			int num = s.nextInt();
			int w[] = new int[num];
			int v[] = new int[num];
			for (int i = 0; i < num; i++) {
				w[i] = s.nextInt();
			}
			for (int i = 0; i < num; i++) {
				v[i] = s.nextInt();
			}
			method(weight, num, w, v);
		}
	}

	public static void method(int weight, int num, int w[], int v[]) {
		int dp[] = new int[weight + 1];
		for (int i = 0; i < num; i++) {
			for (int j = weight; j >= w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
		System.out.println(dp[weight] * 0.1);
	}
}
