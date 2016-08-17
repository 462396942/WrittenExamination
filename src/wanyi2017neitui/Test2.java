package wanyi2017neitui;

import java.util.*;

/**
 * ����һ�� n �� m �еĵ��Σ����� '.' ��ʾ����ͨ�е�λ�ã�'X' ��ʾ����ͨ�е��ϰ���ţţ�� (x0 , y0 )
 * λ�ó���������������Σ���һ�����Ϸ����ͬ���ǣ���ÿһ��ֻ�ܰ���һЩָ���Ĳ����������Σ�Ҫ��ÿһ���������Գ������εı߽磬Ҳ���ܵ����ϰ��ϡ�
 * ���εĳ��ڿ���������ĳ������ͨ�е�λ���ϡ�ţţ��֪�������£�����Ҫ���ٲ��ſ����뿪������Ρ�
 * 
 * ͼ�Ĺ������
 * @author zhoucong
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			String[][] a = new String[n][m];
			for (int i = 0; i < n; i++) {
				String[] s = sc.next().split("");
				for(int j=0;j<m;j++)
					a[i][j] = s[j];
			}
			int x0 = sc.nextInt();
			int y0 = sc.nextInt();
			int k = sc.nextInt();
			int[][] dic = new int[k][2];
			for (int i = 0; i < k; i++) {
				dic[i][0] = sc.nextInt();
				dic[i][1] = sc.nextInt();
			}
			int re = method(a, n, m, x0, y0, dic);
			System.out.println(re);
		}
	}

	public static int method(String[][] a, int n, int m, int x0, int y0, int[][] dic) {
		Point[][] p = process(a);
		int count = getCount(p);
		Queue<Point> q = new LinkedList<Point>();
		Set<Point> visited = new HashSet<Point>();
		q.offer(p[x0][y0]);
		visited.add(p[x0][y0]);
		Point last = p[x0][y0], nLast = p[x0][y0];
		int level = 0;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			for (int i = 0; i < dic.length; i++) {
				if (x + dic[i][0] < n && x + dic[i][0] >= 0 && y + dic[i][1] < m && y + dic[i][1] >= 0
						&& p[x + dic[i][0]][y + dic[i][1]].val.equals(".") && !visited.contains(p[x + dic[i][0]][y + dic[i][1]])) {
					q.offer(p[x + dic[i][0]][y + dic[i][1]]);
					visited.add(p[x + dic[i][0]][y + dic[i][1]]);
					nLast = p[x + dic[i][0]][y + dic[i][1]];
				}
			}
			if(last == temp){
				last = nLast;
				level++;
			}
		}
		if(visited.size() == count)
			return level-1;
		else
			return -1;
	}
	
	public static Point[][] process(String[][] a){
		Point[][] re = new Point[a.length][a[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				re[i][j] = new Point(a[i][j],i,j);
			}
		}
		return re;
	}
	public static int getCount(Point[][] a){
		int count = 0;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(a[i][j].val.equals("."))
					count++;
			}
		}
		return count;
	}
}

class Point {
	int x;
	int y;
	String val;

	public Point(String val, int x, int y) {
		this.val = val;
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((val == null) ? 0 : val.hashCode());
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
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
