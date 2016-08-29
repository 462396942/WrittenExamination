package wangyi2017neitui2;

import java.util.*;

/**
 * 小易喜欢的单词具有以下特性： 1.单词每个字母都是大写字母 2.单词没有连续相等的字母
 * 3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。 例如：
 * 小易不喜欢"ABBA"，因为这里有两个连续的'B' 小易不喜欢"THETXH"，因为这里包含子序列"THTH"
 * 小易不喜欢"ABACADA"，因为这里包含子序列"AAAA" 小易喜欢"A","ABA"和"ABCBA"这些单词
 * 给你一个单词，你要回答小易是否会喜欢这个单词。
 * 
 * 
 * 这个题是算法实现技巧题，还是看到时候能不能想到了，所以还是用例子多模拟
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
