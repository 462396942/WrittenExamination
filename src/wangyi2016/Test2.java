package wangyi2016;

import java.util.Scanner;

/**
 * ��Ĭ������������̨,��̨�ܹ�����������R�ĵ��� (����֮��ľ���Ϊ���������ľ���,����(3,0),(0,4)֮��ľ�����5)
 * ���һ����̨�ܹ��� ������,��ô�ͻ�Ե������1�����˺�.��Ĭ����������̨����N*M�����еĵ���,���Ҹ������� ������. 
 * ��:��ô�����ܵ��˺����Ƕ��?
 * 
 * ��ѧ����
 * �ͷ���
 * @author zc
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int r = sc.nextInt();
			int[][] a = new int[3][2];
			for(int i=0;i<3;i++){
				a[i][0] = sc.nextInt();
				a[i][1] = sc.nextInt();
			}
			int x0 = sc.nextInt();
			int y0 = sc.nextInt();
			method(a,x0,y0,r);
		}
	}
	public static void method(int[][] a,int x0,int y0,int r){
		int count = 0;
		for(int i=0;i<3;i++){
			if(Math.pow(a[i][0]-x0,2)+Math.pow(a[i][1]-y0,2) <= r*r)
				count++;
		}
		System.out.println(count+"x");
	}

}
