package wangyi2016yanfa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * һ����l�ı�ֱ�Ľֵ�����n��·�ƣ��������ֵ����Ϊ0���յ�Ϊl����i��·������Ϊai��
 * ÿյ�ƿ��Ը��ǵ�����Զ����Ϊd��Ϊ�������������еƵĵƹ���븲�������֣�����Ϊ��ʡ�磬Ҫ�����d��С�����ҵ������С��d��
 *
 *ע��߽磬���ڼ�����������˼·�ģ�һ��Ҫ��˼���������.����Ŀ�и����ı߽�
 *�����doubleʱ��Ҫע���ʽ��ͨ��ʹ��String.format("%.2f", f)������λС��
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
		//ע�⴦��int������Ϊdoubleʱ�����Բ������·���
		double m = max/2.0;
		return m > i ? m : i;
	}

}
