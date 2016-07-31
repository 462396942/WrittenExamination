package wangyi2016shixi;

import java.util.*;

/**
 * ����������ʯ�ı��g1,g2����Ŵ�1��ʼ��ͬʱ������ϵ����vector,����Ԫ��ΪһЩ��Ԫ�飬��һ��Ԫ��Ϊһ�αȽ��н��ص���ʯ�ı�ţ�
 * �ڶ���Ԫ��Ϊ�������ʯ�ı�š�������֮ǰ�ıȽϴ���n���뷵����������ʯ�Ĺ�ϵ����g1���ط���1��g2���ط���-1���޷��жϷ���0��
 * �������ݱ�֤�Ϸ���������ì��������֡� ���������� 2,3,[[1,2],[2,4],[1,3],[4,3]],4 ����: 1
 * 
 * 
 * ���ڶ�Ԫ��β�����������⣬����ѡ����map�洢������ɭ�ֽṹ
 * ͼ����ʱǧ��ǵ��ж��Ƿ���ʹ�������
 * @author zc
 *
 */
public class Test1 {
	public static void main(String[] args) {
		int[][] a = {{1,2},{2,4},{1,3},{4,3}};
		Test1 t = new Test1();
		System.out.println(t.cmp(2, 3, a, 4));
	}

	public int cmp(int g1, int g2, int[][] a, int n) {
		if(n < 1)
			return -1;
		//��ʾ��iֱ������������i����Ľڵ�
		Map<Integer,List<Integer>> map = new  HashMap<Integer,List<Integer>>();
		for(int i=0;i<n;i++){
			List<Integer> temp = null;
			if(map.containsKey(a[i][0]))
				temp = map.get(a[i][0]);
			else
				temp = new ArrayList<Integer>();
			temp.add(a[i][1]);
			map.put(a[i][0], temp);
		}
		
		if(valid(g1,g2,map))
			return 1;
		else if(valid(g2,g1,map))
			return -1;
		else
			return 0;

	}
	public boolean valid(int g1,int g2,Map<Integer,List<Integer>> map){
		//��α���
        //��ʾ�Ƿ������
        Set<Integer> set = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(g1);
		while(!q.isEmpty()){
			int temp = q.poll();
            set.add(temp);
			if(temp == g2)
				return true;
			for(int i : map.get(temp)){
				if(!set.contains(i))
                	q.offer(i);
            }
		}
		return false;
	}
}
