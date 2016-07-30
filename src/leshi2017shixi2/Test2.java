package leshi2017shixi2;

import java.util.*;
/**
 * 若宝石系列为：dcba
 * 其中有两道彩虹，分别是(0,1),(1,2),代表第一个位置上的宝石可以和第二个位置上的宝石互换，
 * 第二个位置上的宝石可以和第三个位置上的宝石互换，
 * 最终可以得到字典序最小的宝石系列：bcda。 作为小贱君的死党，你有什么方法帮助他破阵吗？
 * 
 * 遇到题都是先用例子模拟！！！先思考在写代码！！！否则写出来的都是shit
 * 该方法超时了，实在想不到了 gg 
 * @author zc
 *
 */
public class Test2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s= sc.next();
			int n = sc.nextInt();
			int[][] a = new int[n][2];
			for(int i=0;i<n;i++){
				a[i][0] = sc.nextInt();
				a[i][1] = sc.nextInt();
			}
			method(s,a,n);
		}
	}
	public static void method(String s,int[][] a,int n){
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		for(int i=0;i<n;i++){
			for(Set<Integer> set : list){
				if(set.contains(a[i][0]) || set.contains(a[i][1])){
					set.add(a[i][0]);
					set.add(a[i][1]);
					break;
				}
			}
			Set<Integer> set = new TreeSet<Integer>();
			set.add(a[i][0]);
			set.add(a[i][1]);
			list.add(set);
		}
		char[] c = s.toCharArray();
		
		for(Set<Integer> set : list){
			List<Character> temp = new ArrayList<Character>();
			for(int i : set){
				temp.add(c[i]);
			}
			Collections.sort(temp);
			int index = 0;
			for(int i:set){
				c[i] = temp.get(index);
				index++;
			}
		}
		System.out.println(new String(c));
	}
}
