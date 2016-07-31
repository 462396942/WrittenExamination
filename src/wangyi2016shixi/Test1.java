package wangyi2016shixi;

import java.util.*;

/**
 * 给定两颗钻石的编号g1,g2，编号从1开始，同时给定关系数组vector,其中元素为一些二元组，第一个元素为一次比较中较重的钻石的编号，
 * 第二个元素为较轻的钻石的编号。最后给定之前的比较次数n。请返回这两颗钻石的关系，若g1更重返回1，g2更重返回-1，无法判断返回0。
 * 输入数据保证合法，不会有矛盾情况出现。 测试样例： 2,3,[[1,2],[2,4],[1,3],[4,3]],4 返回: 1
 * 
 * 
 * 对于二元组尾首相连的问题，可以选择用map存储，构造森林结构
 * 图遍历时千万记得判断是否访问过！！！
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
		//表示与i直接相连，且在i后面的节点
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
		//层次遍历
        //表示是否遍历过
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
