package jinritoutiao2017kehuduanshixi;

import java.util.*;

/**
 * ����Ϊһ�������ĸ�������Ҫ���Լ��ĵ�һ��ר���ˣ���ƻ���¼ n �׸����ÿ�׸�ĳ��ȶ��� s �룬ÿ�׸������������¼��һ�� CD ���С�ÿ�� CD
 * ���������ȶ��� L �룬���������ٵñ�֤ͬһ�� CD ���������׸��м�����Ҫ�� 1 �롣Ϊ�˱�а�����������һ�� CD �ڵĸ������ܱ� 13
 * ���������������ô�����������ר��������Ҫ������ CD ��
 * 
 * @author zhoucong
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int L = sc.nextInt();
			int re = method(n, s, L);
			System.out.println(re);
		}
	}

	public static int method(int n, int s, int L) {
		int per = L / (s + 1);
		// ǡ�ÿ��Է������һ����
		if (per * (s + 1) + s == L)
			per++;
		// ��13�ı���
		if (per != 0 && per % 13 == 0)
			per--;
		int re = (int) Math.ceil((n * 1.0) / per);
		if(re == 1){
			if(n%13==0)
				re++;
			return re;
		}
		// z���һ��cd������ʮ13����
		if (n % per % 13 == 0 && n%per == per-1)
			re++;
		return re;
	}
}
