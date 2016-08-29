package wangyi2017neitui2;

import java.util.*;

/**
 * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x
 * + 3或者8 * x +
 * 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1
 * ,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
 * 
 * 上午编程有点不再状态啊。。
 * 注意的点：广度的话要注意去重，访问过的点不再访问，还有常量用staticfinal标识，不要出现魔法数
 * @author zhoucong
 *
 */
public class Test6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long x = sc.nextLong();
			int re = method(x);
			System.out.println(re);
		}

	}

	// 常数用下面形式代替，良好的编码习惯
	static final int MAX = 100000;
	static final int MOD = 1000000007;

	public static int method(long x) {
		Cur cur = new Cur(x, 0);
		Queue<Cur> q = new LinkedList<Cur>();
		q.offer(cur);
		Set<Long> set = new HashSet<Long>();
		set.add(cur.x);
		while (q.size() > 0) {
			Cur t = q.poll();
			if (t.times > MAX)
				return -1;
			if (t.x == 0)
				return t.times;
			long x1 = ((t.x << 2) + 3) % MOD;
			if (!set.contains(x1)) {
				q.offer(new Cur(x1, t.times + 1));
				set.add(x1);
			}
			x1 = ((t.x << 3) + 7) % MOD;
			if (!set.contains(x1)) {
				q.offer(new Cur(x1, t.times + 1));
				set.add(x1);
			}
		}
		return -1;
	}

}

class Cur {
	// 当前位置
	long x;
	// 当前已走次数
	int times;

	public Cur(long x, int times) {
		this.x = x;
		this.times = times;
	}

}
