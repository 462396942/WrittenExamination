package tengxun2017shixi;

import java.util.*;

/**
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，差的绝对值最小的有多少对呢？差的绝对值最大的呢？
 * 
 * 出错地方：两两组成二元组，不一定是相邻的，排序后，相同元素的处理也是需要注意的地方
 * @author zc
 *
 */
public class test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			method(a);
		}
	}

	public static void method(int[] a) {
		Arrays.sort(a);

		// 计算最小差
		int minSub = Integer.MAX_VALUE;
		int minCount = 0;
		// 数组中是否有相同元素
		int sameCount = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1]) {
				sameCount++;
			} else {
				minCount += (sameCount * (sameCount - 1)) / 2;
				sameCount = 1;
			}
		}
		//注意这句，在for里面走if，else的，最后一个判断会走不到，所以要在外面重做
		minCount += (sameCount * (sameCount - 1)) / 2;
		// 没有重复元素
		if (minCount == 0) {

			for (int i = 1; i < a.length; i++) {
				if (a[i] - a[i - 1] < minSub) {
					minSub = a[i] - a[i - 1];
					minCount = 1;
				} else if (a[i] - a[i - 1] == minSub)
					minCount++;
			}
		}
		// 计算最大差
		int maxCount = 0;
		if (a[0] == a[a.length - 1])
			maxCount = (a.length - 1) * a.length / 2;
		else {
			int left = 1;
			int right = 1;
			int i = 1;
			while (i < a.length && a[i] == a[i - 1]) {
				left++;
				i++;
			}
			i = a.length - 1;
			while (i >= 0 && a[i] == a[i - 1]) {
				right++;
				i--;
			}
			maxCount = left * right;
		}
		System.out.println(minCount + " " + maxCount);

	}
}
