package wanmei2017shixi;
import java.util.*;
/**
 * 求最长递增子序列长度。。搞笑呢么这不，看看网易那难度在看看你，长点心把
 * 
 * @author zhoucong
 *
 */
public class Test1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++)
                a[i] = sc.nextInt();
            int re = method(a,n);
            System.out.println(re);
        }
    }
    public static int method(int[] a,int n){
        int[] dp = new int[n];
        int len = 0;
        for(int i : a){
            int index = binarySearch(dp,0,len-1,i);
            if(index == len)
                len++;
            dp[index] = i;
        }
        return len;
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
}