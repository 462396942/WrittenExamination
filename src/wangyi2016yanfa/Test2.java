package wangyi2016yanfa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai，
 * 每盏灯可以覆盖到的最远距离为d，为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小，请找到这个最小的d。
 *
 *注意边界，对于简单题上来就有思路的，一定要多思考特殊情况.即题目中给出的边界
 *当输出double时，要注意格式，通常使用String.format("%.2f", f)保留两位小数
 *
 * @author zc
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int l = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			double d = method(a,l);
			System.out.println(String.format("%.2f", d));
		}
	}
	public static double method(int[] a,int l){
		if(a.length == 1)
			return a[0] > l-a[0] ? a[0] : l-a[0];
		int max = 0;
		Arrays.sort(a);
		for(int i=1;i<a.length;i++){
			int temp = a[i]-a[i-1];
			if(temp > max)
				max = temp;
		}
		int i = a[0] > l-a[a.length-1] ? a[0] : l-a[a.length-1];
		//注意处理int计算结果为double时，可以采用如下方法
		double m = max/2.0;
		return m > i ? m : i;
	}

}
