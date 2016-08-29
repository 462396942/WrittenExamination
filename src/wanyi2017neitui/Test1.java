package wanyi2017neitui;

import java.util.*;

/**
 * �� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ�� ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ���� Ҫ����������ѧ����λ�ñ�ŵĲ���� d�� ʹ����
 * k��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
 * 
 * ��̬�滮˼�룺��Ҫ����׼״̬ת�Ʒ��̣�
 * ע�⣺��һ��dp[n][k]�������ս⣡�����ǿ�����re���������ֵ
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
		// max[i][j]��ʾ��i+1��ѧ��Ϊ��β��j+1��ѧ���������˻�
		long[][] max = new long[n][k];
		// min[i][j]��ʾ��i+1��ѧ��Ϊ��β��j+1��ѧ��������С�˻�
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
