package wangyi2016;

import java.util.*;

/**
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的. 只
 * 有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,一个 扫描透镜可以扫描出(3*3)方格中所有的蘑菇,
 * 然后兰博就可以清理掉一些隐形的蘑菇. 问:兰博最多可以清理多少个蘑菇? 注意：每个方格被扫描一次只能清除掉一个蘑菇。每个方格可以有无限多个蘑菇
 * 
 * 错误原因:题意理解的偏差,3*3的方格,是以自己为中心,向上下左右扩1
 * 
 * 当要将二维数组或坐标放入map中时，可以采用自定义数据结构，并重写hashcode和equals的方法来实现
 * 暴力求解法
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
