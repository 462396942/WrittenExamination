package wangyi2016;

import java.util.Scanner;

/**
 * 黑默丁格有三个炮台,炮台能攻击到距离它R的敌人 (两点之间的距离为两点连续的距离,例如(3,0),(0,4)之间的距离是5)
 * 如果一个炮台能攻击 到敌人,那么就会对敌人造成1×的伤害.黑默丁格将三个炮台放在N*M方格中的点上,并且给出敌人 的坐标. 
 * 问:那么敌人受到伤害会是多大?
 * 
 * 数学基础
 * 送分题
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
