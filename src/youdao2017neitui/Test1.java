package youdao2017neitui;

import java.util.*;

/**
 * ϴ����������ʮ�ֳ�����������Ҫдһ������ģ��ϴ�ƵĹ��̡�
 * ������Ҫϴ2n���ƣ����ϵ��������ǵ�1�ţ���2�ţ���3��һֱ����2n�š����ȣ����ǰ���2n���Ʒֳ����ѣ��������ŵ�1�ŵ���n�ţ��ϰ�ѣ����������ŵ�n+
 * 1�ŵ���2n�ţ��°�ѣ������žͿ�ʼϴ�ƵĹ��̣��ȷ������ֵ����һ���ƣ��ٷ������ֵ����һ���ƣ����ŷ������ֵĵ����ڶ����ƣ��ٷ������ֵĵ����ڶ����ƣ�
 * ֱ�����������ֵĵ�һ���ơ����Ű��ƺϲ������Ϳ����ˡ�
 * ������6���ƣ��ʼ�Ƶ�������1,2,3,4,5,6�����ȷֳ����飬��������1,2,3����������4,5,6����ϴ�ƹ����а�˳�������6,3,5,2,4,1
 * �������������ٴκϳ�һ����֮�����ǰ��մ������µ�˳�������ƣ��ͱ��������1,4,2,5,3,6��
 * ���ڸ���һ��ԭʼ���飬������⸱��ϴ��k��֮��������µ����С�
 * 
 * ע�⣺�����������ʽ������û�и㶮������С�����������ڱ�����߼�����
 * 
 * �����������ֹ����⣬���ֽⷨ�ܳ��ã�����
 * 
 * @author zc
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[2*n];
			for(int i=0;i<2*n;i++){
				int index = method(n,i,k);
				a[index] = sc.nextInt();
			}
			print(a);
			if(T>0)
				System.out.println();
		}
	}
	public static int method(int n,int i,int k){
		for(int j=0;j<k;j++){
			if(i < n)
				i = i*2;
			else
				i = (i-n)*2+1;
		}
		return i;
	}
	public static void print(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			if(i != a.length-1)
				System.out.print(" ");
		}
	}


}
