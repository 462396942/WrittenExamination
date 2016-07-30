package tengxun2017shixi;

import java.util.*;

public class test3 {
	public static void main(String[] args) {
		method();
	}

	public static void method() {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNextInt()) {
				int len = sc.nextInt();
				if(len == 0 || len == 1){
					System.out.println("0 0");
					break;
				}
				int[] arr = new int[len];
				int index = 0;
				while (index < len) {
					arr[index] = sc.nextInt();
					index++;
				}
				Arrays.sort(arr);
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int i = 0; i < len - 1; i++) {
					int sub = Math.abs(arr[i + 1] - arr[i]);
					if (map.containsKey(sub))
						map.put(sub, map.get(sub) + 1);
					else
						map.put(sub, 1);

				}
				findMin(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int findMin(Map<Integer, Integer> map) {
		int minSub = Integer.MAX_VALUE;
		//ÕÒ×îÐ¡
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() < minSub)
				minSub = entry.getKey();
		}

		return map.get(minSub);
	}
	
	public static int findMax(int[] arr){
		//TODO
		return 0;
	}
}
