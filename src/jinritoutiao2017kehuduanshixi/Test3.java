package jinritoutiao2017kehuduanshixi;

import java.util.*;

/**
 * ���� n ���ַ���������ÿ�� n ������ p�������и�����˳��(p[0] , p[1] �� p[n-1])���������� n
 * ���ַ������ܵõ�һ������Ϊ��Щ�ַ�������֮�͵��ַ��������԰����������һ���������� n! ���ַ����� һ���ַ�����Ȩֵ���ڰ�����ַ���ѭ������ i
 * �κ�õ����ַ����Ժ�ԭ�ַ���ȫ�ȵ�������i ��ȡֵΪ [1 , �ַ�������]������Щ�ַ���������ɵ� n! ���ַ�����ȨֵΪ K ���ж��ٸ���
 * ע�������һ����ѭ������ 1 �εȼ��ڰ�������ĵ�һ���ַ��ƶ������һ���ַ��ĺ��档
 * 
 * ���г�ʱ gg
 * @author zhoucong
 *
 */
public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int K = sc.nextInt();
			String[] a = new String[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.next();
			int re = method(n, K, a);
			System.out.println(re);
		}
	}

	static List<List<Integer>> list = new ArrayList<List<Integer>>();

	public static int method(int n, int K, String[] s) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = i;
		pailie(a, 0, n - 1);
		int sum = 0;
		int re = 0;
		for (List<Integer> l : list) {
			StringBuilder sb = new StringBuilder();
			for (int i : l)
				sb.append(s[i]);
			for (int i = 1; i <= sb.length(); i++) {
				String before = sb.substring(0, i);
				String after = sb.substring(i);
				if ((after + before).equals(sb.toString()))
					sum++;
				if (sum > K)
					break;
			}
			if (sum == K)
				re++;
			sum = 0;
		}
		return re;
	}

	public static void pailie(int[] a, int s, int e) {
		if (s == e) {
			List<Integer> l = new ArrayList<Integer>();
			for (int i : a)
				l.add(i);
			list.add(l);
			return;
		}
		for (int i = s; i <= e; i++) {
			swap(a, s, i);
			pailie(a, s + 1, e);
			swap(a, s, i);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
