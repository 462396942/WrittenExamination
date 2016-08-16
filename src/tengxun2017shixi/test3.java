package tengxun2017shixi;

import java.util.*;

/**
 * СQ�������ϲ���ʱ�뵽��������⣺��n������������ɶ�Ԫ�飬��ľ���ֵ��С���ж��ٶ��أ���ľ���ֵ�����أ�
 * 
 * ����ط���������ɶ�Ԫ�飬��һ�������ڵģ��������ͬԪ�صĴ���Ҳ����Ҫע��ĵط�
 * @author zc
 *
 */
public class test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			method(a);
		}
	}

	public static void method(int[] a) {
		Arrays.sort(a);

		// ������С��
		int minSub = Integer.MAX_VALUE;
		int minCount = 0;
		// �������Ƿ�����ͬԪ��
		int sameCount = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1]) {
				sameCount++;
			} else {
				minCount += (sameCount * (sameCount - 1)) / 2;
				sameCount = 1;
			}
		}
		//ע����䣬��for������if��else�ģ����һ���жϻ��߲���������Ҫ����������
		minCount += (sameCount * (sameCount - 1)) / 2;
		// û���ظ�Ԫ��
		if (minCount == 0) {

			for (int i = 1; i < a.length; i++) {
				if (a[i] - a[i - 1] < minSub) {
					minSub = a[i] - a[i - 1];
					minCount = 1;
				} else if (a[i] - a[i - 1] == minSub)
					minCount++;
			}
		}
		// ��������
		int maxCount = 0;
		if (a[0] == a[a.length - 1])
			maxCount = (a.length - 1) * a.length / 2;
		else {
			int left = 1;
			int right = 1;
			int i = 1;
			while (i < a.length && a[i] == a[i - 1]) {
				left++;
				i++;
			}
			i = a.length - 1;
			while (i >= 0 && a[i] == a[i - 1]) {
				right++;
				i--;
			}
			maxCount = left * right;
		}
		System.out.println(minCount + " " + maxCount);

	}
}
