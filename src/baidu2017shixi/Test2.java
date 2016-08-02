package baidu2017shixi;

import java.util.*;

/**
 * �ڼ�����У�ҳʽ����洢��ʵ�ֵ�һ���ѵ������ҳ����ȣ��û����㷨������һ��ʵ�ַ�ʽ��FIFO�㷨��
 * FIFO�㷨����ҳ������ڴ��ʱ���Ⱥ�ѡ����̭ҳ�棬�Ƚ����ڴ��ҳ������̭��������ڴ�ĺ���̭�� ����Cache�Ĵ�СΪ2,��5��ҳ�����󣬷ֱ�Ϊ 2 1
 * 2 3 1����Cache��״̬ת��Ϊ��(2)->(2,1)->(2,1)->(1,3)->(1,3)�����е�1,2,4��ȱҳ����ȱҳ����Ϊ3��
 * ���ڸ���Cache�Ĵ�Сn��m��ҳ�����������ȱҳ����
 * 
 * �漰lru�㷨  ����linkedHashMap
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
	 *            ����
	 * @param loadFactor
	 *            ��������
	 * @param accessOrder
	 *            �Ƿ�ʹ��lru�㷨�滻��ΪtrueΪʹ��
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