package phase2;

public interface IBSTNode {

	//number of nodes that hang from the invoking node
	public int getSize();
	//depth of the invoking node
	public int getDepth();
	//height of the node (longest path from the node to any leaf)
	public int getHeight();
	
	//traversals
	//show the nodes of its subtree in pre-order
	public void showPreOrder();
	//show the nodes of its subtree in post-order
	public void showPostOrder();
	//show the nodes of its subtree in in-order
	public void showInOrder();
	//show the nodes of its subtree by levels
	public void showLevels();
		
	

}
