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
