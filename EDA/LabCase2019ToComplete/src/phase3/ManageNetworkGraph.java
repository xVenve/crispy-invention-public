package phase3;

import java.util.LinkedList;


public class ManageNetworkGraph implements IManageNetworkGraph {
	
	
	public LinkedList<String> students;
	LinkedList<LinkedList<Integer>> lst_of_lstAdjacents;
		
	public ManageNetworkGraph(String[] students) {
			this.students=new LinkedList<String>();
			for(int k=0; k < students.length; k++) {
				this.students.add(students[k]);
			}
			lst_of_lstAdjacents=new LinkedList<LinkedList<Integer>>();
			int num=this.students.size();
			for (int i=0; i<num; i++) {
				lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
			}
	}
	
	//searches the student and returns its index
	public int getIndex(String student) {
		int index=students.indexOf(student);
		return index;
	}
	//checks if index is right and returns its associated city
	public String checkVertex(int index) {
		if (index>=0 && index<students.size()) return students.get(index);
		else return null;
	}
	
	/**
	 * It takes taking two students (emails) as input and 
	 * creates a friendship relation between them. 
	 * Keep in mind that friendship relation is a symmetric relationship.
	 */
	public void addStudent(String student) {
		if(student==null || student=="") {
			return;
		}
		lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
		students.addLast(student);
	}
	
	/**
	 * It takes two students (emails) as input and creates a friendship 
	 * relation between them. Keep in mind that friendship relation is a symmetric relationship.
	 * @param studentA
	 * @param studentB
	 */
	public void areFriends(String studentA, String studentB) {
		if(studentA==null || studentB==null|| studentB=="" || studentA=="") {
			return;
		}
		if(!students.contains(studentA)) {
			addStudent(studentA);
		}
		if(!students.contains(studentB)) {
			addStudent(studentB);
		}
		int indexA=students.indexOf(studentA);
		int indexB=students.indexOf(studentB);
		lst_of_lstAdjacents.get(indexA).addLast(indexB);
		lst_of_lstAdjacents.get(indexB).addLast(indexA);
	}

	/**
	 * This takes a student (email), and returns an object of LinkedList<String>, 
	 * which contains the emails of his/her direct friends.
	 * @param studentA
	 * @return
	 */
	public LinkedList<String> getDirectFriends(String studentA){
		
		LinkedList<String> lDirectFriends = new LinkedList<String>();
		if(studentA==null || studentA=="" || !students.contains(studentA)) {
			return lDirectFriends;
		}
		LinkedList<Integer> s=lst_of_lstAdjacents.get(students.indexOf(studentA));
		int i=0;
		while(i<s.size()) {
			lDirectFriends.addLast(students.get(s.get(i)));
			i++;
		}
		return lDirectFriends;
	}
	
	
	
	public int[] getAdjacents(int i) {
		if (i>=0 && i<students.size()) {
			int[] t=new int[lst_of_lstAdjacents.get(i).size()];
			for(int x=0;x<lst_of_lstAdjacents.get(i).size();x++) {
				t[x]=lst_of_lstAdjacents.get(i).get(x);
			}
			return t;
		}
		return null;
	}
	
	public LinkedList<String> suggestedFriends(String studentA){
		LinkedList<String> lSuggestedFriends = new LinkedList<String>();
		if(students.contains(studentA)&&!lst_of_lstAdjacents.get(students.indexOf(studentA)).isEmpty()) {
			boolean visited[]=new boolean[students.size()];
			int ind=students.indexOf(studentA);
			LinkedList<Integer> d=depth(ind,visited);
			for(int i=0;i<d.size();i++) {
				if(!lst_of_lstAdjacents.get(ind).contains(d.get(i))&&d.get(i)!=ind) {
					lSuggestedFriends.addLast(students.get(d.get(i)));
				}
			}
		}
		return lSuggestedFriends;
	}
	
	
	public LinkedList<Integer> depth(int i, boolean[] visited) {
		LinkedList<Integer> path=new LinkedList<Integer>();
		return depth(i,visited, path);
	}
	

	protected LinkedList<Integer> depth(int i,boolean[] visited, LinkedList<Integer> path) {
		visited[i]=true;
		path.addLast(i);
		int[] adjacents=getAdjacents(i);
		for (int adjV:adjacents) {
			if (!visited[adjV]) {
				depth(adjV,visited,path);
			}
		}
		return path;
	}
	
	public void show() {
		for (int i=0; i<students.size(); i++) {
			for (int k=0; k<lst_of_lstAdjacents.get(i).size();k++) {
				System.out.println("adjacents for " + students.get(i) );
				System.out.println(students.get(lst_of_lstAdjacents.get(i).get(k)));
			}
		}
	}
	
	public static void main(String args[]) {
		String students[]={"fran","luisa", "manu","ricky","david","maria","elena","juan","isabel","pedro","edu"};
		ManageNetworkGraph graph=new ManageNetworkGraph(students);
		graph.areFriends("luisa", "manu");		graph.areFriends("luisa", "isabel");
		graph.areFriends("isabel", "ricky");	graph.areFriends("pedro", "juan");
		graph.areFriends("ricky", "edu");
		
		int index1=graph.getIndex("isabel");
		int index2=graph.getIndex("ricky");
		System.out.println(graph.lst_of_lstAdjacents.get(index1).contains(index2));
		System.out.println("Amigos directos a luisa");
		System.out.println(graph.getDirectFriends("luisa"));
		System.out.println("Mostrar");
		graph.show();
		System.out.println("Indice de manu");
		System.out.println(graph.getIndex("manu"));
		System.out.println("Adyacentes a luisa");
		int[] h=graph.getAdjacents(1);
		for(int i=0;i<h.length;i++) {
			System.out.println(h[i]+"  ");
		}
		System.out.println("Profundidad");
		boolean visited[]=new boolean[graph.students.size()];
		System.out.println(graph.depth(1, visited));
		System.out.println("Amigos sugeridos");
		System.out.println(graph.suggestedFriends("manu"));

	}
	
}
