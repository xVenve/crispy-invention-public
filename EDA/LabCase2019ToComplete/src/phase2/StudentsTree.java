package phase2;



import java.time.LocalDate;

import phase1.Student;

public class StudentsTree implements IBSTree {

	BSTNode root;

	
	//search the node whose key is key and 
	//returns its associated value
	public Student findStudent(String username) {
		return findStudent(root, username);
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
	private static Student findStudent(BSTNode currentNode, String username) {
		Student result=null;
		if (currentNode == null) {
			//System.out.prinltn(key + " does not exist!");
		} else {
			if (username.equals(currentNode.key))
				result= currentNode.oStudent;
			else if (username.compareTo(currentNode.key) < 0)
				result=findStudent(currentNode.left, username);
			else
				result=findStudent(currentNode.right, username);
		}
		return result;
	}
	
	//creates a new node and inserts it into the tree
	//first, it must search its right position into the tree
	//the new nodes must always be inserted as leaves
	public void insertStudent(Student oStudent) {
		BSTNode newNode=new BSTNode(oStudent);
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
		String key=newNode.key;
		
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
	public void removeStudent(String username) {
		root=remove(username,root);
	}

	/**
	 * This methods always replace by using the succesor
	 * @param key
	 * @param currentNode
	 * @return
	 */
	protected static BSTNode remove(String key, BSTNode currentNode) {
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
		currentNode.oStudent=successorNode.oStudent;
		currentNode.key=successorNode.key;
		
		//Finally, we must remove the sucesorNode (which is one of the two previous cases)
		currentNode.right=remove(successorNode.key,currentNode.right);
		return currentNode;

		 
		
	}

	

	
	
	
	public int getSize() {
		return BSTNode.getSize(root);
	}

	public int getHeight() {
		return BSTNode.getHeight(root);
	}

	

	
	public boolean equals(StudentsTree obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		StudentsTree other = (StudentsTree) obj;
		
		if (root == null && obj.root==null) return true;
		if (root == null && obj.root!=null) return false;
		
		//root !=null
		return root.equals(other.root);
	}
	
	
	public static void main(String args[]) {
		Student s1 = new Student("kdks@uc3m.es","PARLA",Student.Campus.GETAFE, 4, LocalDate.of(2017, 12, 12));
		StudentsTree tree=new StudentsTree();
		
		tree.insertStudent(s1);
		
		Student s2 = new Student("abc@uc3m.es","MADRID",Student.Campus.LEGANES, 2, LocalDate.of(2014, 1, 12));
		tree.insertStudent(s2);
		
		Student s3 = new Student("a33@uc3m.es","PINTO",Student.Campus.COLMENAREJO, 3, LocalDate.of(2016, 7, 30));
		tree.insertStudent(s3);
		
		Student s4 = new Student("c203@uc3m.es","ALCORCON",Student.Campus.GETAFE, 4, LocalDate.of(2015, 10, 18));
		tree.insertStudent(s4);
		
		Student s5 = new Student("nij@uc3m.es","VALDEMORO",Student.Campus.COLMENAREJO, 2, LocalDate.of(2011, 8, 11));
		tree.insertStudent(s5);
		
		Student s6 = new Student("m2c@uc3m.es","MADRID",Student.Campus.LEGANES, 1, LocalDate.of(2017, 4, 21));
		tree.insertStudent(s6);
		
		
		
	}

	
	
}