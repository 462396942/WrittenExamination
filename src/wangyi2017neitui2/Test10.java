package wangyi2017neitui2;

import java.util.*;

/**
 * С����������һ��������Ϸ��С�׸���һϵ�е�������������ʹ����Щ��������Ϸ��ÿ��С�׻�����˵һ�����ֳ�����
 * Ȼ������Ҫ����һϵ��������ѡȡһ���ֳ��������ǵĺ͵���С����˵�����֡� ���磺
 * ���{2,1,2,7}�����е�һϵ������С��˵��������11.����Եõ�����2+2+7 =
 * 11.�����Ƥ��С������㣬��˵��������6����ô��û�а취ƴ�ճ���Ϊ6 ����С�׸���n�����������ҳ��޷���n������ѡȡ������͵������е���С����
 * 
 * ��ô˵�أ�ʵ�ּ��������
 * @author zhoucong
 *
 */
public class Test10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			int re = method(a, n);
			System.out.println(re);
		}
	}

	public static int method(int[] a, int n) {
		List<Integer> l = new ArrayList<Integer>();
		Set<Integer> s = new HashSet<Integer>();
		l.add(0);
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			//�˴�������Ĺؼ�
			int len = l.size();
			for (int j = 0; j < len; j++) {
				int sum = a[i] + l.get(j);
				if (s.contains(sum))
					continue;
				l.add(sum);
				s.add(sum);
				if (l.get(l.size() - 1) != l.size() - 1)
					return l.size() - 1;
			}
		}
		return l.size();
	}

}
