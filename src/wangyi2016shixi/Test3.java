package wangyi2016shixi;

import java.util.*;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。 测试样例： [1,3,5,2,2],5,3 返回：2
 * 
 * 错误原因： 细节马虎
 * @author zc
 *
 */
public class Test3 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// System.out.println(qSearch(a,0,a.length-1,3));
		int[] b = { 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] c = { 1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022,
				252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142,
				259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818,
				1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247,
				986578, 798663 };
		// System.out.println(qSearch(b,0,b.length-1,3));
		System.out.println(qSearch(c, 0, c.length - 1, 24));
		// System.out.println(qSearch2(a,3));
		// System.out.println(qSearch2(a,3));

	}

	// 用快速排序变形算法实现
	public static int qSearch(int[] a, int start, int end, int k) {
		if (a == null)
			return -1;
		if (start >= end)
			return a[k - 1];
		if (end - start <= 2) {
			setMid(a, start, end);
			return a[k - 1];
		}
		int mid = getPivot(a, start, end, k);
		if (mid == k - 1)
			return a[mid];
		else if (mid < k - 1)
			return qSearch(a, mid + 1, end, k);
		else
			return qSearch(a, start, mid - 1, k);
	}

	public static int getPivot(int[] a, int start, int end, int k) {
		setMid(a, start, end);
		int pivot = a[end - 1];
		int i = start, j = end - 2;
		while (i < j) {
			while (a[i] > pivot)
				i++;
			while (a[j] < pivot)
				j--;
			if (i < j) {
				swap(a, i, j);
			}
		}
		swap(a, i, end - 1);
		return i;
	}

	public static void setMid(int[] a, int start, int end) {
		int mid = (start + end) / 2;
		if (a[start] < a[mid])
			swap(a, start, mid);
		if (a[start] < a[end])
			swap(a, start, end);
		if (a[mid] < a[end])
			swap(a, mid, end);
		swap(a, mid, end - 1);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// 用堆实现
	public static int qSearch2(int[] a, int k) {
		if (a == null || a.length < k)
			return -1;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i : a) {
			if (q.size() < k)
				q.offer(i);
			else {
				if (i > q.peek()) {
					q.poll();
					q.offer(i);
				}
			}
		}
		return q.peek();
	}
}
