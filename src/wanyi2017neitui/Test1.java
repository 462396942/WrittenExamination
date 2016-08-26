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
			int max = method(a,n,k,d);
			System.out.println(max);
		}
	}
	public static int method(int[] a,int n,int k,int d){
		//表示以a[n-1]为结尾的满足条件的k个数的最大乘积
		int[][] dp = new int[n][k];
		dp[0][0] = a[0];
		for(int i=0;i<n;i++){
			for(int j=0;j<k;j++){
				if(j > i)
					break;
				if(a[i] > 0)
			}
		}
	}
}
