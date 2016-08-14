package saima2017;
import java.util.*;

public class Test2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++){
			int n = sc.nextInt();
			//存人和分数
			Map<String,Integer> map = new HashMap<String,Integer>();
			//存人和出现顺序
			Map<String,Integer> mapIndex = new HashMap<String,Integer>();
			int index = 0;
			for(int j=0;j<n;j++){
				String name = sc.next();
				int score = sc.nextInt();
				if(!map.containsKey(name))
					map.put(name,score);
				else
					map.put(name, map.get(name)+score);
				
				if(!mapIndex.containsKey(name))
					mapIndex.put(name, index++);
			}
			method(map,mapIndex);
		}
	}
	public static void method(Map<String,Integer> map,Map<String,Integer> mapIndex){
		//按分数降序排序
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> e1,Map.Entry<String, Integer> e2){
				return e2.getValue() - e1.getValue();
			}
		});
		//有重复
		
		if(list.get(0).getValue() == list.get(1).getValue()){
			int value = list.get(0).getValue();
			int firIndex = Integer.MAX_VALUE;
			String firName = null;
			for(Map.Entry<String, Integer> e : list){
				if(e.getValue() == value){
					int cur = mapIndex.get(e.getKey());
					if(cur < firIndex){
						firIndex = cur;
						firName = e.getKey();
					}
				}
			}
			
			System.out.println(firName);
		}
		else
			System.out.println(list.get(0).getKey());
	}
}
