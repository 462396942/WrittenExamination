package wanmei2017shixi;
import java.util.*;

public class Test2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++)
                a[i] = sc.nextInt();
            int[] re = method(a,n);
			for(int i=0;i<re.length;i++){
                System.out.print(re[i]);
                if(i != re.length-1)
                    System.out.print(" ");
            }
            if(T > 0)
                System.out.println();
        }
    }
    public static int[] method(int[] a,int n){
        //dp2[i]表示以a[i]为结尾的最长递增子序列长度
        int[] dp2 = new int[n];
        int[] dp = new int[n];
        int len = 0;
        for(int i=0;i<n;i++){
            int index = binarySearch(dp,0,len-1,a[i]);
            if(index == len)
                len++;
            dp[index] = a[i];
            dp2[i] = index+1;
        }
        return getSeq(a,dp2,len);
    }
    public static int binarySearch(int[] a,int s,int e,int k){
        if(s > e)
            return s;
        int mid = s + (e - s)/2;
        if(a[mid] == k)
            return mid;
        else if(a[mid] > k)
            return binarySearch(a,s,mid-1,k);
        else
            return binarySearch(a,mid+1,e,k);
    }
    public static int[] getSeq(int[] a,int[] dp,int n){
        int[] re = new int[n];
        for(int i=0;i<a.length;i++){
            int index = 0;
            int temp = Integer.MIN_VALUE;
        	for(int j=i;j<a.length;j++){
        		if(dp[j] == index+1 && a[j] > temp){
                    re[index++] = a[j];
                    temp = a[j];
                }
                if(index > n-1)
                	return re;
        	}
        }
        return re;
    }
}