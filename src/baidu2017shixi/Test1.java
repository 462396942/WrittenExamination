package baidu2017shixi;

import java.util.*;

public class Test1{
    
    public static void main(String[] args){
        method();
    }
    
    public static void method(){
        try(Scanner sc = new Scanner(System.in)){
            while(sc.hasNextInt()){
                int len = sc.nextInt();
                String[] arr = new String[len];
                int index = 0;
                while(index < len){
                    arr[index++] = sc.next(); 
                }
                System.out.println(isJieLong(arr));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static String isJieLong(String[] a){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(String s : a){
            char c = s.charAt(0);
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        boolean flag = false;  //首尾可能有一对字符无法对应，即接龙首和接龙尾
        for(String s : a){
            char c = s.charAt(s.length()-1);
            if(!map.containsKey(c) || map.get(c) == 0){
                if(!flag)
                    flag = true;
                else
                    return "No";
            }
            else{
                map.put(c,map.get(c)-1);
            }
        }
        return "Yes";
        
    }
}