package youdao2017neitui;

import java.util.*;

/**
 * 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。
 * 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+
 * 1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，
 * 直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
 * 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1
 * 。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
 * 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
 * 
 * 注意：：输入输出格式，还是没有搞懂，多用小函数，有利于编程中逻辑清晰
 * 
 * 本题是找数字规律题，这种解法很常用！！！
 * 
 * @author zc
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[2*n];
			for(int i=0;i<2*n;i++){
				int index = method(n,i,k);
				a[index] = sc.nextInt();
			}
			print(a);
			if(T>0)
				System.out.println();
		}
	}
	public static int method(int n,int i,int k){
		for(int j=0;j<k;j++){
			if(i < n)
				i = i*2;
			else
				i = (i-n)*2+1;
		}
		return i;
	}
	public static void print(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			if(i != a.length-1)
				System.out.print(" ");
		}
	}


}
