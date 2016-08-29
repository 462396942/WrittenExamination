package leshi2017shixi_2;

import java.util.*;
/**
 * 若宝石系列为：dcba
 * 其中有两道彩虹，分别是(0,1),(1,2),代表第一个位置上的宝石可以和第二个位置上的宝石互换，
 * 第二个位置上的宝石可以和第三个位置上的宝石互换，
 * 最终可以得到字典序最小的宝石系列：bcda。 作为小贱君的死党，你有什么方法帮助他破阵吗？
 * 
 * 遇到题都是先用例子模拟！！！先思考在写代码！！！否则写出来的都是shit
 * 该方法超时了，实在想不到了 gg 
 * 8.27日终于通过了，用了并查集的思想！！
 * @author zc
 *
 */
public class Test2 {
	//parent[i]表示i的父亲
	static int[] parent;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s= sc.next();
			int n = sc.nextInt();
			parent = new int[s.length()];
			prepare(s.length());
			for(int i=0;i<n;i++){	
				merge(sc.nextInt(),sc.nextInt());
			}
			method(s);
		}
	}
	public static void method(String s){
		Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
		for(int i=0;i<s.length();i++){
			Set<Integer> t;
			int par = getParent(i);
			t = map.get(par);
			if(t == null){
				t = new TreeSet<Integer>();
				t.add(par);
				t.add(i);
				map.put(par, t);
			}
			else
				t.add(i);
		}
		
		char[] c = s.toCharArray();
		for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
			if(entry.getValue().size() == 1)
				continue;
			List<Character> temp = new ArrayList<Character>();
			for(int i : entry.getValue())
				temp.add(c[i]);
			Collections.sort(temp);
			int index = 0;
			for(int i:entry.getValue())
				c[i] = temp.get(index++);
		}
		System.out.println(new String(c));
	}
	
	public static void prepare(int n){
		for(int i=0;i<n;i++)
			parent[i] = i;
	}
	public static void merge(int a,int b){
		int p1 = getParent(a);
		int p2 = getParent(b);
		if(p1 == p2)
			return;
		parent[p2] = p1;
	}
	public static int getParent(int a){
		if(parent[a] != a)
			parent[a] = getParent(parent[a]);
		return parent[a];
			
	}
}
