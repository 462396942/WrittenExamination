package leshi2017shixi2;

import java.util.Scanner;

/**
 * 今天的计算机课上，老师给同学们出了一道题： 输入n个数，请将其中的偶数的二进制反转。 eg：输入1 6 5
 * 其中6是偶数，二进制表示为110，反转后为011，代表3，所以最终输出1 3 5.
 * 小贱君最近脑子不怎么好使，想了半天也没想出来如何做，最后他向你寻求帮助了，帮帮可怜的小贱君吧！
 * 
 *  考点：位运算
 * 
 * @author zc
 *
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			for(int i=0;i<n;i++){
				//此处注意最后一个数后面没有空格，，注意输出格式！！！
				if(i == n-1)
					System.out.print(method(sc.nextInt()));
				else
					System.out.print(method(sc.nextInt()) + " ");
			}
			System.out.println();
		}
	}
	public static int method(int n){
		if((n&1) == 1)
			return n;
		else{
			int re = 0;
			while(n != 0){
				re = (re << 1) | (n & 1);
				n >>= 1;
			}
			return re;
		}
	}
}
