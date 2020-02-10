package phase2;

import phase1.StudentsList;

public class ManageNetworkTree implements IManageNetworkTree {

	
	/**
	 * It takes an object of the StudentsTree class 
	 * and an object of the StudentsList class (phase 1),
	 * and inserts each student from the list into the tree. 
	 * The method does not return anything. 
	 * @param tree
	 * @param list
	 */
	public void copySocialNetwork(StudentsTree tree, StudentsList list) {
		for(int i=0; i<list.getSize();i++) {
			tree.insertStudent(list.getAt(i));
		}
	}
	/**
	 * This takes an object of the StudentsTree class and returns an object of the StudentsList class
	 *  containing all the students in the tree ordered by their email. 
	 *  Hint: You can develop an auxiliary and recursive method  
	 *  which takes a BSTNode object and a StudentsList object. 
	 *  You cannot use any sort algorithm to sort the resulting list. 
	 *  To obtain the list, you must traverse the tree (or subtree) in a recursive way. 
	 * @return
	 */
	public StudentsList getOrderedList(StudentsTree tree){
		
        StudentsList sL = new StudentsList();
       sL=recursiveTree(tree.root,sL);
       
        return sL;
    }
	
	public StudentsList recursiveTree(BSTNode node,StudentsList list) {
		if(node==null) return list;
		recursiveTree(node.left, list);
		list.addLast(node.oStudent);
		recursiveTree(node.right, list);
		return list;		
	}
	
	
	/**
	 * This class has a parameter n as input and removes all students having a number of blocks equal or greater than n.
	 * @param num
	 */
	
	public void deleteByNumberOfBlocks(StudentsTree tree,int num) {
		deleteByNumberOfBlocks(tree,tree.root, num);
	}
	
	public void deleteByNumberOfBlocks(StudentsTree tree,BSTNode node,int n) {
	       if(node!=null) {
	    	   deleteByNumberOfBlocks(tree,node.left, n);
	    	   deleteByNumberOfBlocks(tree,node.right, n);
		       if(node.oStudent.blocks>=n) {
		    	   tree.removeStudent(node.key);
		       }
	       }
		}
	}
