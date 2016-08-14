package wangyi2016shixi;

import java.util.*;
/**
 * ��һ�ö�����������ÿ�������Ȩֵ��Ȩֵ������ͬ�� 
 * �����һ���㷨���Ȩֵ����Ҷ�ڵ㵽Ȩֵ��С��Ҷ�ڵ�ľ��롣
 * ������ÿ���ߵľ���Ϊ1��һ���ڵ㾭���������ߵ�����һ���ڵ�Ϊ�������ڵ�֮��ľ��롣
 *  �����������ĸ��ڵ�root���뷵��������롣
 * 
 * @author zhoucong
 *
 */
public class Test2 {
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(1);
		
		t1.left = t2;
		t2.left = t3;
		t1.right = t4;
		
		Test2 t = new Test2();
		System.out.println(t.getDis(t1));
	}
    public int getDis(TreeNode root) {
    	if(root == null)
    		return -1;
    	//��α����ҵ����ڵ����С�ڵ�
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	q.offer(root);
    	while(!q.isEmpty()){
    		TreeNode temp = q.poll();
    		if(temp.val > max)
    			max = temp.val;
    		if(temp.val < min)
    			min = temp.val;
    		if(temp.left != null)
    			q.offer(temp.left);
    		if(temp.right != null)
    			q.offer(temp.right);
    	}
    	
    	List<TreeNode> ml = new ArrayList<TreeNode>();
    	findPath(root,max,ml);
    	List<TreeNode> sl = new ArrayList<TreeNode>();
    	findPath(root,min,sl);
    	int parentIndex = 0;
    	for(int i=0;i<ml.size();i++){
    		if(ml.get(i) != sl.get(i)){
    			parentIndex = i-1;
    			break;
    		}
    	}
    	return ml.size()-1-parentIndex + sl.size()-1-parentIndex;
    }
    public boolean findPath(TreeNode root,int k,List<TreeNode> path){
    	if(root == null)
    		return false;
    	path.add(root);
    	if(root.val == k)
    		return true;
    	if(findPath(root.left, k, path))
    		return true;
    	if(findPath(root.right, k, path))
    		return true;
    	path.remove(path.size()-1);
    	return false;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
