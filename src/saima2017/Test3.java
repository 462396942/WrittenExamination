package saima2017;

import java.util.*;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();
			method(a, b, k);
		}
	}

	public static void method(int a, int b, int k) {
		boolean[] array = getPrime(b);
		
		if (k > b || (k!= 2 && !array[k])) {
			System.out.println("0");
			return;
		}
		
		int count = 0;
		for (int i = a; i <= b; i++) {
			if(array[i]){
				if(i == k)
					count++;
				else
					continue;
			}				
			else if (isRight(i, k))
				count++;
		}
		System.out.println(count);
	}

	public static boolean[] getPrime(int n) {
		boolean[] a = new boolean[n + 1];
		Arrays.fill(a, true);
		for (int i = 2; i <= n / 2; i++) {
			if (a[i]) {
				for (int j = i + i; j <= n; j += i)
					a[j] = false;
			}
		}
		return a;
	}

	public static boolean isRight(int i, int k) {
		for (int j = 2; j < k; j++) {
			if (i % j == 0)
				return false;
		}
		if (i % k == 0)
			return true;
		else
			return false;
	}

}
