package leshi2017shixi2;

import java.util.*;

/**
 * Charm=Sum of all D(i)������D(i)=k-i��iΪ�������о���i���±꣬ kΪλ��i�����Һ�i��ͬһ�־���ľ����±ꡣ
 * �������еľ�����<�������� ����>�ĸ�ʽ����������Ҫ������о��������˳��ʹ������ֵ���
 * ����ж������з�ʽ��������������������������ֵ�����С��һ����
 *
 * �㷨�����⣬������������ģ�������̣��ҳ����ɡ�
 * �������в������ѵĻ����ַ���������
 * @author zc
 *
 */
public class Test3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			Map<String,Integer> map = new TreeMap<String,Integer>();
			for(int i=0;i<n;i++){
				map.put(sc.next(), sc.nextInt());
			}
			method(map);
		}
	}
	public static void method(Map<String,Integer> map){
		StringBuilder l = new StringBuilder();
		StringBuilder r = new StringBuilder();
		StringBuilder m = new StringBuilder();
		
		//����������2��Ԫ�طŵ���β����һ��
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			if(entry.getValue() > 1){
				l.append(entry.getKey()+" ");
				r.append(entry.getKey()+" ");
				map.put(entry.getKey(),entry.getValue()-2);
			}
		}
		//����ʱ��������0��Ԫ�ز嵽�м�
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			int v = entry.getValue();
			while(v > 0){
				m.append(entry.getKey()+" ");
				v--;
			}
		}
		String re = l.append(m).append(r).toString();
		//ע�⴦��ĩβ���ո�
		System.out.println(re.trim());
	}
}
