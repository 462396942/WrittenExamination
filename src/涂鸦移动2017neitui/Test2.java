package Ϳѻ�ƶ�2017neitui;

import java.util.*;

/**
 * ��һ�������� n, �ҵ����ɸ���ȫƽ����(����1, 4, 9, ... )ʹ�����ǵĺ͵��� n�� ����Ҫ��ƽ�����ĸ������١�
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
	 * ����˼·�ҵ���sqrt(n)С�������j����j��ʼö���������
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
