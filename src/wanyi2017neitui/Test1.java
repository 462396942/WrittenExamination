package wanyi2017neitui;

import java.util.*;

/**
 * 有 n 个学生站成一排，每个学生有一个能力值， 牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 * 要求相邻两个学生的位置编号的差不超过 d， 使得这
 * k个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * 
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
			int max = 0;
			for (int i = 0; i < n; i++) {
				if(a.length - i < k)
					break;
				max = Math.max(max, method(a, i, k, d, true));
			}
			System.out.println(max);
		}
	}

	// 以start为起点的最大值或最小值  flag为true表示求最大值
	public static int method(int[] a, int start, int k, int d, boolean flag) {
		if (k == 1)
			return a[start];

		//取后面的最大值
		int m = 0;
		if(a[start] > 0 && flag || a[start] < 0 && !flag){
			m = Integer.MIN_VALUE;
			for(int i=start;i<=start+d;i++){
				if(a.length - i < k)
					break;
				int cur = method(a,i+1,k-1,d,true);
				m = Math.max(cur, m);
			}
		}
		//取后面的最小值
		else{
			m = Integer.MAX_VALUE;
			for(int i=start;i<=start+d;i++){
				if(a.length - i < k)
					break;
				int cur = method(a, i+1, k-1, d, false);
				m = Math.min(cur, m);
			}
		}
		return a[start]*m;
	}
}
