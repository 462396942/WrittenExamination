package wanyi2017neitui;

import java.util.*;

/**
 * ţţ�õ���һ���ر�ͼ��˳�Ųر�ͼ��ָʾ��ţţ������һ���ر��У��ر�������һ�����أ�
 * ����ÿ�λ���ʾ�����ַ��� s �� t�����ݹ��ϵĴ�˵��ţţ��Ҫÿ�ζ��ش�t �Ƿ��� s �������С�
 * ע�⣬�����в�Ҫ����ԭ�ַ������������ģ�
 * ���紮 abc�����������о��� {�մ�, a, b, c, ab, ac, bc,
 * abc} 8 �֡�
 * 
 * @author zhoucong
 *
 */
public class Test6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			String re = method(s1, s2);
			System.out.println(re);
		}
	}

	public static String method(String s1, String s2) {
		int j = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(j))
				j++;
			if (j == s2.length())
				return "Yes";
		}
		return "No";
	}

}
