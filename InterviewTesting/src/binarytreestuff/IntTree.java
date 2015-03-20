package binarytreestuff;

import java.util.ArrayList;
import java.util.List;


public class IntTree {
	private IntTreeNode overallRoot;
	
	public IntTree() {
		overallRoot = null;
	}
	
	public void add(int number) {
		overallRoot = add(overallRoot, number);
	}
	/**
	 * Return the largest sum of any path from root to leaf 
	 * @return
	 */
	public List<Integer> largestSumFromRootPath() {
		List<Integer> path = new ArrayList<Integer>();
		 largestSumFromRootPath(overallRoot,path);
		return path;
	}
	
	private void largestSumFromRootPath(IntTreeNode root, List<Integer> list) {
		if(root!= null) {
			list.add(root.data);
			int leftSum = sum(root.left);
			int rightSum = sum(root.right);
			if(leftSum > rightSum) {
				largestSumFromRootPath(root.left, list);
			} else {
				largestSumFromRootPath(root.right, list);
			}
		}
	}
	
	private int sum(IntTreeNode root) {
		if(root!= null) {
			int d = root.data;
			return Math.max(d + sum(root.left), d + sum(root.right));
		}
		return 0;
	}
	private IntTreeNode add(IntTreeNode root, int number) {
		if(root == null) {
			root = new IntTreeNode(number);
		} else if(number < root.data){
			root.left = add(root.left, number);
		} else {
			root.right = add(root.right, number);
		}
		return root;
	}
	
	public void printInorder() { 
		System.out.println("inorder:");
		printInorder(overallRoot);
		System.out.println();
	}
	
	public int secondLargest() {
		if(overallRoot == null || isChildNode(overallRoot)) {
			throw new IllegalStateException("Only one node or no nodes");
		} else {
			return secondLargest(overallRoot);
		}
	}
	private boolean isChildNode(IntTreeNode root) {
		return root.left == null && root.right == null;
	}
	private int secondLargest(IntTreeNode root) {
		if(root.right != null) {
			if(isChildNode(root.right)) {
				return root.data;
			} else {
				return secondLargest(root.right);
			}
		} else {
			return rightMost(root.left);
		}
	} 
	private int rightMost(IntTreeNode root) {
		if(root.right == null) {
			return root.data;
		} else {
			return rightMost(root.right);
		}
   }
	
	private void printInorder(IntTreeNode root) {
		if(root != null) {
			//left, root, right
			//traverse left
			printInorder(root.left);
			//print root's data 
			System.out.println(" " + root.data);
			printInorder(root.right);
		}
	}
	public void printPostOrder() {
		System.out.print("postorder:");
		printPostOrder(overallRoot);
		System.out.println();
	}
	private void printPostOrder(IntTreeNode root) {
		if(root!= null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(" " + root.data );
		}
	}
	
	public void printPreorder() {
		System.out.print("preorder:");
		printPreorder(overallRoot);
		System.out.println();
	}
	
	//root of a subtree
	private void printPreorder(IntTreeNode root) {
		//only do printing under this condition
		if(root != null) {
			System.out.println(" " + root.data);
			//traverse left
			printPreorder(root.left);
			//traverse right
			printPreorder(root.right);
		}
		//if null, don't do anything
	}
}
