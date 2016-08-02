package baidu2017shixi;

import java.util.*;

public class Test3{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        	int n = sc.nextInt();
        	Task[] a = new Task[n];
        	for(int i=0;i<n;i++){
        		Task t = new Task(sc.nextInt(),sc.nextInt());
        		a[i] = t;
        	}
        	method(a);
        }
    }    
	public static void method(Task[] a){
		//按照优先级排序，
		Arrays.sort(a,new Comparator<Task>(){
			public int compare(Task t1,Task t2){
				if(t1.come > t2.come)
					return 1;
				else if(t1.come < t2.come)
					return -1;
				else{
					if(t1.need > t2.need)
						return 1;
					else
						return -1;
				}
			}
		});
		int cur = 0;
		int all = 0;
		for(int i=1;i<a.length;i++){
			cur = cur + (a[i-1].need + a[i-1].come - a[i].come);
			all += cur;
		}
		double re = all/(double)a.length;
		String s = String.format("%.4f", re);
		System.out.println(s);
	}
}
class Task{
	int come;
	int need;
	public Task(int come,int need){
		this.come = come;
		this.need = need;
	}
}