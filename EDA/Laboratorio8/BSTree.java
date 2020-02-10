package Laboratorio8;

public class BSTree implements IBSTree {

	BSTNode root;

	
	//search the node whose key is key and 
	//returns its associated value
	public String find(Integer key) {
		return find(root, key);
	}
	
	/**
	 * The method searches the key into the subtree 
	 * that hangs down from currentNode
	 * Note: It would be more correct 
	 * for the method to be in the BSTNode class
	 * @param currentNode
	 * @param key
	 * @return
	 */
	private static String find(BSTNode currentNode, Integer key) {
		String result=null;
		if (currentNode == null) {
			//System.out.prinltn(key + " does not exist!");
		} else {
			if (key.equals(currentNode.key))
				result= currentNode.elem;
			else if (key.compareTo(currentNode.key) < 0)
				result=find(currentNode.left, key);
			else
				result=find(currentNode.right, key);
		}
		return result;
	}
	
	//creates a new node and inserts it into the tree
	//first, it must search its right position into the tree
	//the new nodes must always be inserted as leaves
	public void insert(Integer key, String element) {
		BSTNode newNode=new BSTNode(key,element);
		if (root==null) root=newNode;
		else insert(newNode, root);
	}
	
	/**
	 * This method first looks for (recursively) the right position and then
	 * inserts the new node.
	 * Note: It would be more correct 
	 * for the method to be in the BSTNode class
	 * @param newNode 
	 * @param currentNode node where you start the search
	 * 
	 */
	protected static void insert(BSTNode newNode, BSTNode currentNode) {
		if (currentNode==null) return;
		Integer key=newNode.key;
		if (key.compareTo(currentNode.key)==0) {
			System.out.println(key + " already exists. Duplicates are not allowed!!!.");
			return;
		}
		if (key.compareTo(currentNode.key)<0) {
			if (currentNode.left==null) {
				//the method already finds the right position
				currentNode.left=newNode;
				newNode.parent=currentNode;
			} else {
				//the method must continue searching...
				insert(newNode,currentNode.left);
			}
		} else {
			if (currentNode.right==null) {
				//the method already finds the right position
				currentNode.right=newNode;
				newNode.parent=currentNode;
			} else {
				//the method must continue searching...
				insert(newNode,currentNode.right);
			}
		}
		
	}
	

	//searches the node whose key is key and removes it from the tree
	//the method uses a recursive method that returns the modified tree
	public void remove(Integer key) {
		root=remove(key,root);
	}

	/**
	 * 
	 * @param key
	 * @param currentNode
	 * @return
	 */
	private BSTNode remove(Integer key, BSTNode currentNode) {
		if (currentNode == null) {
			System.out.println("Cannot remove: The key doesn't exist");
			return null;
		}
		
		if (key.compareTo(currentNode.key)<0) {
			currentNode.left=remove(key,currentNode.left);
			return currentNode;
		}
		
		if (key.compareTo(currentNode.key)>0) {
			currentNode.right=remove(key,currentNode.right);
			return currentNode;

		}
		
		//Here, it means that key.compareTo(node.Key)==0
		//That is, we already have found it: node is the node to remove.
		//First case: the node is a leaf.
		if (currentNode.left==null && currentNode.right==null) {
			return null;
		}

		//Second case is one the node only has a child: left or right
		if (currentNode.left==null)  {
			currentNode.right.parent = currentNode.parent;
			return currentNode.right;
		}
		
		if (currentNode.right==null) {
			currentNode.left.parent = currentNode.parent;
			return currentNode.left;
		}
		
		//Third case: node has two childs.
		//We can replace its value by the maximum value in its left child or
		//by the minimum value in its right child

		BSTNode successorNode = currentNode.right;
		while (successorNode.left!=null) {
			successorNode=successorNode.left;
		}
		//replace its key and its elem by the successorNodes's key and elem
		currentNode.elem=successorNode.elem;
		currentNode.key=successorNode.key;
		
		//Finally, we must remove the sucesorNode (which is one of the two previous cases)
		currentNode.right=remove(successorNode.key,currentNode.right);
		return currentNode;

		 
		
	}


		 
	public void showPreorder() {
		if (root!=null) root.showPreOrder();
		else System.out.println("tree is empty");
	}

	public void showInorder() {
		 if (root!=null) root.showInOrder();
		else System.out.println("tree is empty");
	}
	
	public void showPostorder() {
		if (root!=null) root.showPostOrder();
		else System.out.println("tree is empty");
	}
	
	
	public int getSize() {
		return BSTNode.getSize(root);
	}

	public int getHeight() {
		return BSTNode.getHeight(root);
	}

	
	public void showByLevel() {
		if (root!=null) {
			root.showLevels();
		}
	}
	
	
	//Recursive method that visits all nodes and 
	//prints those whose parents are multiple of 10.
	public void print10() {
		print10(root);
	}
	
	// Note: It would be more correct 
	// for the method to be in the BSTNode class
	public static void print10(BSTNode node) {
		if (node!=null) {
			if (node.parent!=null) {
				BSTNode grand=node.parent.parent;
				if (grand!=null && grand.key % 10 ==0) {
					System.out.println(node.key + " grand:" + grand.key);
				}
			}
			print10(node.left);
			print10(node.right);
		}
	}
	
	public int sumAllKeys() {
		return sumAllKeys(root);
	}
	
	// Note: It would be more correct 
	//for the method to be in the BSTNode class
	protected static int sumAllKeys(BSTNode node) {
		if (node==null) return 0;
		else return node.key+sumAllKeys(node.left)+sumAllKeys(node.right);
	}
	
	//returns its predecessor node 
	//(which is the most-right node of its left child)
	public BSTNode getPredecessor(BSTNode node) {
		if (node==null) return null;

		BSTNode predecessor=node.left;
		while (predecessor.right!=null) {
			predecessor=predecessor.right;
		}
		return predecessor;
	}
	
	//returns its successor node 
	//(which is the most-left node of its right child)
	public BSTNode getSuccesor(BSTNode node) {
		if (node==null) return null;
		
		BSTNode successor=node.right;
		while (successor.left!=null) {
			successor=successor.left;
		}
		return successor;
	}

	//returns the smallest key
	//The smallest key is the key of the most-left node 
	public int getSmallestKey() {
		int result;
		if (root!=null) {
			BSTNode mostLeft=root;
			while (mostLeft.left!=null) {
				mostLeft=mostLeft.left;
			}
			result=mostLeft.key;
		} else {
			//we could throw an exception 
			System.out.println("error: tree is empty");
			//or any value such as -1
			result= Integer.MAX_VALUE;
		}
		return result;
	}
	
	
	//returns the largest key
	//The largest key is the key of the most-right node 
	public int getMaximumKey() {
		int result;
		if (root!=null) {
			BSTNode mostRight=root;
			while (mostRight.right!=null) {
				mostRight=mostRight.right;
			}
			result=mostRight.key;
		} else {
			//we could throw an exception 
			System.out.println("error: tree is empty");
			//or any value such as -1
			result= Integer.MIN_VALUE;
		}
		return result;
	}
		
	public static int getFactorSize(BSTNode node) {
		if (node==null) return 0;
		else return Math.abs(BSTNode.getSize(node.right)-BSTNode.getSize(node.left));
	}
	public static int getFactorHeight(BSTNode node) {
		if (node==null) return 0;
		else return Math.abs(BSTNode.getHeight(node.right)-BSTNode.getHeight(node.left));
	}
	
	//checks if the tree is size balanced
	public boolean isSizeBalalanced() {
		return isSizeBalanced(root);
	}
	//checks if the subtree than hangs down from node 
	//is size balanced
	public static boolean isSizeBalanced(BSTNode node) {
		if (node==null) return true;
		return getFactorSize(node)<=1 && isSizeBalanced(node.left) && isSizeBalanced(node.right);
	}
	
	//checks if the tree is height balanced (AVL
	public boolean isHeightBalalanced() {
		return isHeightBalalanced(root);
	}
	//checks if the subtree than hangs down from node 
	//is height balanced
	public static boolean isHeightBalalanced(BSTNode node) {
			if (node==null) return true;
			return getFactorSize(node)<=1 && isHeightBalalanced(node.left) 
					&& isHeightBalalanced(node.right);
		}
		

	
	
	public static void main(String args[]) {
		//Please, complete more instructions to check the code
		
		BSTree bstree = new BSTree();
	
		bstree.insert(20, "20");
		bstree.insert(12, "12");
		bstree.insert(16, "16");
		bstree.insert(23, "23");
		bstree.insert(21, "21");
		bstree.insert(34, "34");
		//			20
		//12						23
		//		16			21		34
		
//		System.out.println(bstree.find(30));
//		System.out.println(bstree.find(23));
//		
		System.out.print("Preorder:");
		bstree.showPreorder();
		System.out.println();

		System.out.print("Inorder:");
		bstree.showInorder();
		System.out.println();

		System.out.print("Postorder:");
		bstree.showPostorder();
		System.out.println();
		System.out.print("LevelOrder:");
		bstree.showByLevel();
		System.out.println();

		bstree.print10();
		System.out.println();
		System.out.println("sumAllKeys:" + bstree.sumAllKeys());

	}
	
}