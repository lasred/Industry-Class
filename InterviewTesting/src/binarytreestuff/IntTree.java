package binarytreestuff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;


public class IntTree {
	private IntTreeNode overallRoot;
	
	public IntTree() {
		overallRoot = null;
	}
	//print a binary tree level by level
	public void printByLevel() {
		System.out.print("Elements By Level:");
		if(overallRoot!= null) {
			//for breadth first search
			Queue<IntTreeNode> bfs = new LinkedList<IntTreeNode>();
			bfs.add(overallRoot);
			while(!bfs.isEmpty()) {
				IntTreeNode root = bfs.remove();
				System.out.print(" " + root.data);
				//enqueue left
				if(root.left!=null) 
					bfs.add(root.left);
				if(root.right!=null)
					bfs.add(root.right);
			}
		}
		System.out.println();
	}

	
	public int secondMaximum() {
		return secondMaximum(overallRoot);
	}
	private boolean isLeaf(IntTreeNode root) {
		return root.left == null && root.right == null;
	} 
	private int secondMaximum(IntTreeNode root) {
		if(root == null || isLeaf(root))
			throw new NoSuchElementException();
		if(root.right == null) {
			return findMax(root.left);
		} else {
			return findSecondGreatest(root);
		}
	}
	private int findSecondGreatest(IntTreeNode root) {
		//know that originally root.right is not null
		if(root.right.right == null) 
			if(root.right.left == null) {
				return root.data;
			}else {
				return findMax(root.right.left);
			}
		else 
			return findSecondGreatest(root.right);
	}
	private int findMax(IntTreeNode root) {
		//know that root is not null, from De Morgan's Law, left is not null
		if(root.right == null)
			return root.data;
		else 
			return findMax(root.right);
	}
	public void printLevel(int n) {
		System.out.print("Level " + n +":");
		printLevel(overallRoot, n);
		System.out.println();
	}
	
	private void printLevel(IntTreeNode root, int i) {
		if(root != null) {
			if(i== 0) {
				System.out.print(" " + root.data);
			} else {
				printLevel(root.left, i - 1);
				printLevel(root.right, i - 1);
			}
		}
		
	}

	public boolean isBst() {
		if(overallRoot == null) {
			return true;
		} else {
			if((overallRoot.left != null && overallRoot.left.data > overallRoot.data)
					||(overallRoot.right != null && overallRoot.right.data < overallRoot.data))
				return false;				
			return isBst(overallRoot.left, overallRoot.data, true) &&
					 isBst(overallRoot.right,overallRoot.data, false);
		}	
	}
	private boolean isBst(IntTreeNode root, int grandDaddy, boolean isLeftSub) {
		if(root == null) {
			return true;
		} else {
			if((root.left != null && root.left.data > root.data)
					||(root.right != null && root.right.data < root.data))
				return false;
			if(isLeftSub) {
				//violate any rules of being a left subtree?
				if((root.left != null && root.left.data > grandDaddy)
				||(root.right != null && root.right.data > grandDaddy)) 
					return false;
				return isBst(root.left, root.data, true) && 
						isBst(root.right, grandDaddy, true) &&
						isBst(root.right, root.data, false);
				
			} else {
				//violate any rules of being a right subtree
				if((root.left != null && root.left.data < grandDaddy)
					||(root.right != null && root.right.data < grandDaddy)) 
							return false;
				return isBst(root.right, root.data, false) &&
						isBst(root.left, root.data, true) &&
						isBst(root.left, grandDaddy, false);
			}
		}
	}
	public static void main(String[] args) {
		IntTree tree = new IntTree();
		IntTreeNode node1 = new IntTreeNode(10);
		IntTreeNode node2 = new IntTreeNode(20);
		IntTreeNode node3 = new IntTreeNode(11);
		IntTreeNode node4 = new IntTreeNode(22);
		IntTreeNode node5 = new IntTreeNode(9);
		IntTreeNode node6 = new IntTreeNode(21);

		tree.overallRoot = node1;
		node1.right = node2;
		node2.left = node3;
		node2.right = node4;
		node3.right = node6;
		System.out.println(tree.isBst());
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
