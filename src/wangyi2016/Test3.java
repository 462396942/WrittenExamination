package wangyi2016;

import java.util.*;

/**
 * ��N*M�Ĳݵ���,��Ī����K��Ģ��,Ģ����ը����������,��������óȻȥ��,����Ģ�������ε�. ֻ
 * ��һ�ֽ���ɨ��͸������Ʒ����ɨ������ε�Ģ��,����������һ��ս��ѧԺ,����2��ɨ��͸��,һ�� ɨ��͸������ɨ���(3*3)���������е�Ģ��,
 * Ȼ�������Ϳ��������һЩ���ε�Ģ��. ��:����������������ٸ�Ģ��? ע�⣺ÿ������ɨ��һ��ֻ�������һ��Ģ����ÿ��������������޶��Ģ��
 * 
 * ����ԭ��:��������ƫ��,3*3�ķ���,�����Լ�Ϊ����,������������1
 * 
 * ��Ҫ����ά������������map��ʱ�����Բ����Զ������ݽṹ������дhashcode��equals�ķ�����ʵ��
 * ������ⷨ
 * @author zc
 *
 */
public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			Map<Point, Integer> map = new HashMap<Point, Integer>();
			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				Point p = new Point(x, y);
				if (map.containsKey(p))
					map.put(p, map.get(p) + 1);
				else
					map.put(p, 1);
			}
			int count = 0;
			count += method(n, m, map);
			count += method(n, m, map);
			System.out.println(count);
		}
	}

	public static int method(int n, int m, Map<Point, Integer> map) {
		int max = Integer.MIN_VALUE;
		int maxX = 0, maxY = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int cur = 0;
				for (Map.Entry<Point, Integer> e : map.entrySet()) {
					if (e.getValue() != 0 && Math.abs(e.getKey().x - i) <= 1 && Math.abs(e.getKey().y - j) <= 1) {
						cur++;
					}
				}
				if (cur > max) {
					max = cur;
					maxX = i;
					maxY = j;
				}

			}
		}
		for (Map.Entry<Point, Integer> e : map.entrySet()) {
			if (e.getValue() != 0 && Math.abs(e.getKey().x - maxX) <= 1 && Math.abs(e.getKey().y - maxY) <= 1)
				map.put(e.getKey(), e.getValue() - 1);
		}
		return max;
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
