/**
 * Created by epttwxz on Apr 10, 2017
 */
package _LeetcodeLoop;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

import Tree.TreeNode;
import Tree.TreeUtil;

import static org.junit.Assert.assertTrue;

public class _226InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root!=null){
			TreeNode left = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(left);
		}
		return root;
	}
	public TreeNode invertTree_non_recur(TreeNode root){
		if(root!=null){
			Deque<TreeNode> nodes = new LinkedList<>();  // double-ll permits null
			nodes.offer(root);
			while(!nodes.isEmpty()){
				TreeNode cur_root = nodes.poll();
				TreeNode left = cur_root.left;
				cur_root.left = cur_root.right;
				cur_root.right = left;
				if(cur_root.left!=null)
					nodes.offer(cur_root.left);
				if(cur_root.right!=null)
					nodes.offer(cur_root.right);
			}
		}
		return root;
	}
	@Test
	public void print_tree(){
		TreeNode root = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,11,13,14,15});
		System.out.println(root);
		TreeNode root_new = new _226InvertBinaryTree().invertTree_non_recur(root);
		System.out.println(root_new);
	}
    @Test
    public void test2() {
        TreeNode node = TreeUtil.convertArrayToTree(new Integer[]{1, null, 3});
        TreeNode target = TreeUtil.convertArrayToTree(new Integer[]{1, 3});
        TreeNode node_inverted = new _226InvertBinaryTree().invertTree(node);
        assertTrue(node_inverted.equals(target));
    }
    @Test
    public void test3(){
        TreeNode node = TreeUtil.convertArrayToTree(new Integer[]{1, null, 2,null, 3});
        TreeNode target = TreeUtil.convertArrayToTree(new Integer[]{1, 2, null, 3});
        TreeNode node_inverted = new _226InvertBinaryTree().invertTree(node);
        assertTrue(node_inverted.equals(target));
    }
    @Test
    public void test4(){
        TreeNode node = TreeUtil.convertArrayToTree(new Integer[]{1, null, 2, 3, null, 4});
        TreeNode target = TreeUtil.convertArrayToTree(new Integer[]{1, 2, null, null, 3, null, 4});
        TreeNode node_inverted = new _226InvertBinaryTree().invertTree(node);
        assertTrue(node_inverted.equals(target));
    }
}
