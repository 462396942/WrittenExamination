package jinritoutiao2017kehuduanshixi;

import java.util.*;

/**
 * 你作为一名出道的歌手终于要出自己的第一份专辑了，你计划收录 n 首歌而且每首歌的长度都是 s 秒，每首歌必须完整地收录于一张 CD 当中。每张 CD
 * 的容量长度都是 L 秒，而且你至少得保证同一张 CD 内相邻两首歌中间至少要隔 1 秒。为了辟邪，你决定任意一张 CD 内的歌数不能被 13
 * 这个数字整除，那么请问你出这张专辑至少需要多少张 CD ？
 * 
 * @author zhoucong
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int L = sc.nextInt();
			int re = method(n, s, L);
			System.out.println(re);
		}
	}

	public static int method(int n, int s, int L) {
		int per = L / (s + 1);
		// 恰好可以放下最后一张盘
		if (per * (s + 1) + s == L)
			per++;
		// 是13的倍数
		if (per != 0 && per % 13 == 0)
			per--;
		int re = (int) Math.ceil((n * 1.0) / per);
		if(re == 1){
			if(n%13==0)
				re++;
			return re;
		}
		// z最后一张cd歌曲数十13倍数
		if (n % per % 13 == 0 && n%per == per-1)
			re++;
		return re;
	}
}
