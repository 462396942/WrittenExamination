package wanyi2017;

import java.util.*;
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			String[][] a = new String[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++)
					a[i][j] = sc.next();
			}
			int x0 = sc.nextInt();
			int y0 = sc.nextInt();
			int k = sc.nextInt();
			int[][] b = new int[k][2];
			for(int i=1;i<k;i++){
				b[i][0] = sc.nextInt();
				b[i][1] = sc.nextInt();
			}
			method(a,b,x0,y0);
		}
	}
	public static void method(String[][] a,int[][]b,int x0,int y0){
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x0,y0));
		Set<Point> set = new HashSet<Point>();
		while(!q.isEmpty()){
			Point temp = q.poll();
			if(set.contains(temp))
				continue;
			set.add(temp);
			bfs();
		}
	}

}
class Point{
	int x;
	int y;
	public Point(int x,int y){
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
	
}
