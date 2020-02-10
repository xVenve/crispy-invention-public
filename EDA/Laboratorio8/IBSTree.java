package Laboratorio8;
//interface for a binary search tree whose keys are integers
//and elements strings
public interface IBSTree {

	//takes a key and searches it into the tree
	//returning its associated elem, and null 
	//if the key does not exit in the tree.
	public String find(Integer key);
	
	//create a new node
	//return false if the key already exists
	//otherwise true
	public void insert(Integer key, String elem);
	
	public void remove(Integer key);
}
