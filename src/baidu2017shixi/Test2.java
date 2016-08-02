package baidu2017shixi;

import java.util.*;

/**
 * 在计算机中，页式虚拟存储器实现的一个难点是设计页面调度（置换）算法。其中一种实现方式是FIFO算法。
 * FIFO算法根据页面进入内存的时间先后选择淘汰页面，先进入内存的页面先淘汰，后进入内存的后淘汰。 假设Cache的大小为2,有5个页面请求，分别为 2 1
 * 2 3 1，则Cache的状态转换为：(2)->(2,1)->(2,1)->(1,3)->(1,3)，其中第1,2,4次缺页，总缺页次数为3。
 * 现在给出Cache的大小n和m个页面请求，请算出缺页数。
 * 
 * 涉及lru算法  就用linkedHashMap
 * 
 * @author zc
 *
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			CacheLinkedHashMap<Integer, Object> cache = new CacheLinkedHashMap<Integer, Object>(n, 0.75f, true);
			int count = 0;
			for (int i = 0; i < m; i++) {
				int read = sc.nextInt();
				if (!cache.containsKey(read)) {
					count++;
					cache.put(read, null);
				}
			}
			System.out.println(count);
		}
	}
}

class CacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param initialCapacity
	 *            容量
	 * @param loadFactor
	 *            负载因子
	 * @param accessOrder
	 *            是否使用lru算法替换，为true为使用
	 */
	int maxCapacity;

	public CacheLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
		super(initialCapacity, loadFactor, accessOrder);
		this.maxCapacity = initialCapacity;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> e) {
		return size() > maxCapacity;
	}
}