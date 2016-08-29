package wanyi2017neitui;

import java.util.*;

/**
 * ����һ�� n �� m �еĵ��Σ����� '.' ��ʾ����ͨ�е�λ�ã�'X' ��ʾ����ͨ�е��ϰ���ţţ�� (x0 , y0 )
 * λ�ó���������������Σ���һ�����Ϸ����ͬ���ǣ���ÿһ��ֻ�ܰ���һЩָ���Ĳ����������Σ�Ҫ��ÿһ���������Գ������εı߽磬Ҳ���ܵ����ϰ��ϡ�
 * ���εĳ��ڿ���������ĳ������ͨ�е�λ���ϡ�ţţ��֪�������£�����Ҫ���ٲ��ſ����뿪������Ρ�
 * 
 * ע�⣺ͼ�Ĺ�����ȣ���ȡchar����ķ�ʽ������  string�ıȽ�
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
			//ע�� ����char�����ȡ�ķ�ʽ
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
		//�ж��Ƿ����е㶼�ܱ�����
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
				//��磡�ַ����еȻ����õȺſ���
				if(a[i][j] == '.')
					c++;
			}
		}
		return c;
	}
}

class Point {
	//v��ʾ���ߵľ���
	int x,y,v;
	public Point(int x,int y,int v){
		this.x = x;
		this.y = y;
		this.v = v;
	}
}
