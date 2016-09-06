package 涂鸦移动2017neitui;

import java.util.*;

/**
 * 1将链表中的所有元素为奇数的节点移到元素为偶数节点的前面，并使奇数之间顺序反转，偶数之间顺序反转。
 * 
 * @author zhoucong
 *
 */
class Node {
	public Node next;
	public int value;
	//为了测试，添加以下构造函数
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
	 * 思路，保存偶数节点的前一个节点pre，遍历链表遇到偶数节点查到pre后面，遇到技术节点查到head（哨兵节点）后面
	 * @param list
	 * @return
	 */
	public Node swap(Node list) {
		if (list == null || list.next == null)
			return list;
		// 哨兵头节点,防止pre为null
		Node head = new Node(0);
		head.next = list;
		// 指向偶数节点的前驱
		Node pre = head;
		// 处理起一个节点
		Node p = list, q = p;
		if (p.value % 2 != 0)
			pre = p;
		q = p.next;
		p.next = null;
		//奇数移到头节点后面，偶数移到pre后面
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
