package wanyi2017neitui;

import java.util.*;

/**
 * ţţ����ҵ������һ������Ϊ n ������ A��������а����˴�1��n��n������������ΪһЩԭ��������һЩλ��
 * �������� 10�����������ˣ�����ţţ�ǵ��������˳��Ե������� k��˳�����ָ���� i < j �� A[i] < A[j]
 * �Ķ����������ţţ��������������Ҫ��ĺϷ����е���Ŀ��
 * 
 * ������ȣ����԰�  �о�acmû�׿� ��΢�����
 * @author zhoucong
 *
 */
public class Test7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			method(a, n, k);
			System.out.println(num);
		}
	}

	// ��ʾ�ո�Ԫ�ص��±�
	static int[] index;
	// ��ʾʣ�������(�����ٸ��������г���)
	static int[] left;
	// ��ʾʣ�µ������Ƿ񱻷���
	static boolean[] vi;
	static int num = 0;

	public static void method(int[] a, int n, int k) {
		// ͳ��һ��0����
		int c = 0;
		for (int i : a) {
			if (i == 0)
				c++;
		}
		index = new int[c];
		left = new int[c];
		vi = new boolean[c];
		int idx = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] == 0)
				index[idx++] = i;
		}
		idx = 0;

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++)
			set.add(a[i]);
		for (int i = 1; i <= n; i++) {
			if (!set.contains(i))
				left[idx++] = i;
		}
		// ��ʼ˳��Ը���
		int bk = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] < a[j] && a[i] != 0)
					bk++;
			}
		}
		dfs(a, c, bk, k);
	}

	public static void dfs(int[] a, int n, int bk, int k) {
		if (n == 0) {
			if (bk == k)
				num++;
			return;
		}
		for (int i = 0; i < left.length; i++) {
			if (!vi[i]) {
				vi[i] = true;
				a[index[n - 1]] = left[i];
				int cur = 0;
				for (int j = 0; j < a.length; j++) {
					if (a[j] < left[i] && a[j] != 0 && j < index[n - 1])
						cur++;
					if (left[i] < a[j] && j > index[n - 1])
						cur++;
				}
				dfs(a, n - 1, bk + cur, k);
				vi[i] = false;
				a[index[n - 1]] = 0;
			}
		}
	}
}
