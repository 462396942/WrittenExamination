package wanyi2017;
import java.util.*;

public class Test3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			String[] a = new String[n];
			for(int i=0;i<n;i++){
				a[i] = sc.next();
			}
			method(n,m,a);
		}
	}
	public static void method(int n,int m,String[] s){
		//求出价值数组
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++){
			char[] c = s[i].toCharArray();
			for(int j=0;j<m;j++){
				a[i][j] = c[j]-'0';
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for(int i0=0;i0<n-3;i0++){
			for(int i1= i0+1;i1<n-2;i1++){
				for(int i2=i1+1;i2<n-1;i2++){
					for(int j0=0;j0<m-3;j0++){
						for(int j1=j0+1;j1<m-2;j1++){
							for(int j2=j1+1;j2<m-1;j2++){
								list.add(findMin(a,i0,i1,i2,j0,j1,j2));
							}
						}
					}
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}
	public static int findMin(int[][] a,int i0,int i1,int i2,int j0,int j1,int j2){
		
		int sum = 0;
		for(int i=0;i<=i0;i++){
			for(int j=0;j<=j0;j++){
				sum += a[i][j];
			}
		}
	}
}
