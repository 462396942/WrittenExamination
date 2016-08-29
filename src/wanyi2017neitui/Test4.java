package wanyi2017neitui;

import java.util.*;

/**
 * n ֻ��ţ����һ�ţ�ÿ����ţӵ�� ai
 * ��ƻ����������Ҫ������֮��ת��ƻ����ʹ�����������ţӵ�е�ƻ��������ͬ��
 * ÿһ�Σ���ֻ�ܴ�һֻ��ţ��������ǡ������ƻ������һ����ţ�ϣ�
 * ��������Ҫ�ƶ����ٴο���ƽ��ƻ�������������������� -1��
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
