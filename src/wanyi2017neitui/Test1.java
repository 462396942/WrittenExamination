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
			int max = method(a,n,k,d);
			System.out.println(max);
		}
	}
	public static int method(int[] a,int n,int k,int d){
		//��ʾ��a[n-1]Ϊ��β������������k���������˻�
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
