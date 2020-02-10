package Laboratorio9.linked;


//Interface for a weighted graph whose vertices are represented as indexes (integers).
//The weights are also integers.

public interface IGraph {

	//return the number of vertices
	public int sizeVertices();
	//return the number of edges
	public int sizeEdges();
	//shows the graph (vertices and edges)
	public void show();
	
	//returns the degree a vertex
	public int getDegree(int i);
	//return the inward-bound degree 
	public int getInDegree(int i);
	//return the outward-bound degree 
	public int getOutDegree(int i);
		
	//check if the pair of vertices (i,j) is an edge. 
	public boolean isEdge(int i, int j);
		
	
	//create an edge between the vertices i and j with weight w
	public void addEdge(int i, int j, int w);
	//remove the edge between the vertices i and j
	public void removeEdge(int i, int j);
	
	
	//returns the weight of the edge (i,j)
	public Integer getWeightEdge(int i, int j);
	//returns an array with the adjacent vertices of i
	public int[] getAdjacents(int i);
 
	
	

}
