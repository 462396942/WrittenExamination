package wanyi2017neitui;

import java.util.*;

/**
 * n 只奶牛坐在一排，每个奶牛拥有 ai
 * 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，
 * 每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，
 * 问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 * 
 * @author zhoucong
 *
 */
public class Test4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int re = method(a,n);
			System.out.println(re);
		}
	}
	public static int method(int[] a,int n){
		int sum = 0;
		for(int i : a)
			sum += i;
		if(sum % n != 0)
			return -1;
		sum /= n;
		int re = 0;
		for(int i : a){
			if((sum-i)%2 != 0)
				return -1;
			if(sum > i){
				re += sum-i;
			}
		}
		return re/2;
		
	}

}
