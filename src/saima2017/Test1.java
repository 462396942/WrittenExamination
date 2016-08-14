package saima2017;

import java.util.*;

/**
 * ����СB������������M��N�������ǵݼ�˳�����С� ���Թٵ��������ܷ������M���ҵ�p������Ԫ�ع���һ�������У�
 * ͬʱ������N���ҵ�q������Ԫ�ع�����һ�������У�ʹ����������������
 *  p��Ԫ���е��κ�һ��Ԫ�ؾ�С��q��Ԫ���е��κ�һ���� СB�����æ��������д�������
 * 
 * @author zhoucong
 *
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			int[] a = new int[n1];
			int[] b = new int[n2];
			for (int i = 0; i < n1; i++)
				a[i] = sc.nextInt();
			for (int i = 0; i < n2; i++)
				b[i] = sc.nextInt();
			method(a, b, p, q);
		}
	}

	public static void method(int[] a, int[] b, int p, int q) {
		int aMax = Integer.MIN_VALUE;
		for (int i = 0; i < p; i++) {
			if (a[i] > aMax)
				aMax = a[i];
		}
		int bMin = Integer.MAX_VALUE;
		for (int i = b.length - 1; i >= b.length - q; i--) {
			if (b[i] < bMin)
				bMin = b[i];
		}
		if (aMax < bMin)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
