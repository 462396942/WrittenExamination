package wangyi2017neitui2;

import java.util.*;

/**
 * ��һƬ1000*1000�Ĳݵأ�С�׳�ʼվ��(1,1)(�����Ͻǵ�λ��)��С����ÿһ��������������ƶ������ڵĲݵ��ϳԲ�(С�ײ����߳��߽�)��
 * ���ɳ�����ȥ��׽�ɰ���С�ף���������n�����塣��i�����屻�����ں�����Ϊxi ��������Ϊyi
 * ��λ���ϣ�С��һ������һ�����壬���ᱻ������׽����Ϊ��ȥ���С�ף���Ҫ֪��С�����ٶ�������ܻ�����һ�����壬�Ӷ���ǰ���С�ס�
 * 
 * @author zhoucong
 *
 */
public class Test4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] x = new int[n];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++)
				x[i] = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int y = sc.nextInt();
				if (y + x[i] < min)
					min = y + x[i];
			}
			System.out.println(min - 2);
		}
	}

}
