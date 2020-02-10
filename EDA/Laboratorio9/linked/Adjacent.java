package Laboratorio9.linked;

public class Adjacent {
		
		//adjacent vertex
		public int vertex;
		//weight of the edge
		public Integer w;
		
		public Adjacent(int vertex, Integer w) {
			this.vertex = vertex;
			this.w = w;
		}
		public String toString(){
			return "(adjacent="+vertex+", weight="+w+")";
		}
}
