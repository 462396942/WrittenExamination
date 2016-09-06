package 涂鸦移动2017neitui;

import java.util.*;

/**
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。 你需要让平方数的个数最少。
 * 
 * @author zhoucong
 *
 */
public class Test2 {
	public static void main(String[] args) {
		Test2 t = new Test2();
		System.out.println(t.method(5));
	}

	/**
	 * 整体思路找到比sqrt(n)小的最大数j，从j开始枚举所有情况
	 * @param n
	 * @return
	 */
	public int method(int n) {
		if (n == 0)
			return 1;
		int sq = (int) Math.sqrt(n);
		int j = sq;
		int cur = 0, min = Integer.MAX_VALUE;
		int curSum = 0;
		while (j > 0) {
			int i=j;
			while (curSum != n) {
				if (curSum < n) {
					curSum += i * i;
					cur++;
				} else {
					curSum -= i * i;
					i--;
					curSum += i * i;
				}
			}
			if (cur < min)
				min = cur;
			curSum = 0;
			cur = 0;
			j--;
		}
		return  min;
	}
}
