package wanyi2017neitui;

import java.util.*;

/**
 * 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 )
 * 位置出发，遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。
 * 地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
 * 
 * 注意：图的广度优先，读取char数组的方式！！！  string的比较
 * @author zhoucong
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] a = new char[n][m];
			//注意 ！！char数组读取的方式
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				a[i] = s.toCharArray();
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
			if(re == -1)
				return;
		}
	}

	public static int method(char[][] a, int n, int m, int x0, int y0, int[][] dic) {
		boolean[][] vi = new boolean[n][m];
		//判断是否所有点都能遍历到
		int cur = 1;
		int sum = getSum(a,n,m); 
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x0,y0,0));
		vi[x0][y0] = true;
		while(q.size() > 0){
			Point t = q.poll();
			for(int i=0;i<dic.length;i++){
				int x = t.x+dic[i][0];
				int y = t.y+dic[i][1];
				if(isOk(a,x,y,n,m,vi)){
					vi[x][y] = true;
					q.offer(new Point(x,y,t.v+1));
					cur++;
					if(sum == cur)
						return t.v+1;
				}
			}
		}
		return -1;
	}
	public static boolean isOk(char[][] a,int x,int y,int n,int m,boolean[][] vi){
		if(x < 0 || x >= n)
			return false;
		if(y < 0 || y >= m)
			return false;
		if(vi[x][y])
			return false;
		if(a[x][y] == 'X')
			return false;
		return true;
	}
	public static int getSum(char[][] a,int n,int m){
		int c = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				//大哥！字符串判等还能用等号咯？
				if(a[i][j] == '.')
					c++;
			}
		}
		return c;
	}
}

class Point {
	//v表示已走的距离
	int x,y,v;
	public Point(int x,int y,int v){
		this.x = x;
		this.y = y;
		this.v = v;
	}
}
