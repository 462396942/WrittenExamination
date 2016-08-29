package wangyi2017neitui2;

import java.util.*;

/**
 * С��ϲ���ĵ��ʾ����������ԣ� 1.����ÿ����ĸ���Ǵ�д��ĸ 2.����û��������ȵ���ĸ
 * 3.����û�����硰xyxy��(�����x��yָ�Ķ�����ĸ�����ҿ�����ͬ)�����������У������п��ܲ������� ���磺
 * С�ײ�ϲ��"ABBA"����Ϊ����������������'B' С�ײ�ϲ��"THETXH"����Ϊ�������������"THTH"
 * С�ײ�ϲ��"ABACADA"����Ϊ�������������"AAAA" С��ϲ��"A","ABA"��"ABCBA"��Щ����
 * ����һ�����ʣ���Ҫ�ش�С���Ƿ��ϲ��������ʡ�
 * 
 * 
 * ��������㷨ʵ�ּ����⣬���ǿ���ʱ���ܲ����뵽�ˣ����Ի��������Ӷ�ģ��
 * @author zhoucong
 *
 */
public class Test8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			String re = method(s);
			System.out.println(re);
		}
	}

	public static String method(String s) {
		char[] a = s.toCharArray();
		for (int i = 1; i < s.length(); i++) {
			if (a[i] == a[i - 1])
				return "Dislikes";
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}
		List<Character> l = new ArrayList<Character>();
		for (char c : a) {
			int times = map.get(c);
			if (times != 0 && times % 2 == 0)
				l.add(c);
			if (times % 2 != 0) {
				map.put(c, times - 1);
			}
			if (l.size() >= 2) {
				if (l.get(l.size() - 1) == l.get(l.size() - 2)) {
					l.remove(l.size() - 1);
					l.remove(l.size() - 1);
				}
			}
		}
		if (l.size() > 0)
			return "Dislikes";
		return "Likes";
	}

}
