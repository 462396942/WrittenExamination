package wanyi2017;
import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		while(sc.hasNext()){
			set.add(sc.next());
		}
		System.out.println(set.size());
	}

}
