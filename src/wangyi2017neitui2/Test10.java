package wangyi2017neitui2;

import java.util.*;

/**
 * 小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，
 * 然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如：
 * 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 =
 * 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，让你找出无法从n个数中选取部分求和的数字中的最小数。
 * 
 * 怎么说呢，实现技巧问题吧
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
			//此处是问题的关键
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
