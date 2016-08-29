package wangyi2017neitui2;

import java.util.*;

/**
 * 有一片1000*1000的草地，小易初始站在(1,1)(最左上角的位置)。小易在每一秒会横向或者纵向移动到相邻的草地上吃草(小易不会走出边界)。
 * 大反派超超想去捕捉可爱的小易，他手里有n个陷阱。第i个陷阱被安置在横坐标为xi ，纵坐标为yi
 * 的位置上，小易一旦走入一个陷阱，将会被超超捕捉。你为了去解救小易，需要知道小易最少多少秒可能会走入一个陷阱，从而提前解救小易。
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
