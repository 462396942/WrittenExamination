package wanyi2017neitui;

import java.util.*;

/**
 * ţţ�볢��һЩ�µ�����ÿ��������ҪһЩ��ͬ�Ĳ��ϣ�
 * ��������е�������Ҫ׼�������ֲ�ͬ�Ĳ��ϡ�
 * 
 * @author zhoucong
 *
 */
public class Test8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> m = new HashSet<String>();
		while(sc.hasNext()){
			String s = sc.nextLine();
			String[] a = s.split(" ");
			for(String s1 : a)
				m.add(s1);
		}
		System.out.println(m.size());
	}

}
