package baidu2017shixi;

import java.util.*;

public class Test2{
	public static void main(String[] args){
        method();
    }
    public static void method(){
        try(Scanner sc = new Scanner(System.in)){
            while(sc.hasNextLine()){
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[] a = new int[m];
                int index = 0;
                while(index < m){
                    a[index++] = sc.nextInt();
                }
                System.out.println(fifo(n,a));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int fifo(int n,int[] a){
        Queue<Integer> q = new LinkedList<Integer>();
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        int time = 0;
        for(int i : a){
            if(!map.containsKey(i) || map.get(i) == false){
                if(q.size() == n){
                    map.put(q.poll(),false);
                }
                q.offer(i);
                time++;
                map.put(i,true);
            }
        }
        return time;
    }
}