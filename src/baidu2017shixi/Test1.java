package baidu2017shixi;

import java.util.*;

/**
 * ��ķ�տ�ʼѧϰӢ�ĵ��ʣ��Ե�������ܸ���Ȥ��
 * �������ķһ�鵥�ʣ����ܹ�Ѹ��ȷ���Ƿ���Խ���Щ����������һ���б��У�ʹ�ø��б����κε��ʵ�����ĸ��ǰһ���ʵ�Ϊ��ĸ��ͬ��
 * ���ܱ�дһ��������������ķ�����ж���
 * 
 * 
 * @author zc
 *
 */
public class Test1 {

	public static void main(String[] args) {
		method();
	}

	public static void method() {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNextInt()) {
				int n = sc.nextInt();
				String[] a = new String[n];
				for (int i = 0; i < n; i++)
					a[i] = sc.next();
				String re = method(a);
				System.out.println(re);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String method(String[] a) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		// �������׷���map��
		for (String s : a) {
			char c = s.charAt(0);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		boolean flag = false; // ��β������һ���ַ��޷���Ӧ���������׺ͽ���β
		for (String s : a) {
			char c = s.charAt(s.length() - 1);
			if (!map.containsKey(c) || map.get(c) == 0) {
				if (!flag)
					flag = true;
				else
					return "No";
			} else {
				map.put(c, map.get(c) - 1);
			}
		}
		return "Yes";

	}
}