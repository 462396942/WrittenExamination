package baidu2017shixi;

import java.util.*;

/**
 * 拉姆刚开始学习英文单词，对单词排序很感兴趣。
 * 如果给拉姆一组单词，他能够迅速确定是否可以将这些单词排列在一个列表中，使得该列表中任何单词的首字母与前一单词的为字母相同。
 * 你能编写一个程序来帮助拉姆进行判断吗？
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
		// 将单词首放入map中
		for (String s : a) {
			char c = s.charAt(0);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		boolean flag = false; // 首尾可能有一对字符无法对应，即接龙首和接龙尾
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