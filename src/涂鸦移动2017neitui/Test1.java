package Ϳѻ�ƶ�2017neitui;

import java.util.*;

/**
 * 1�������е�����Ԫ��Ϊ�����Ľڵ��Ƶ�Ԫ��Ϊż���ڵ��ǰ�棬��ʹ����֮��˳��ת��ż��֮��˳��ת��
 * 
 * @author zhoucong
 *
 */
class Node {
	public Node next;
	public int value;
	//Ϊ�˲��ԣ�������¹��캯��
	public Node(int val) {
		this.value = val;
	}
}

public class Test1 {
	public static void main(String[] args) {
		Node n1 = new Node(4);
		Node n2 = new Node(2);
		Node n3 = new Node(5);
		Node n4 = new Node(7);
		Node n5 = new Node(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		Test1 t = new Test1();
		Node h = t.swap(n1);
		while (h != null) {
			System.out.println(h.value);
			h = h.next;
		}
	}
	/**
	 * ˼·������ż���ڵ��ǰһ���ڵ�pre��������������ż���ڵ�鵽pre���棬���������ڵ�鵽head���ڱ��ڵ㣩����
	 * @param list
	 * @return
	 */
	public Node swap(Node list) {
		if (list == null || list.next == null)
			return list;
		// �ڱ�ͷ�ڵ�,��ֹpreΪnull
		Node head = new Node(0);
		head.next = list;
		// ָ��ż���ڵ��ǰ��
		Node pre = head;
		// ������һ���ڵ�
		Node p = list, q = p;
		if (p.value % 2 != 0)
			pre = p;
		q = p.next;
		p.next = null;
		//�����Ƶ�ͷ�ڵ���棬ż���Ƶ�pre����
		while (q != null) {
			Node temp = q.next;
			if (q.value % 2 == 0) {
				q.next = pre.next;
				pre.next = q;
			} else {
				if(head.next.value %2 == 0)
					pre = q;
				q.next = head.next;
				head.next = q;
			}
			q = temp;
		}
		return head.next;
	}
}
