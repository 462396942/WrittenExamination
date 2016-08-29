package wanyi2017neitui;

import java.util.*;

/**
 * 航天飞行器是一项复杂而又精密的仪器，飞行器的损耗主要集中在发射和降落的过程，科学家根据实验数据估计，如果在发射过程中，产生了 x
 * 程度的损耗，那么在降落的过程中就会产生 x2 程度的损耗，如果飞船的总损耗超过了它的耐久度，飞行器就会爆炸坠毁。问一艘耐久度为 h
 * 的飞行器，假设在飞行过程中不产生损耗，那么为了保证其可以安全的到达目的地，只考虑整数解，至多发射过程中可以承受多少程度的损耗？
 * 
 * 注意啦：真是没有送分题啊，任何一道认为简单的题，都要考虑边界，
 * 
 * 本题中输入为long！！如果直接平方运算会超出long的界限直接雪崩，所以能用数学公式算的尽量用数学公式算。
 * 不能算的在用程序去迭代
 * @author zhoucong
 *
 */
public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
//			int h = sc.nextInt();
			long h = sc.nextLong();
			long re = method(h);
			System.out.println(re);
		}
	}
	public static long method(long h){
		double val = (Math.sqrt(1+4*h)-1)/2;
		return (long)Math.floor(val);
	}

}
