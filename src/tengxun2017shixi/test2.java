package tengxun2017shixi;

import java.util.*;

/**
 * СQ���������һ�����⣺��һ���ַ����Ĵ�д��ĸ�ŵ��ַ����ĺ��棬�����ַ������λ�ò��䣬�Ҳ����������Ŀռ䡣 ���ܰ��СQ��
 *
 * ˼��ԭ�ͣ���������
 * 
 * @author zc
 *
 */
public class test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			String re = method(s);
			System.out.println(re);
		}
	}

	public static String method(String s) {
		char[] ch = s.toCharArray();
		int j = 0;
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLowerCase(ch[i])) {
				char temp = ch[i];
				j = i - 1;
				while (j >= 0 && Character.isUpperCase(ch[j])) {
					ch[j + 1] = ch[j];
					j--;
				}
				ch[j + 1] = temp;
			}
		}
		return new String(ch);
	}
}