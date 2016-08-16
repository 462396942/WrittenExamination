package wangyi2017lianxi;
import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int s = sc.nextInt();
			int l = sc.nextInt();
			int i = method(n,s,l);
			System.out.println(i);
		}
	}
	public static int method(int n,int s,int l){
		if(n == 0)
			return 0;
		if(s == 0)
			return 1;
		//每张cd歌曲数
		int x = 1;
		//每张cd总秒数
		int sum = x;
		while(sum < l){
			x++;
			sum = x*s+(x-1);
		}
		x = sum == l ? x : x-1;
		if(x%13 == 0)
			x--;
		
		//两个int相除，还是int，若要得到小数，可以将除数转为double
		return (int)Math.ceil(n/(double)x);
	}

}
