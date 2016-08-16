package wangyi2015Java;
import java.util.*;

/**
 * 有两个有序的集合，集合的每个元素都是一段范围，求其交集，例如集合{[4,8],[9,13]}和{[6,12]}的交集为{[6,8],[9,12]}
 * 
 * 二维数组可以转换为一维数组，通过将数组内层转化为自定义类
 * @author zc
 *
 */
public class Test2 {
	public static void main(String[] args){
		Range r1=new Range(4, 8);
        Range r2=new Range(9, 13);
        Range r3=new Range(6, 12);
        Range r4=new Range(7, 10);
        Range[] aR=new Range[]{r1,r2};
        Range[] bR=new Range[]{r3,r4};
        List<Range> result=method(aR, bR);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
	}
	
	public static List<Range> method(Range[] r1,Range[] r2){
		List<Range> list = new ArrayList<Range>();
		if(r1 == null || r2 == null)
			return list;
		for(int i=0;i<r1.length;i++){
			for(int j=0;j<r2.length;j++){
				//只有当下式满足时才有交集
				if(r2[j].left <= r1[i].right){
					//左边界取二者左侧的最大值
					int left = r1[i].left > r2[j].left ? r1[i].left : r2[j].left;
					//右边界取二者右侧的最小值
					int right = r1[i].right < r2[j].right ? r1[i].right : r2[j].right;
					Range r = new Range(left,right);
					list.add(r);
				}
			}
		}
		return list;
	}
}

class Range{
	int left;
	int right;
	public Range(int left,int right){
		this.left = left;
		this.right = right;
	}
	@Override
	public String toString() {
		return "Range [left=" + left + ", right=" + right + "]";
	}
	
}
