package phase2;
import phase1.Student;

public interface IBSTree {

	
	public Student findStudent(String username);
	
	public void insertStudent(Student student);
	
	public void removeStudent(String username);
	
	
	public int getSize();

	public int getHeight();
	
	
}
