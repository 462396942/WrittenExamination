package wangyi2016;

import java.util.*;
/**
 * С�׾���������������Ϸ.��һ��,������һ�������������Ϸ,���Ľ�ɫ�ĳ�ʼ����ֵΪ a.
 * �ڽ�������һ��ʱ����,��������������n������,ÿ������ķ�����Ϊb1,b2,b3...bn. 
 * ��������Ĺ��������biС�ڵ���С�׵ĵ�ǰ����ֵc,��ô���������ɴ�ܹ���,�� ��ʹ���Լ�������ֵ����bi;���bi����c,����Ҳ�ܴ�ܹ���,
 * ����������ֵֻ������bi ��c�����Լ��.��ô��������,��һϵ�еĶ�����,С�׵���������ֵΪ����?
 * 
 * �ͷ���
 * @author zc
 *
 */
public class Test1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int a = sc.nextInt();
			for(int i=0;i<n;i++){
				a += method(a,sc.nextInt());
			}
			System.out.println(a);
		}
	}
	public static int method(int a,int b){
		if(b <= a)
			return b;
		return gongYue(a,b);
	}
	public static int gongYue(int a,int b){
		if(a == 0)
			return b;
		return gongYue(b%a,a);
	}
}
