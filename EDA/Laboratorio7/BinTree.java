package Laboratorio7;


public class BinTree  {
	public BinTreeNode root;

	public BinTree(BinTreeNode rootNode) {
		root = rootNode;
	}

	/**
	 * The size of a tree is equal to the size of its root 
	 * @return
	 */
	public int getSize() {
		return getSize(root);
	}
	
	
	/**
	 * Auxiliary method that receives a node and calculates its size, that is, the size of its subtree
	 * 
	 * Based on OOP (object oriented programming) principles, the method should be static. 
	 * Moreover, the method should belong to the BinTreeNode class.
	 * However, we decided to relax these OOP principles in order to focus on the main ADT concepts.  
	 * @param node
	 * @return
	 */
	public static int getSize(BinTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int result = 1 + getSize(node.left) + getSize(node.right);
			return result;
		}
	}
	
	
	/**
	 * method that receives a node and calculates its depth, that is, the length of its path to the root
	 * 
	 * Based on OOP (object oriented programming) principles, the method should be static. 
	 * Moreover, the method should belong to the BinTreeNode class.
	 * However, we decided to relax these OOP principles in order to focus on the main ADT concepts.  
	 * @param node
	 * @return
	 */
	public static int getDepth(BinTreeNode node) {
		if (node==null) return -1;
		else return 1 + getDepth(node.parent);
	}
	
	/**
	 * Iterative method that receives a node and calculates its depth, that is, the length of its path to the root
	 * 
	 * Based on OOP (object oriented programming) principles, the method should be static. 
	 * Moreover, the method should belong to the BinTreeNode class.
	 * However, we decided to relax these OOP principles in order to focus on the main ADT concepts.  
	 * @param node
	 * @return
	 */
	public static int getDepthIt(BinTreeNode node) {
		if (node==null) return -1;
		BinTreeNode nodeIt=node;
		int level=0;
		while (nodeIt.parent!=null) {
			nodeIt=nodeIt.parent;
			level++;
		}
		return level;
	}
	
	
	/**
	 * PreOrder traversal Method that returns the preorder of the tree into a list. 
	 * @return
	 */
	public SList getPreorder() {
		SList list = new SList();
		getPreorder(root, list);
		return list;
	}

	/**
	 * Auxiliary method that receives a node and visits their nodes in preorder. In particular, 
	 * the elements of the nodes are saved into a list.
	 * 
	 * Based on OOP (object oriented programming) principles, the method should be static. 
	 * Moreover, the method should belong to the BinTreeNode class.
	 * However, we decided to relax these OOP principles in order to focus on the main ADT concepts.  
	 * @param node
	 * @return
	 */
	public static void getPreorder(BinTreeNode node, SList list) {
		if (node == null) return;
		list.addLast(node.elem);
		//System.out.println(node.elem)
		getPreorder(node.left, list);
		getPreorder(node.right, list);
	}
	
	/**
	 * In-Order traversal Method that returns the in-order of the tree into a list. 
	 * @return
	 */
	public  SList getInOrder() {
		SList list = new SList();
		getInOrder(root, list);
		return list;
	}

	/**
	 * Auxiliary method that receives a node and visits their nodes in in-order. In particular, 
	 * the elements of the nodes are saved into a list.
	 * 
	 * Based on OOP (object oriented programming) principles, the method should be static. 
	 * Moreover, the method should belong to the BinTreeNode class.
	 * However, we decided to relax these OOP principles in order to focus on the main ADT concepts.  
	 * @param node
	 * @return
	 */
	public static void getInOrder(BinTreeNode node, SList list) {
		if (node == null) return;
		
		getInOrder(node.left, list);
		list.addLast(node.elem);
		//System.out.println(node.elem)
		
		getInOrder(node.right, list);

	}
	
	
	/**
	 * PLEASE, COMPLETE THIS CODE TO DEVELOP A METHOD THAT RETURNS THE POSTORDER TRASVERSE OF THE TREE
	 * @return
	 */
	public SList getPostOrder() {
		SList list = new SList();
		getPostOrder(root, list);
		return list;
	}
	/**
	 * PLEASE, COMPLETE THIS CODE 
	 *
	 * Auxiliary method that receives a node and visits their nodes in postorder. 
	 * In particular, the elements of the nodes are saved into a list.
	 * 
	 * Based on OOP (object oriented programming) principles, the method should be static. 
	 * Moreover, the method should belong to the BinTreeNode class.
	 * However, we decided to relax these OOP principles in order to focus on the main ADT concepts.  
	 * @param node
	 * @return
	 */
	
	public  static void getPostOrder(BinTreeNode node, SList list) {
		if (node == null) return;
		
		getPostOrder(node.left, list);
		getPostOrder(node.right, list);
		
		list.addLast(node.elem);
		//System.out.println(node.elem)

	}
	
	

	
	
	/**
	 * PLEASE, COMPLETE THIS CODE
	 * 
	 * The height of a tree is equal to the height of its root 
	 * Since we suppose that the 
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}

	/**
	 * PLEASE, COMPLETE THIS CODE.
	 * Auxiliary method that receives a node and calculates its height, that is, the length of the longest path to a leaf.
	 * 
	 * Important: We suppose that the height of a leaf is 1.
	 * 
	 * 
	 * Based on OOP (object oriented programming) principles, the method should be static. 
	 * Moreover, the method should belong to the BinTreeNode class.
	 * However, we decided to relax these OOP principles in order to focus on the main ADT concepts.  
	 * @param node
	 * @return
	 */
	public static int getHeight(BinTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int result = 1 + Math.max(getHeight(node.left), getHeight(node.right));
			return result;
		}
	}
	
	
	
	
	
	public void showLevelOrder() { 
		int h = getHeight(root);  
		for (int i=1; i<=h; i++) 
			printGivenLevel(root, i); 
	} 
  

    /* Print nodes at the given level */
    public void printGivenLevel (BinTreeNode root ,int level){ 
        if (root == null) 
        	return; 
        if (level == 1) 
        	System.out.print(root.elem + " "); 
        else if (level > 1){ 
        	printGivenLevel(root.left, level-1); 
        	printGivenLevel(root.right, level-1); 
        } 
    } 
	
	
	
	
	
	
	/**
	 * 						A
	 * 				B				C
	 * 			D		E				F
	 * 		
	 * @param args
	 */
	public static void main(String args[]){
	
		/* As an exception, we will create the binary tree in the following (bad) way.
		 * 
		 * When we will study the search binary trees, we will learn their search, insert and remove operations*/
		
			BinTreeNode root=new BinTreeNode("A");
			BinTreeNode left1=new BinTreeNode("B");
			BinTreeNode right1=new BinTreeNode("C");
			root.left=left1;
			left1.parent=root;
			
			root.right=right1;
			right1.parent=root;
			
			BinTreeNode left21=new BinTreeNode("D");
			BinTreeNode right21=new BinTreeNode("E");
			left1.left=left21;
			left21.parent=left1;
			
			left1.right=right21;
			right21.parent=left1;
			
			BinTreeNode right22=new BinTreeNode("F");
			right1.right=right22;
			right22.parent=right1;
			
			//We create the tree
			
			BinTree tree=new BinTree(root);
			
			
			System.out.println("the size of the tree is " + tree.getSize());
			System.out.println("the size of the first left node (B) " + getSize(left1));
			System.out.println("the size of the first right node (C) " + getSize(right1));
			System.out.println("the size of the node with value F " + getSize(right22));
			System.out.println();
			
			System.out.println("the height of the tree is " + tree.getHeight());
			System.out.println("the height of the first left node (B) " + getSize(left1));
			System.out.println("the height of the first right node (C) " + getSize(right1));
			System.out.println("the height of the node with value F " + getSize(right22));
			System.out.println();
			
			System.out.println("the depth of the first left node (B) " + getDepth(left1));
			System.out.println("the depth of the first right node (C) " + getDepth(right1));
			System.out.println("the depth of the node with value F " + getDepth(right22));
			System.out.println("the depth of the root " + getDepth(root));
			System.out.println();
			
			System.out.println("the depth (iterative method) of the first left node (B) " + getDepthIt(left1));
			System.out.println("the depth (iterative method) of the first right node (C) " + getDepthIt(right1));
			System.out.println("the depth (iterative method) of the node with value F " + getDepthIt(right22));
			System.out.println("the depth (iterative method) of the root " + getDepthIt(root));
			System.out.println();
			System.out.println("PreOrder trasversal of the tree: " + tree.getPreorder().toString());
			System.out.println("InOrder trasversal of the tree: " + tree.getInOrder().toString());
			System.out.println("PostOrder trasversal of the tree: " + tree.getPostOrder().toString());
			System.out.println();
			System.out.println("Level order:");
			tree.showLevelOrder();
			System.out.println();
		
	}

}
