package wangyi2016yanfa;
import java.util.*;

/**
 * Сv������n�ſΣ�ÿ�Ŷ��п��ԣ�Ϊ���õ���ѧ��Сv�������Լ���ƽ���ɼ�����Ϊavg��
 * ÿ�ſ���ƽʱ�ɼ��Ϳ��Գɼ���ɣ�����Ϊr��������֪��ÿ�ſε�ƽʱ�ɼ�Ϊai ,���������ſεĿ��Գɼ�����һ�ֵĻ���
 * СvҪ��bi ��ʱ�临ϰ������ϰ�Ļ���Ȼ����0�֡�ͬʱ������Ȼ���Է��ָ�ϰ���ٶ�Ҳ�����õ��������ֵķ�����Ϊ���õ���ѧ��Сv����Ҫ������ʱ�临ϰ
 * 
 * ����ط����漰�����Ҫ�����˵ģ�ǧ��Ҫ��long������������int���������
 * 
 * ̰���㷨�����⻹��һ�����Ƕ�ά����ıȽ��������Կ���
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
		//��bi��������
		Arrays.sort(a,new Comparator<int[]>(){
			public int compare(int[] a,int[] b){
				return a[1]-b[1];
			}
		});
		
		//�ܷ���
		int sumScore = 0;
		for(int i=0;i<n;i++)
			sumScore += a[i][0];
		
		//��ʱ��
		long sumTime = 0;
		for(int i=0;i<n;i++){
			//��ǰ��Ŀ����
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
