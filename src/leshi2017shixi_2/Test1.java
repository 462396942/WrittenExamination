package leshi2017shixi_2;

import java.util.Scanner;

/**
 * ����ļ�������ϣ���ʦ��ͬѧ�ǳ���һ���⣺ ����n�������뽫���е�ż���Ķ����Ʒ�ת�� eg������1 6 5
 * ����6��ż���������Ʊ�ʾΪ110����ת��Ϊ011������3�������������1 3 5.
 * С����������Ӳ���ô��ʹ�����˰���Ҳû���������������������Ѱ������ˣ���������С�����ɣ�
 * 
 *  ���㣺λ����
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
				//�˴�ע�����һ��������û�пո񣬣�ע�������ʽ������
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
