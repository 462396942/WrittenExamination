package wangyi2017neitui2;

import java.util.*;

/**
 * ������n���ַ����ַ��������������ַ������ȶ��ǲ�ͬ�ġ��������ѧϰ���������ַ��������򷽷��� 1.�����ַ������ֵ����������磺 "car" <
 * "carriage" < "cats" < "doggies < "koala" 2.�����ַ����ĳ����������磺 "car" < "cats" <
 * "koala" < "doggies" < "carriage"
 * ������֪���Լ�����Щ�ַ�������˳���Ƿ��������������򷽷�������Ҫæ�ų���Ҷ��������Ҫ������æ��֤��
 * 
 * @author zhoucong
 *
 */
public class Test7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			String[] a = new String[n];
			for (int i = 0; i < n; i++)
				// �˴���nextLine�ᱨ�������Ƿ��������Խ��Ƿ����ʵ������,ԭ����
				a[i] = sc.next();
			String re = null;
			if (isLen(a) && isLarge(a))
				re = "both";
			else if (isLen(a))
				re = "lengths";
			else if (isLarge(a))
				re = "lexicographically";
			else
				re = "none";
			System.out.println(re);
		}
	}

	public static boolean isLarge(String[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(a[i - 1]) < 0)
				return false;
		}
		return true;
	}

	public static boolean isLen(String[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i].length() < a[i - 1].length())
				return false;
		}
		return true;
	}
}
