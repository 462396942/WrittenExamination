package wanyi2017neitui;

import java.util.*;

/**
 * �� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ�� ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ����
 * Ҫ����������ѧ����λ�ñ�ŵĲ���� d�� ʹ����
 * k��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
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

	// ��startΪ�������ֵ����Сֵ  flagΪtrue��ʾ�����ֵ
	public static int method(int[] a, int start, int k, int d, boolean flag) {
		if (k == 1)
			return a[start];

		//ȡ��������ֵ
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
		//ȡ�������Сֵ
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
