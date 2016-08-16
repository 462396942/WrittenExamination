package baidu2017shixi;

import java.util.*;

/**
 * 短作业优先（SJF, Shortest Job First）又称为“短进程优先”SPN(Shortest Process
 * Next)；是对FCFS算法的改进，其目标是减少平均周转时间。 短作业优先调度算法基于这样一种思想： 运行时间短的优先调度；
 * 如果运行时间相同则调度最先发起请求的进程。 PS:本题题面描述有误，但原题如此，不宜修改，实际优先级如下: 1)接到任务的时间； 2)
 * 如果接收时间相同则调度 运行时间最短的任务。 等待时间：一个进程从发起请求到开始执行的时间间隔。
 * 现在有n个进程请求cpu，每个进程用一个二元组表示：(p,q),p代表该进程发起请求的时间，p代表需要占用cpu的时间。 请计算n个进程的平均等待时间。
 * 
 * 
 * 对于二维数组，感觉处理起来复杂的，就自定义对象
 * @author zc
 *
 */
public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Task[] a = new Task[n];
			for (int i = 0; i < n; i++) {
				Task t = new Task(sc.nextInt(), sc.nextInt());
				a[i] = t;
			}
			method(a);
		}
	}

	public static void method(Task[] a) {
		// 按照优先级排序，
		Arrays.sort(a, new Comparator<Task>() {
			public int compare(Task t1, Task t2) {
				if (t1.come > t2.come)
					return 1;
				else if (t1.come < t2.come)
					return -1;
				else {
					if (t1.need > t2.need)
						return 1;
					else
						return -1;
				}
			}
		});
		int cur = 0;
		int all = 0;
		for (int i = 1; i < a.length; i++) {
			cur = cur + (a[i - 1].need + a[i - 1].come - a[i].come);
			all += cur;
		}
		double re = all / (double) a.length;
		String s = String.format("%.4f", re);
		System.out.println(s);
	}
}

class Task {
	int come;
	int need;

	public Task(int come, int need) {
		this.come = come;
		this.need = need;
	}
}