package wangyi2017neitui2;

import java.util.*;

/**
 * С�����Ǹо�������������Ϊ�����С�׾�����ȥѰ�ұ��ǳԡ��ʼС����һ����ʼλ��x_0������С�������ĵ�ǰλ��x����ֻ��ͨ�����ص������ƶ��� 4 * x
 * + 3����8 * x +
 * 7����Ϊʹ����������Ҫ�ķ�̫��������������ֻ��ʹ�������������100,000�Ρ��������������ܱ�1,000,000,007������λ��(���磺λ��0��λ��1
 * ,000,000,007��λ��2,000,000,014��)��С����Ҫ���æ����������Ҫʹ�ö��ٴ������������ܳԵ����ǡ�
 * 
 * �������е㲻��״̬������
 * ע��ĵ㣺��ȵĻ�Ҫע��ȥ�أ����ʹ��ĵ㲻�ٷ��ʣ����г�����staticfinal��ʶ����Ҫ����ħ����
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

	// ������������ʽ���棬���õı���ϰ��
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
	// ��ǰλ��
	long x;
	// ��ǰ���ߴ���
	int times;

	public Cur(long x, int times) {
		this.x = x;
		this.times = times;
	}

}
