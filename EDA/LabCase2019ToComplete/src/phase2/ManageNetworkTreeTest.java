package phase2;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import phase1.Student;
import phase1.StudentsList;

public class ManageNetworkTreeTest {

	
	static ManageNetworkTree objManage=new ManageNetworkTree();
	
	static StudentsTree emptyTree=new StudentsTree();
	static StudentsList emptyList=new StudentsList();
	
	static StudentsTree treesize_1=new StudentsTree();
	static StudentsList list_1=new StudentsList();
	
	static StudentsList input_list=new StudentsList();

	static StudentsList sorted_list=new StudentsList();

	static StudentsTree tree=new StudentsTree();
	static StudentsTree tree_norigth=new StudentsTree();
	static StudentsTree tree_noleft=new StudentsTree();
	static StudentsTree tree_block=new StudentsTree();
	static StudentsTree tree_1=new StudentsTree();
	static StudentsTree tree_2 = new StudentsTree(); 

	static StudentsList list_noleft=new StudentsList();
	static StudentsList list_norigth=new StudentsList();

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//input tree
		//				  s1:kdks,4
		//		 	   /	    	\
		//		s2:abc,2	         s5:nij,2	
		//		   /   \        	/
		//	s3:a33,3	s4:c203,4	s6:m2c,1		
		
		Student s1 = new Student("kdks@uc3m.es","PARLA",Student.Campus.GETAFE, 4, LocalDate.of(2017, 12, 12));
		tree.insertStudent(s1);
		treesize_1.insertStudent(s1);
		tree_norigth.insertStudent(s1);
		tree_noleft.insertStudent(s1);
		
		list_1.addLast(s1);
		
		//left subtree
		Student s2 = new Student("abc@uc3m.es","MADRID",Student.Campus.LEGANES, 2, LocalDate.of(2014, 1, 12));
		tree.insertStudent(s2);
		tree_norigth.insertStudent(s2);
		
		Student s3 = new Student("a33@uc3m.es","PINTO",Student.Campus.COLMENAREJO, 3, LocalDate.of(2016, 7, 30));
		tree.insertStudent(s3);
		tree_norigth.insertStudent(s3);
		
		Student s4 = new Student("c203@uc3m.es","ALCORCON",Student.Campus.GETAFE, 4, LocalDate.of(2015, 10, 18));
		tree.insertStudent(s4);
		tree_norigth.insertStudent(s4);
		
		
		//rigth subtree
		Student s5 = new Student("nij@uc3m.es","VALDEMORO",Student.Campus.COLMENAREJO, 2, LocalDate.of(2011, 8, 11));
		tree.insertStudent(s5);
		tree_noleft.insertStudent(s5);

		
		Student s6 = new Student("m2c@uc3m.es","MADRID",Student.Campus.LEGANES, 1, LocalDate.of(2017, 4, 21));
		tree.insertStudent(s6);
		tree_noleft.insertStudent(s6);

		//expected list for the method getOrderedList
		sorted_list.addLast(s3);
		sorted_list.addLast(s2);
		sorted_list.addLast(s4);
		sorted_list.addLast(s1);
		sorted_list.addLast(s6);
		sorted_list.addLast(s5);
		
		//expected list for the method getOrderedlist (no right)
		list_norigth.addLast(s3);
		list_norigth.addLast(s2);
		list_norigth.addLast(s4);
		list_norigth.addLast(s1);

		//expected list for the method getOrderedlist (no left)
		list_noleft.addLast(s1);
		list_noleft.addLast(s6);
		list_noleft.addLast(s5);

		//input tree for deleteByNumberOfBlocks(3)
		//				  	s1:kdks,4
		//			   /	    		\
		//			s2:abc,2	    	s5:nij,2	
		//		 	/   \        		/
		//	 s3:a33,3	s4:c203,4	s6:m2c,1

		tree_1.insertStudent(s1);
		tree_1.insertStudent(s2);
		tree_1.insertStudent(s3);
		tree_1.insertStudent(s4);
		tree_1.insertStudent(s5);
		tree_1.insertStudent(s6);

		//expected tree for the method deleteByNumberOfBlocks(3)
		//					s6:m2c,1
		//				/			\
		//			s2:abc,2	    s5:nij,2

		tree_block.insertStudent(s6);
		tree_block.insertStudent(s2);
		tree_block.insertStudent(s5);
	
		//input list for copySocialNework, the output should be tree
		input_list.addLast(s1);
		input_list.addLast(s2);
		input_list.addLast(s3);
		input_list.addLast(s4);
		input_list.addLast(s5);
		input_list.addLast(s6);

	
	}
	
		@Test
		public void testgetOrderedList() {
			
			
			assertEquals("Check getOrderedList with an empty tree.", true, emptyList.equals(objManage.getOrderedList(emptyTree)) );
			
			assertEquals("Check getOrderedList with a tree with a single node.", true, list_1.equals(objManage.getOrderedList(treesize_1)) );

			StudentsList result=objManage.getOrderedList(tree_norigth);
			assertEquals("Check getOrderedList with a tree without right subtree.", true, list_norigth.equals(result) );

			
			result=objManage.getOrderedList(tree_noleft);
			assertEquals("Check getOrderedList with a tree without left subtree.", true, list_noleft.equals(result) );

			
			assertEquals("Check getOrderedList with a tree with two non-empty subtrees.", true, 
					sorted_list.equals(objManage.getOrderedList(tree)));
		
		}

		@Test
		public void testdeleteByNumberOfBlocks() {
			
		objManage.deleteByNumberOfBlocks(tree_1, 3);
			
		assertEquals("Check deleteByNumberOfBlocks to remove all the nodes with more than 3 blocks.", true,	tree_1.equals(tree_block));
		
		}
		
		@Test
		public void testcopySocialNetwork() {
		
			objManage.copySocialNetwork(tree_2, emptyList);
			assertEquals("Check copySocialNetwork with an empty list.", true, tree_2.equals(emptyTree));
		
			objManage.copySocialNetwork(tree_2, input_list);
			assertEquals("Check copySocialNetwork with a non empty list.", true, tree_2.equals(tree));

		}


}
