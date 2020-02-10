package phase2;
//these packages are used to implement the showLevel method
//the interface for a queue
import java.util.Queue;

import phase1.Student;

//the implementation of a Queue
import java.util.LinkedList;

public class BSTNode implements IBSTNode {

	String key;
	Student oStudent;
	
	//reference to its parent
	BSTNode parent;
	//reference to its left child
	BSTNode left;
	//reference to its right child
	BSTNode right;
	
	//Constructor
	public BSTNode(Student oStudent) {
		this.key=oStudent.email;
		this.oStudent=oStudent;
	}
		
	//returns the depth of the invoking node
	//an iterative version
	
	public int getDepth() {
		int depth=0;
		//we need to define a variable node,
		//that allows us to ascend through its ancestors
		//until we reach the root
		BSTNode node=this.parent;
		while (node!=null) {
			depth++;
			node=node.parent;
		}
		return depth;
	}
	
	
	
	//returns the number of the subtree than hangs from the invoking node
	public int getSize() {
		return getSize(this);
	}
	protected static int getSize(BSTNode node) {
		if (node==null) return 0;
		else return 1 + getSize(node.left)+getSize(node.right);
	}
	

	//return the height of the node (which is the longest path 
	//from the node to any leaf)
	public int getHeight() {
		return getHeight(this);
	}
	protected static int getHeight(BSTNode node) {
		if (node==null) return 0;
		else return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	//shows the nodes of the subtree in pre-order
	public void showPreOrder() {
		showPreOrder(this);
		System.out.println();
	}
	protected static void showPreOrder(BSTNode node) {
		if (node!=null) {
			System.out.print(node.oStudent.toString()+"\t");
			showPreOrder(node.left);
			showPreOrder(node.right);
			
		}
	}
	
	//shows the nodes of the subtree in in-order
		public void showInOrder() {
			showInOrder(this);
			System.out.println();
		}
		protected static void showInOrder(BSTNode node) {
			if (node!=null) {
				showInOrder(node.left);
				System.out.println(node.oStudent.toString());
				showInOrder(node.right);
				
			}
		}

		//shows the nodes of the subtree in in-order
		public void showPostOrder() {
			showPostOrder(this);
			System.out.println();
		}
		protected static void showPostOrder(BSTNode node) {
			if (node!=null) {
				showPostOrder(node.left);
				showPostOrder(node.right);
				System.out.println(node.oStudent.toString());
			}
		}

	@Override
	public void showLevels() {
		//we define a queue of BSTNodes.
		//Queue is an interface
		//LinkedList is the implementation
		//Java allows us to create collections of generic types
		//with <>... in our case, we choose BSTNode.
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		//we add the current node
		queue.add(this);
		
		while (!queue.isEmpty()) {
			BSTNode current=queue.poll();
			System.out.println(current.oStudent.toString());
			//now, we add the its two children
			if (current.left!=null) queue.add(current.left);
			if (current.right!=null) queue.add(current.right);
			
		}
	}

	
	private static boolean equals(BSTNode obj1, BSTNode obj2) {
		if (obj1==null && obj2==null) return true;
		if ((obj1==null && obj2!=null) ||(obj1!=null && obj2==null)) return false;
		
		Student s1=obj1.oStudent;
		Student s2=obj2.oStudent;
		if ((s1==null && s2!=null) ||(s1!=null && s2==null)) return false;
		
		if (s1!=null && s2!=null) {
			if (!s1.equals(s2)) return false;
		}
		
		//s1=s2=null or are equals
		return equals(obj1.left,obj2.left) && equals(obj1.right,obj2.right);
		
		
	}
	
	public  boolean equals(BSTNode obj) {
		return equals(this,obj);
	}
	


	
	
	
}
