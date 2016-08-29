package wangyi2017neitui2;

import java.util.*;

/**
 * Fibonacci��������������ģ� F[0] = 0 F[1] = 1 for each i �� 2: F[i] = F[i-1] + F[i-2]
 * ��ˣ�Fibonacci���о����磺0, 1, 1, 2, 3, 5, 8, 13,
 * ...����Fibonacci�����е������ǳ�ΪFibonacci��������һ��N�����������Ϊһ��Fibonacci����ÿһ������԰ѵ�ǰ����X��ΪX-
 * 1����X+1�����ڸ���һ����N��������Ҫ���ٲ����Ա�ΪFibonacci����
 * 
 * ���������һ����СΪ2��������쳲�������
 * @author zhoucong
 *
 */
public class Test9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int re = method(n);
			System.out.println(re);
		}
	}

	public static int method(int n) {
		int[] a = new int[2];
		a[0] = 0;
		a[1] = 1;
		while (true) {
			int i = a[0] + a[1];
			a[0] = a[1];
			a[1] = i;
			if (a[1] > n)
				break;
		}
		return Math.min(a[1] - n, n - a[0]);
	}

}
