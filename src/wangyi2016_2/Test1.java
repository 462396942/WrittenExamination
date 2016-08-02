package wangyi2016_2;
import java.util.*;

/**
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
 * 每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，
 * 小v要花bi 的时间复习，不复习的话当然就是0分。同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习
 * 
 * 错误地方：涉及到结果要相加相乘的，千万要用long！！！！，用int很容易溢出
 * 
 * 贪心算法，此题还有一处就是二维数组的比较器。可以看看
 * @author zc
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int r = sc.nextInt();
			int avg = sc.nextInt();
			int[][] a = new int[n][2];
			for(int i=0;i<n;i++){
				a[i][0] = sc.nextInt();
				a[i][1] = sc.nextInt();
			}
			long re = method(a,n,r,avg);
			System.out.println(re);
		}
	}
	public static long method(int[][] a,int n,int r,int avg){
		//按bi降序排序
		Arrays.sort(a,new Comparator<int[]>(){
			public int compare(int[] a,int[] b){
				return a[1]-b[1];
			}
		});
		
		//总分数
		int sumScore = 0;
		for(int i=0;i<n;i++)
			sumScore += a[i][0];
		
		//总时间
		long sumTime = 0;
		for(int i=0;i<n;i++){
			//当前科目分数
			int all = a[i][0];
			while(all < r && sumScore < avg*n){
				sumTime += a[i][1];
				sumScore++;
				all++;
			}
			if(sumScore >= avg*n)
				break;
		}
		return sumTime;
	}

}
