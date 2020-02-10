package phase1;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class ManageNetworkTestList{
	
	
	static ManageNetworkList objManage=new ManageNetworkList();
	
	static StudentsList input1=new StudentsList(); 
	static StudentsList input2=new StudentsList(); 
	static StudentsList expected_union=new StudentsList();
	static StudentsList expected_samecampuscity=new StudentsList();
	static StudentsList expected_distcampuscity=new StudentsList();
	static StudentsList expected_locateby=new StudentsList();
	static StudentsList expected_asc_ord=new StudentsList();
	static StudentsList expected_desc_ord=new StudentsList();
	static StudentsList expected_dates=new StudentsList();


	static final String CITY="MADRID";
	static final LocalDate START= LocalDate.of(2016,5,31);
	static final LocalDate END= LocalDate.of(2018,12,31);
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Student s1=new Student("cde@uc3m.es", "COLMENAREJO", Student.Campus.LEGANES, LocalDate.of(2018,3,24));
		Student s2=new Student("dcr@uc3m.es", "GETAFE", Student.Campus.COLMENAREJO, LocalDate.of(2016,6,6));
		Student s3=new Student("ccr@uc3m.es", "MADRID", Student.Campus.GETAFE, LocalDate.of(2016,5,26));
		Student s4=new Student("brb@uc3m.es", "LEGANES", Student.Campus.LEGANES, LocalDate.of(2016,3,15));
		
		Student s5=new Student("rva@uc3m.es", "COLMENAREJO", Student.Campus.LEGANES, LocalDate.of(2016,9,18));
		Student s6=new Student("jpa@uc3m.es", "ALCORCON", Student.Campus.COLMENAREJO, LocalDate.of(2017,9,19));
		Student s7=new Student("isa@uc3m.es", "MADRID", Student.Campus.GETAFE, LocalDate.of(2014,2,2));
		Student s8=new Student("pmf@uc3m.es", "BRUNETE", Student.Campus.COLMENAREJO, LocalDate.of(2015,4,20));
		Student s9=new Student("jlm@uc3m.es", "COLMENAREJO", Student.Campus.COLMENAREJO, LocalDate.of(2018,8,10));

		//input list1:
		input1.addLast(s1); input1.addLast(s2);input1.addLast(s3); input1.addLast(s4);
		//input list2:
		input2.addLast(s5); input2.addLast(s2); input2.addLast(s3); 
		input2.addLast(s6); input2.addLast(s7); input2.addLast(s8); input2.addLast(s4); input2.addLast(s9);
		
		
		//expected list for union method
		expected_union.addLast(s1);
		expected_union.addLast(s2);
		expected_union.addLast(s3);
		expected_union.addLast(s4);
		expected_union.addLast(s5);
		expected_union.addLast(s6);
		expected_union.addLast(s7);
		expected_union.addLast(s8);
		expected_union.addLast(s9);
		
		
		//expected list for getCampusCity (opc=1) city=campus
		expected_samecampuscity.addLast(s4);
		
		//expected list for getCampusCity (opc=2) city!=campus
		expected_distcampuscity.addLast(s1);
		expected_distcampuscity.addLast(s2);
		expected_distcampuscity.addLast(s3);
		
		//expected list for getLocateBy city='Madrid'
		expected_locateby.addLast(s3);
		
		//expected list for orderBy opc=1 ascending
		expected_asc_ord.addLast(s4);
		expected_asc_ord.addLast(s3);
		expected_asc_ord.addLast(s1);
		expected_asc_ord.addLast(s2);
		
		//expected list for orderBy opc=1 descending
		expected_desc_ord.addLast(s2);
		expected_desc_ord.addLast(s1);
		expected_desc_ord.addLast(s3);
		expected_desc_ord.addLast(s4);

		//expected list for getStudentsByDateInterval start= LocalDate.of(2016,5,31); LocalDate end= LocalDate.of(2018,12,31);
		expected_dates.addLast(s1);
		expected_dates.addLast(s2);


	}

	@Test
	public void testunion() {
		//checks when one of the two list are empty
		StudentsList lEmpty=new StudentsList();

		assertEquals("Check union, first list empty.", true, input1.equals(objManage.union(input1, lEmpty)));
		assertEquals("Check union, second list empty.", true, input1.equals(objManage.union(lEmpty, input1)));
		
		//checks when the two input lists are not empty
		StudentsList result=objManage.union(input1, input2);
		assertEquals("Check union, lists are not empty", true, expected_union.equals(result));
	}
	
	@Test
	public void testgetCampusCity() {
		
		StudentsList lEmpty=new StudentsList();
		//checks when the list is empty, for both options

		assertEquals("Check getStudentsByCity, list empty. opc=1", true, lEmpty.equals(objManage.getCampusCity(lEmpty,1)));
		assertEquals("Check getStudentsByCity, list empty. opc=2", true, lEmpty.equals(objManage.getCampusCity(lEmpty,2)));

		//checks when the list is empty, for opc=1, same  city, same campus
		StudentsList result=objManage.getCampusCity(input1,1);
		assertEquals("Check getStudentsByCity, list non-empty. opc=1 (city=campus)", true, expected_samecampuscity.equals(result));
		//checks when the list is empty, for opc=2, city!=campus			
		result=objManage.getCampusCity(input1,2);
		assertEquals("Check getStudentsByCity, list non-empty. opc=2 (city!=campus)", true, expected_distcampuscity.equals(result));
	}

	@Test
	public void testlocateByCity() {
		StudentsList lEmpty=new StudentsList();
		//System.out.println("locatebyCity:"+city);
		//check when the list is empty for city (setup)
		assertEquals("Check locateByCity, list empty.", true, lEmpty.equals(objManage.locateByCity(lEmpty,CITY)));

		//check when the list is empty for city (setup)


		StudentsList result=objManage.locateByCity(input1,CITY);
		assertEquals("Check locateByCity, city="+CITY, true, expected_locateby.equals(result));
		
	}
	
	
	@Test
	public void testgetStudentsByDateInterval() {
		StudentsList lEmpty=new StudentsList();
		//System.out.println("locatebyCity:"+city);
		//check when the list is empty for city (setup)
		assertEquals("Check getStudentsByDateInterval, list empty.", true, lEmpty.equals(objManage.getStudentsByDateInterval(lEmpty,START,END)));



		StudentsList result=objManage.getStudentsByDateInterval(input1,START,END);
		assertEquals("Check getStudentsByDateInterval, list non empty", true, expected_dates.equals(result));
		
	}
	

		
}
