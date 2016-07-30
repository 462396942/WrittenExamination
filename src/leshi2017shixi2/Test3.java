package leshi2017shixi2;

import java.util.*;

/**
 * Charm=Sum of all D(i)，其中D(i)=k-i，i为该排列中卷轴i的下标， k为位于i后面且和i是同一种卷轴的卷轴下标。
 * 现在所有的卷轴以<卷轴名称 数量>的格式给出，你需要输出所有卷轴的排列顺序，使得吸引值最大，
 * 如果有多种排列方式满足条件，输出按照名字排列字典序最小的一个。
 *
 * 算法技巧题，可以先用例子模拟计算过程，找出规律。
 * 向数组中插入困难的话用字符串啊！！
 * @author zc
 *
 */
public class Test3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			Map<String,Integer> map = new TreeMap<String,Integer>();
			for(int i=0;i<n;i++){
				map.put(sc.next(), sc.nextInt());
			}
			method(map);
		}
	}
	public static void method(Map<String,Integer> map){
		StringBuilder l = new StringBuilder();
		StringBuilder r = new StringBuilder();
		StringBuilder m = new StringBuilder();
		
		//将数量大于2的元素放到首尾个放一个
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			if(entry.getValue() > 1){
				l.append(entry.getKey()+" ");
				r.append(entry.getKey()+" ");
				map.put(entry.getKey(),entry.getValue()-2);
			}
		}
		//将此时数量大于0的元素插到中间
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			int v = entry.getValue();
			while(v > 0){
				m.append(entry.getKey()+" ");
				v--;
			}
		}
		String re = l.append(m).append(r).toString();
		//注意处理末尾处空格
		System.out.println(re.trim());
	}
}
