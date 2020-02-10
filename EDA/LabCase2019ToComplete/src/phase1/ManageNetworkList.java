package phase1;

import java.time.LocalDate;


public class ManageNetworkList implements IManageNetworkList{

	
	/**
	 *  The methods must join two social networks into a single social network. 
	 *  The method takes two objects of the StudentsList and returns a new list containing 
	 *  first the students from the first list followed by the students from the second list. 
	 * @param lst1
	 * @param lst2
	 * @return
	 */
	public StudentsList union(StudentsList lst1, StudentsList lst2) {
		
		StudentsList resultList=new StudentsList();
		
		for(int i=0;i<lst1.size;i++) {
			resultList.addLast(lst1.getAt(i));
		}
		for(int i=0;i<lst2.size;i++) {
			resultList.addLast(lst2.getAt(i));
		}
		return resultList;
	}
	
	
	
	/**
	 * 3. This methods takes a social network as input and an integer parameter opc so that:
		- If opc =1: the method must return a StudentsList containing all the students residing
			in the same city that the campus where they are studying.
		- If opc =2: the method must return a StudentsList containing all the students residing
			in cities different that the one where their campus is located.
	 * @param lst1
	 * @param lst2
	 * @param opc
	 * @return
	 */
	public StudentsList getCampusCity(StudentsList lst, int opc) {
		
		StudentsList l = new StudentsList();
		
		if(opc==1) {
			for(int i=0;i<lst.size;i++) {
				if(lst.getAt(i).city.toUpperCase().equals(lst.getAt(i).campus.toString())) {
					l.addLast(lst.getAt(i));
				}
			}
		}else if(opc==2) {
			for(int i=0;i<lst.size;i++) {
				if(!lst.getAt(i).city.toUpperCase().equals(lst.getAt(i).campus.toString())) {
					l.addLast(lst.getAt(i));
				}
			}
		}
		
		return l;
		
	}

	
	
	
	
	/**
	 * 4. This method takes a social network as input and a integer parameter opc so that: 
			- If opc=1, the method returns a list of students sorted by ascending
			order according to their email.
			- If opc=2, the method returns a lit of students sorted by descending
			order according to their email. 
		Note 1. You must implement your own sort method based on some of the sorted algorithms (such as bubble, sort). 
		Note 2: Remember that you cannot modify or extend the StudentsList class. Therefore, if you need an auxiliary method that help you to sort the list, please include this method into the ManageNetwork class. 
		Note 3. The input list cannot be modified. The method must return a new list where the students are sorted.
	 * @param lst
	 * @param opc
	 * @return
	 */
	public StudentsList orderBy(StudentsList lst, int opc) {
		
		StudentsList sortedList=new StudentsList();
		if(opc==2) {
			for(DNode NodeIt=lst.header.next;NodeIt!=lst.trailer;NodeIt=NodeIt.next) {
				boolean ins=false;
				if(sortedList.isEmpty()) {
					sortedList.addFirst(NodeIt.elem);
					ins=true;
				}
				for(int i=0; i<sortedList.getSize()&&!ins;i++) {
					if(NodeIt.elem.email.toLowerCase().compareTo(lst.getAt(i).email.toLowerCase())>0) {
						sortedList.insertAt(i, NodeIt.elem);
						ins=true;
					}
				}
				if(!ins) {
					sortedList.addLast(NodeIt.elem);
				}
			}
		}else if(opc==1) {
			for(DNode NodeIt=lst.header.next;NodeIt!=lst.trailer;NodeIt=NodeIt.next) {
				boolean ins=false;
				if(sortedList.isEmpty()) {
					sortedList.addFirst(NodeIt.elem);
					ins=true;
				}
				for(int i=0; i<sortedList.getSize()&&!ins;i++) {
					if(NodeIt.elem.email.toLowerCase().compareTo(lst.getAt(i).email.toLowerCase())<0) {
						sortedList.insertAt(i, NodeIt.elem);
						ins=true;
					}
				}
				if(!ins) {
					sortedList.addLast(NodeIt.elem);
				}
			}
		}
		return sortedList;	
	}
	
	
	
	
	/**
	 * This methods takes a social network (that is an object of StudentsList class) 
	 * and a city name as input and returns a list containing all the students 
	 * (that is, an object of the StudentsList class) who live in that city.
	 * @param lst
	 * @param city
	 * @return
	 */
	public StudentsList locateByCity(StudentsList lst, String city) {
		
		StudentsList l = new StudentsList();
		for(int i=0;i<lst.size;i++) {
			if(lst.getAt(i).city.toUpperCase().equals(city.toUpperCase())) {
				l.addLast(lst.getAt(i));
			}
		}
		return l;
		
	}
	
	/**
	 * This takes a social network (an object of the StudentsList class) and two dates 
	 * and returns the list of all students from the input list 
	 * whose registration dates are in the interval of input dates. 
	 * Please, take into account the following comments:
		- start <= end. 
		- Both dates are included into the interval.
		- The order in the resulting list must be the same that in the input list.

	 * @param lst
	 * @param start
	 * @param end
	 * @return
	 */
	public StudentsList getStudentsByDateInterval(StudentsList lst, LocalDate start, LocalDate end) {
		StudentsList resultList=new StudentsList();

		for(int i=0;i<lst.size;i++) {
			if(start.isBefore(lst.getAt(i).date_sign_in)&&end.isAfter(lst.getAt(i).date_sign_in)) {
				resultList.addLast(lst.getAt(i));
			}
		}
		
		return resultList;
	
	}
	
	
	
	public static void main(String[] args) {
		
		Student s1=new Student("cde@uc3m.es", "COLMENAREJO", Student.Campus.LEGANES, LocalDate.of(2018,3,24));
		Student s2=new Student("dcr@uc3m.es", "GETAFE", Student.Campus.COLMENAREJO, LocalDate.of(2016,6,6));
		Student s3=new Student("ccr@uc3m.es", "MADRID", Student.Campus.GETAFE, LocalDate.of(2016,5,26));
		Student s4=new Student("brb@uc3m.es", "LEGANES", Student.Campus.LEGANES, LocalDate.of(2016,3,15));
		
		Student s5=new Student("rva@uc3m.es", "COLMENAREJO", Student.Campus.LEGANES, LocalDate.of(2016,9,18));
		Student s6=new Student("jpa@uc3m.es", "ALCORCON", Student.Campus.COLMENAREJO, LocalDate.of(2017,9,19));
		Student s7=new Student("isa@uc3m.es", "MADRID", Student.Campus.GETAFE, LocalDate.of(2014,2,2));
		Student s8=new Student("pmf@uc3m.es", "BRUNETE", Student.Campus.COLMENAREJO, LocalDate.of(2015,4,20));
		Student s9=new Student("jlm@uc3m.es", "COLMENAREJO", Student.Campus.COLMENAREJO, LocalDate.of(2018,8,10));
		
		ManageNetworkList o=new ManageNetworkList();
		StudentsList input1=new StudentsList();
		StudentsList input2=new StudentsList(); 
		input1.addLast(s1); input1.addLast(s2);input1.addLast(s3); input1.addLast(s4);
		input2.addLast(s5); input2.addLast(s2); input2.addLast(s3); 
		input2.addLast(s6); input2.addLast(s7); input2.addLast(s8); input2.addLast(s4); input2.addLast(s9);
		
		StudentsList union=o.union(input1, input2);
		System.out.print(union.toString()+"\n");

		StudentsList input1orde=o.orderBy(input1, 2);
		System.out.print(input1orde.toString()+"\n");
		input1orde=o.orderBy(input1, 1);
		System.out.print(input1orde.toString());
		
	}

}
