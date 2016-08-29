package aiqiyi2017neitui;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * ª¨—©Œ Ã‚ ∞Ÿ¡∑1088
 * @author zhoucong
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			Point[] a = new Point[row * col];
			int[][] map = new int[row][col];
			int num = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					map[i][j] = sc.nextInt();
					a[num++] = new Point(i, j, map[i][j]);
				}
			}
			int re = method(row, col, a, map);
			System.out.println(re);
		}
	}

	public static int method(int r, int c, Point[] a, int[][] map) {
		int[][] dp = new int[r][c];
		for(int i=0;i<r;i++)
			Arrays.fill(dp[i], 1);
		Arrays.sort(a, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.h - p2.h;
			}
		});
		int max = 0;
		for (Point p : a) {
			if (p.x - 1 >= 0 && p.h > map[p.x - 1][p.y])
				dp[p.x][p.y] = Math.max(dp[p.x][p.y], dp[p.x - 1][p.y] + 1);
			if (p.x + 1 < r && p.h > map[p.x + 1][p.y])
				dp[p.x][p.y] = Math.max(dp[p.x][p.y], dp[p.x + 1][p.y] + 1);
			if (p.y - 1 >= 0 && p.h > map[p.x][p.y - 1])
				dp[p.x][p.y] = Math.max(dp[p.x][p.y], dp[p.x][p.y - 1] + 1);
			if (p.y + 1 < c && p.h > map[p.x][p.y + 1])
				dp[p.x][p.y] = Math.max(dp[p.x][p.y], dp[p.x][p.y + 1] + 1);
			if (dp[p.x][p.y] > max)
				max = dp[p.x][p.y];
		}
		return max;
	}
}
class Point {
	int x;
	int y;
	int h;

	public Point(int x, int y, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}
}
