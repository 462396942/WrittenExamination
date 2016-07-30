package tengxun2017shixi;

import java.util.*;

public class test2{
    public static void main(String[] args){
        method();
    }
    
    public static void method(){
        try(Scanner sc = new Scanner(System.in)){
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                char[] ch = s.toCharArray();
                int j = 0;
                for(int i=0;i<ch.length;i++){
                    if(Character.isLowerCase(ch[i])){
                        char temp = ch[i];
                        j = i-1;
                        while(j>=0 && Character.isUpperCase(ch[j])){
                            ch[j+1] = ch[j];
                            j--;
                        }
                        ch[j+1] = temp;
                    }
                }
                System.out.println(new String(ch));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}