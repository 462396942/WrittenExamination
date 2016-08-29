package wanyi2017neitui;

import java.util.*;

/**
 * 牛牛想尝试一些新的料理，每个料理需要一些不同的材料，
 * 问完成所有的料理需要准备多少种不同的材料。
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
