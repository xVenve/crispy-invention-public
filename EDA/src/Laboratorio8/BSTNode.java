package Laboratorio8;
//these packages are used to implement the showLevel method
//the interface for a queue
import java.util.Queue;
//the implementation of a Queue
import java.util.LinkedList;

public class BSTNode implements IBSTNode {

	Integer key;
	String  elem;
	
	//reference to its parent
	BSTNode parent;
	//reference to its left child
	BSTNode left;
	//reference to its right child
	BSTNode right;
	
	//Constructor
	public BSTNode(Integer key, String elem) {
		this.key=key;
		this.elem=elem;
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
	
	//A recursive version to obtain the depth of the invoking node
	public int getRecDepth1() {
		if (this.parent==null) return 0;
		else return this.parent.getRecDepth2();
	}
		
	//Another recursive version 	using an auxiliary method
	//I think that this is more elegant than the previous one
	public int getRecDepth2() {
		return getRecDepth2(this);
	}
	protected static int getRecDepth2(BSTNode node) {
		if (node==null) return 0;
		else return 1 + getRecDepth2(node.parent);
	}
	
	//returns the number of the subtree than hangs from the invoking node
	public int getSize() {
		return getSize(this);
	}
	protected static int getSize(BSTNode node) {
		if (node==null) return 0;
		else return 1 + getSize(node.left)+getSize(node.right);
	}
	
	//a recursive version that does not use an auxiliary method
	//I don't like it, but it's right
	public int getSize2() {
		int result;
		if (this.left==null && this.right==null) 
			result=1;
		else if (this.left!=null && this.right!=null) 
			result= 1 + this.left.getSize2()+this.right.getSize2();
		else if (this.left!=null)
			result= 1 + this.left.getSize2();
		else //(this.right!=null)
			result= 1 + this.right.getSize2();
		return result;
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
			System.out.print(node.key+"\t");
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
				System.out.print(node.key+"\t");
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
				System.out.print(node.key+"\t");
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
			System.out.print(current.key+"\t");
			//now, we add the its two children
			if (current.left!=null) queue.add(current.left);
			if (current.right!=null) queue.add(current.right);
			
		}
	}

	public static void main(String args[]) {
		//We want to build the follow tree:
		//				5
		//		3				8
		//					6		9
		
		//YOU SHOULD NEVER IMPLEMENT THIS CODE!!!
		//YOU SHOULD ALWAYS USE THE INSERT METHOD OF A TREE
		//HOWEVER, WE DON'T HAVE IT YET.
		BSTNode root=new BSTNode(5,"aaa");
		BSTNode left1=new BSTNode(3,"abc");
		BSTNode right1=new BSTNode(8,"ddd");
		root.left=left1;
		left1.parent=root;
		root.right=right1;
		right1.parent=root;
		
		//children for right1
		BSTNode left2=new BSTNode(6,"eee");
		BSTNode right2=new BSTNode(9,"fff");
		right1.left=left2;
		left2.parent=right1;
		right1.right=right2;
		right2.parent=right1;

		System.out.println("getDepth for " + root.key + " is="+ root.getDepth());
		System.out.println("getDepth for " + left1.key + " is="+ left1.getDepth());
		System.out.println("getDepth for " + right1.key + " is="+ right1.getDepth());
		System.out.println("getDepth for " + left2.key + " is="+ left2.getDepth());
		System.out.println("getDepth for " + right2.key + " is="+ right2.getDepth());

		System.out.println();
		
		System.out.println("getSize for " + root.key + " is="+ root.getSize());
		System.out.println("getSize for " + left1.key + " is="+ left1.getSize());
		System.out.println("getSize for " + right1.key + " is="+ right1.getSize());
		System.out.println("getSize for " + left2.key + " is="+ left2.getSize());
		System.out.println("getSize for " + right2.key + " is="+ right2.getSize());
		System.out.println();
		
		System.out.println("getHeight for " + root.key + " is="+ root.getHeight());
		System.out.println("getHeight for " + left1.key + " is="+ left1.getHeight());
		System.out.println("getHeight for " + right1.key + " is="+ right1.getHeight());
		System.out.println("getHeight for " + left2.key + " is="+ left2.getHeight());
		System.out.println("getHeight for " + right2.key + " is="+ right2.getHeight());
		System.out.println();
		
		System.out.println("in-order traversal:");
		root.showInOrder();
		
		System.out.println("post-order traversal:");
		root.showPostOrder();
		
		System.out.println("pred-order traversal:");
		root.showPreOrder();
		
		System.out.println("leveled traversal:");
		root.showLevels();
		
	}
}
