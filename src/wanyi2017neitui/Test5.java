package wanyi2017neitui;

import java.util.*;

/**
 * �����������һ��Ӷ��־��ܵ��������������������Ҫ�����ڷ���ͽ���Ĺ��̣���ѧ�Ҹ���ʵ�����ݹ��ƣ�����ڷ�������У������� x
 * �̶ȵ���ģ���ô�ڽ���Ĺ����оͻ���� x2 �̶ȵ���ģ�����ɴ�������ĳ����������;öȣ��������ͻᱬը׹�١���һ���;ö�Ϊ h
 * �ķ������������ڷ��й����в�������ģ���ôΪ�˱�֤����԰�ȫ�ĵ���Ŀ�ĵأ�ֻ���������⣬���෢������п��Գ��ܶ��ٳ̶ȵ���ģ�
 * 
 * ע����������û���ͷ��Ⱑ���κ�һ����Ϊ�򵥵��⣬��Ҫ���Ǳ߽磬
 * 
 * ����������Ϊlong�������ֱ��ƽ������ᳬ��long�Ľ���ֱ��ѩ��������������ѧ��ʽ��ľ�������ѧ��ʽ�㡣
 * ����������ó���ȥ����
 * @author zhoucong
 *
 */
public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
//			int h = sc.nextInt();
			long h = sc.nextLong();
			long re = method(h);
			System.out.println(re);
		}
	}
	public static long method(long h){
		double val = (Math.sqrt(1+4*h)-1)/2;
		return (long)Math.floor(val);
	}

}
