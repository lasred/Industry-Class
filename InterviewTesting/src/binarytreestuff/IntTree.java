package binarytreestuff;


public class IntTree {
	private IntTreeNode overallRoot;
	
	public IntTree() {
		overallRoot = null;
	}
	
	public void add(int number) {
		overallRoot = add(overallRoot, number);
	}
	
	private IntTreeNode add(IntTreeNode root, int number) {
		if(root == null) {
			root = new IntTreeNode(number);
		} else if(number > root.data){
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
