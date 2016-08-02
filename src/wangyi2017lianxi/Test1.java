package wangyi2017lianxi;

import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (!isSame(n))
				method(n);
		}
	}

	public static boolean isSame(int n) {
		char[] a = toChar(n);
		for (int i = 1; i < 4; i++) {
			if(a[i] != a[i-1])
				return false;
		}
		System.out.println(n+" - "+n+" = 0000");
		return true;
	}

	public static void method(int n) {
		if (n == 6174)
			return;
		char[] a = toChar(n);
		Arrays.sort(a);
		String s1 = new String(a);
		String s2 = reverse(a);
		int i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);
		n = i2-i1;
		System.out.println(s2+" - "+s1+" = "+n);
		method(n);
	}
	
	public static String reverse(char[] a){
		int i=0,j=a.length-1;
		while(i<j){
			char temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return new String(a);
	}
	
	public static char[] toChar(int n){
		String s= Integer.toString(n);
		char[] a = new char[4];
		for(int i=0;i<4;i++){
			if(i<s.length())
				a[i] = s.charAt(i);
			else
				a[i] = '0';
		}
		return a;
	}

}
