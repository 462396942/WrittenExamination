package wangyi2017neitui2;

import java.util.*;

/**
 * 考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。例如： "car" <
 * "carriage" < "cats" < "doggies < "koala" 2.根据字符串的长度排序。例如： "car" < "cats" <
 * "koala" < "doggies" < "carriage"
 * 考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
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
				// 此处用nextLine会报“请检查是否存在数组越界非法访问等情况”,原因不明
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
