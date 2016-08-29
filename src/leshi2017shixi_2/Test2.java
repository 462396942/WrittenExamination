package leshi2017shixi_2;

import java.util.*;
/**
 * ����ʯϵ��Ϊ��dcba
 * �����������ʺ磬�ֱ���(0,1),(1,2),�����һ��λ���ϵı�ʯ���Ժ͵ڶ���λ���ϵı�ʯ������
 * �ڶ���λ���ϵı�ʯ���Ժ͵�����λ���ϵı�ʯ������
 * ���տ��Եõ��ֵ�����С�ı�ʯϵ�У�bcda�� ��ΪС����������������ʲô����������������
 * 
 * �����ⶼ����������ģ�⣡������˼����д���룡��������д�����Ķ���shit
 * �÷�����ʱ�ˣ�ʵ���벻���� gg 
 * 8.27������ͨ���ˣ����˲��鼯��˼�룡��
 * @author zc
 *
 */
public class Test2 {
	//parent[i]��ʾi�ĸ���
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
