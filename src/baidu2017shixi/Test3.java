package baidu2017shixi;

import java.util.*;

public class Test3{
	public static void main(String[] args){
        method();
    }    
    public static void method(){
        try(Scanner sc = new Scanner(System.in)){
            while(sc.hasNextLine()){
                int len = sc.nextInt();
                ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> list1 = new ArrayList<Integer>();
                int index = 0;
                while(index < len){
                    list1.add(sc.nextInt());
                    list1.add(sc.nextInt());
                    list.add(list1);
                    index++;
                }
                System.out.println(sjf(list));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static String sjf(ArrayList<ArrayList<Integer>> list){
        Collections.sort(list,new Comparator<ArrayList<Integer>>(){
           public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
               if(a.get(1)>b.get(1))
                   return 1;
               else if(a.get(1)<b.get(1))
                   return -1;
               else{
                   return a.get(0)-b.get(0);
               }
           } 
        });
        int sum = 0;
        int delay = 0;
        for(int i=0;i<list.size();i++){
            
            int temp = Math.max(sum-list.get(i).get(0),0);
            delay += temp;    
            sum += list.get(i).get(1);
        }
        java.text.DecimalFormat df=new java.text.DecimalFormat("#.####");   
        return df.format(delay/list.size());
    }
}