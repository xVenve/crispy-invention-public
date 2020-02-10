package Laboratorio9.linked;

import java.util.LinkedList;
import java.util.Stack;

//java interface for queue
import java.util.Queue;

public class GraphLA implements IGraph {
	
	
	
	//array for storing the set of vertices (we suppose a fix number of vertices)
	//suppose the vertices are String objects.
	public String[] vertices;
	//number of vertices in the graph
	int numVertices;
		
	LinkedList<Adjacent>[] lstAdjacents;
	//directed or not
	boolean directed;
		
		
	public GraphLA(String[] vertices, boolean d) {
			this.vertices=vertices;
			numVertices=vertices.length;
			directed=d;
			lstAdjacents=new LinkedList[numVertices];
			//we create an empty list for each vertex
			for (int i=0; i<numVertices;i++) {
				//LinkedList of adjacents for vertex i
				lstAdjacents[i]=new LinkedList<Adjacent>();
			}
	}
	
	
	
		
	@Override
	public int sizeVertices() {
		return numVertices;
	}

	@Override
	public int sizeEdges() {
		int numEdges=0;
		for (int i=0;i<numVertices;i++) {
			numEdges=numEdges+lstAdjacents[i].size();
		}
		if (!directed) numEdges=numEdges/2;
		return numEdges;
	}

	//check if i is a right vertex and returns its name
	private String checkVertex(int i) {
			//i has to be positive and lower than numVertices
			if (i>=0 && i<numVertices) return vertices[i];
			else return null;
	}
		
	
	public int getOutDegree(int i) {
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return -1;
		}
		int outdegree=0;
		outdegree=lstAdjacents[i].size();
		
		return outdegree;
	}
	
	public int getInDegree(int i) {
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return -1;
		}
		int indegree=0;
		for (int j=0; j<numVertices;j++) {
			for (int k=0; k<lstAdjacents[j].size();k++) {
					Adjacent obj=lstAdjacents[j].get(k);
					if (obj.vertex==i) indegree++;
				}
		}
		return indegree;
	}

	
	
	
	
	@Override
	public int getDegree(int i) {
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return -1;
		}
	
		int degree=0;
		if (directed) {
			degree=getOutDegree(i)+getInDegree(i);
		} else {
			degree=lstAdjacents[i].size();
		}
		return degree;
	}
	
	
		
	public void addEdge(int i, int j, int w) {
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return;
		}
		if (checkVertex(j)==null) {
			System.out.println("Nonexistent vertex  " + j);
			return;
		}
		
		boolean contains=false;
		for (int k=0; k<lstAdjacents[i].size() && contains==false;k++) {
			Adjacent obj=lstAdjacents[i].get(k);
			if (obj.vertex==j) {
				contains=true;
				//replace its weight
				obj.w=w;
			}
		}
		if (!contains) {
			lstAdjacents[i].add(new Adjacent(j,w));
		}
		
			
		
		if (!directed) {
			//we must also add (j,i,w)
			contains=false;
			for (int k=0; k<lstAdjacents[j].size() && contains==false;k++) {
				Adjacent obj=lstAdjacents[j].get(k);
				if (obj.vertex==i) {
					contains=true;
					//replace its weight
					obj.w=w;
				}
			}
			if (!contains) {
				lstAdjacents[j].add(new Adjacent(i,w));
			}
		}
	
	
	}

	
	
	public void removeEdge(int i, int j) {
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return;
		}
		if (checkVertex(j)==null) {
			System.out.println("Nonexistent vertex  " + j);
			return;
		}
		int index=-1;
		for (int k=0; k<lstAdjacents[i].size() && index==-1;k++) {
			Adjacent obj=lstAdjacents[i].get(k);
			if (obj.vertex==j) {
				index=k;
			}
		}
		if (index!=-1) lstAdjacents[i].remove(index);
		
		if (!directed) {
			//we must also remove (j,i)
			index=-1;
			for (int k=0; k<lstAdjacents[j].size() && index==-1;k++) {
				Adjacent obj=lstAdjacents[j].get(k);
				if (obj.vertex==i) {
					index=k;
				}
			}
			if (index!=-1) lstAdjacents[j].remove(index);
		}
	}

	@Override
	public boolean isEdge(int i, int j) {
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return false;
		}
		if (checkVertex(j)==null) {
			System.out.println("Nonexistent vertex  " + j);
			return false;
		}
		
		boolean result=false;
		for (int k=0; k<lstAdjacents[i].size() && result==false;k++) {
			Adjacent obj=lstAdjacents[i].get(k);
			if (obj.vertex==j) {
				result=true;
			}
		}
		return result;
	}

	@Override
	public Integer getWeightEdge(int i, int j) {
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return null;
		}
		if (checkVertex(j)==null) {
			System.out.println("Nonexistent vertex  " + j);
			return null;
		}
		
		Integer result=null;
		
		for (int k=0; k<lstAdjacents[i].size() && result==null;k++) {
			Adjacent obj=lstAdjacents[i].get(k);
			if (obj.vertex==j) {
				result=obj.w;
			}
		}
		
		return result;
	}

	@Override
	public void show() {

		for (int i=0; i<numVertices; i++) {
			for (int k=0; k<lstAdjacents[i].size();k++) {
				Adjacent obj=lstAdjacents[i].get(k);
				System.out.println("adjacents for " + i );
				System.out.println(obj.toString());
			}
		}
		
	}

	public int[] getAdjacents(int i) {
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return null;
		}
		
		//gets the number of adjacent vertices
		int numAdj=lstAdjacents[i].size();
		//creates the array
		int[] adjVertices=new int[numAdj];
		//saves the adjacent vertices into the array
		for (int j=0; j<numAdj; j++) {
			adjVertices[j]=lstAdjacents[i].get(j).vertex;
		}
		//return the array with the adjacent vertices of i
		return adjVertices;
	}
	
	public void breadth() {
		System.out.println("breadth traverse of the graph:");
		
		//to mark when a vertex has already been shown
		boolean visited[]=new boolean[numVertices];

		//we have to traverse all vertices
		for (int i=0;i<numVertices;i++) {
			if (!visited[i]) { //we only process the non-visited vertex
				breadth(i,visited);
			}
		}
		System.out.println();

	}
	
	

	//breadth order for the vertex i 
	protected void breadth(int i, boolean[] visited) {
		//this array helps to mark what vertices have been stored into the queue
		boolean stored[]=new boolean[numVertices];
		//System.out.println("breadth traverse for " + i);
		//we use a queue to save the adjacent vertices that we visit
		Queue<Integer> q=new LinkedList<Integer>();
		//enqueue the first
		q.add(i);
		//while the queue is not empty
		while (!q.isEmpty()) {
			//gets the first
			int vertex=q.poll();
			//shows the vertex and marks it as visited
			System.out.print(vertex+"\t");
			visited[vertex]=true;
			//gets its adjacent vertices
			int[] adjacents=getAdjacents(vertex);
			for(int adjVertex:adjacents) {
					//enqueue only those that have not been visited or stored yet 
					if (!visited[adjVertex] && !stored[adjVertex]) {
						q.add(adjVertex);
						stored[adjVertex]=true;
					}
			}
		}
	}
	
	
	private int getUnvisited(int vertex, boolean visited[]) {
		int[] adjs=this.getAdjacents(vertex);
		int novisited=-1;
		//we look for an adjacent that has not been visited
		//when we will find it, we break the loop
		for (int i=0; i<adjs.length &novisited ==-1; i++) {
			int child=adjs[i];
			if (!visited[child]) 
				//save the index of an
				novisited=child;
		}
		return novisited;
	}
	
	
	
	//iterative version for depth traversal
	//using a stack
	public void depth_first() {
		
		//check what nodes have been already visited
		boolean visited[]=new boolean[numVertices];

		//stack help us to backtrack
		Stack<Integer> stack=new Stack<Integer>();
		//save and show the first vertex
		int start=0; 
		stack.push(start);
		visited[start]=true;
		System.out.print(start+",");
		
		while (!stack.isEmpty()) {
			//gets the peek from the stack (was the last in)
			int vertex=stack.peek();
			//gets one of its adjacent nodes that has not been visited yet.
			int novisited=getUnvisited(vertex,visited);
		
			if (novisited!=-1) {
				//go forward to this adjacent (print, visited and push it into the stack)
				stack.push(novisited);
				visited[novisited]=true;
				System.out.print(novisited+",");
			} else {
				//remove from the stack definitively
				//because it does not have any unvisited adjacent nodes
				stack.pop();
			}
			
		}
		
		
	}
	
	
	
	public void depth() {
		System.out.println("depth traverse of the graph:");
		//to mark when a vertex has already been shown
		boolean visited[]=new boolean[numVertices];
		//we have to traverse all vertices
		for (int i=0;i<numVertices;i++) {
			if (!visited[i]) {
				depth(i,visited);
			}
		}
		System.out.println();

	}
	

	protected void depth(int i,boolean[] visited) {
		//prints the vertex and marks as visited
		System.out.print(i+"\t");
		visited[i]=true;
		//gets its adjacent vertices
		int[] adjacents=getAdjacents(i);
		for (int adjV:adjacents) {
			if (!visited[adjV]) {
				//only depth traverses those adjacent vertices 
				//that have not been visited yet
				depth(adjV,visited);
				
			}
		}
	}
	
	
	
	
}
