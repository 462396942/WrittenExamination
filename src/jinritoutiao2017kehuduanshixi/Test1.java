package jinritoutiao2017kehuduanshixi;

import java.util.*;

/**
 * ������һ���ַ�������Ҫ������ַ������� n �β�����ÿ�β��������������֣�(p, l) ��ʾ��ǰ�ַ����д��±�Ϊ p ���ַ���ʼ�ĳ���Ϊ l
 * ��һ���Ӵ�����Ҫ������Ӵ����ҷ�ת���������Ӵ�ԭ��λ�õ����󷽣������õ����ַ�����ʲô���ַ������±��Ǵ� 0 ��ʼ�ģ�����Դ������еõ�������Ϣ��
 * 
 * @author zhoucong
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			int n = sc.nextInt();
			int[][] a = new int[n][2];
			for (int i = 0; i < n; i++) {
				a[i][0] = sc.nextInt();
				a[i][1] = sc.nextInt();
			}
			String re = method(new StringBuilder(s), n, a);
			System.out.println(re);
		}
	}

	public static String method(StringBuilder s, int n, int[][] a) {
		for (int i = 0; i < n; i++) {
			StringBuilder before = new StringBuilder(s.substring(0, a[i][0] + a[i][1]));
			String cur = s.substring(a[i][0], a[i][0] + a[i][1]);
			String after = s.substring(a[i][0] + a[i][1]);
			char[] c = cur.toCharArray();
			String mid = reverse(c);
			s = before.append(mid).append(after);
		}
		return s.toString();
	}

	public static String reverse(char[] a) {
		int i = 0, j = a.length - 1;
		char temp = ' ';
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return new String(a);
	}

}
