package tengxun2017shixi;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		method();
	}
	
	public static void method(){
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNextLine()){
				String a = sc.nextLine();
//				if(a == null){
//					System.out.println(-1);
//					return;
//				}

				String b = reverse(a);
				int len = a.length();
			    int[][] dp = new int[len+1][len+1];
			    for(int i=0;i<=len;i++){
			        for(int j=0;j<=len;j++){
			            if(i == 0 || j == 0)
			                dp[i][j] = 0;
			            else{
			                if(a.charAt(i-1) == b.charAt(j-1))
			                    dp[i][j] = dp[i-1][j-1] + 1;
			                else
			                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			            }
			        }
			    }
			    System.out.println(len-dp[len][len]);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}	    
	}
	
	public static String reverse(String a){
		StringBuilder sb = new StringBuilder();
	    int len = a.length();
	    for(int i =len-1;i>=0;i--){
	        sb.append(a.charAt(i));
	    }
	    return sb.toString();
	}

}
