package wangyi2016shixi;

import java.util.*;;

/**
 * 有一棵二叉树，树上每个点标有权值，权值各不相同，请设计一个算法算出权值最大的叶节点到权值最小的叶节点的距离。二叉树每条边的距离为1，
 * 一个节点经过多少条边到达另一个节点为这两个节点之间的距离。 给定二叉树的根节点root，请返回所求距离。
 * 
 * 注意：是最大叶节点和最小叶节点的路径
 * 
 * 错误原因：看错题
 * 
 * 两个要点：看题！！ 思考！！
 * 
 * @author zc
 *
 */
public class Test2 {
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;

	public int getDis(TreeNode root) {
		if (root == null)
			return -1;
		// 找到最大叶节点和最小叶节点
		findMaxMin(root);
		// 求出路径
		List<TreeNode> l1 = new ArrayList<TreeNode>();
		List<TreeNode> l2 = new ArrayList<TreeNode>();
		findPath(root, min, l1);
		findPath(root, max, l2);

		// 求出距离
		return findResult(l1, l2);
	}

	public void findMaxMin(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp.val > max && temp.left == null && temp.right == null)
				max = temp.val;
			if (temp.val < min && temp.left == null && temp.right == null)
				min = temp.val;
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);
		}
	}

	public boolean findPath(TreeNode root, int val, List<TreeNode> path) {
		if (root == null)
			return false;
		path.add(root);
		if (root.val == val && root.left == null && root.right == null)
			return true;
		if (findPath(root.left, val, path))
			return true;
		if (findPath(root.right, val, path))
			return true;
		path.remove(path.size() - 1);
		return false;
	}

	public int findResult(List<TreeNode> l1, List<TreeNode> l2) {
		int parentIndex = 0;
		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i) != l2.get(i)) {
				parentIndex = i - 1;
				break;
			}
		}
		return l1.size() - 1 - parentIndex + l2.size() - 1 - parentIndex;
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
