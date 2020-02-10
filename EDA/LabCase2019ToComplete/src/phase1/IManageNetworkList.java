package phase1;

import java.time.LocalDate;

public interface IManageNetworkList {

	

	/**
	 *  This method joins two social networks into a single social network. 
	 *  The method takes two objects of the StudentsList and returns a new list containing 
	 *  first the students from the first list followed by the students from the second list. 
	 * @param lst1
	 * @param lst2
	 * @return
	 */
	public StudentsList union(StudentsList lst1, StudentsList lst2);
	
	/**
	 * 2. This methods takes a social network as input and an integer parameter opc so that:
		- If opc =1: the method must return a StudentsList containing all the students residing
			in the same city that the campus where they are studying.
		- If opc =2: the method must return a StudentsList containing all the students residing
			in cities different that the one where their campus is located.
	 * @param lst1
	 * @param lst2
	 * @param opc
	 * @return
	 */
	
	public StudentsList getCampusCity(StudentsList lst, int opc);

	
	/**
	 * 3. This method takes a social network as input and a integer parameter opc so that: 
			- If opc=1, the method returns a list of students sorted by ascending
			order according to their full name.
			- If opc=2, the method returns a lit of students sorted by descending
			order according to their full name. 
	 * @param lst
	 * @param opc
	 * @return
	 */
	public StudentsList orderBy(StudentsList lst, int opc);
	
	
	
	
	/**
	 * This methods takes a social network (that is an object of StudentsList class) 
	 * and a city name as input and returns a list containing all the students 
	 * (that is, an object of the StudentsList class) who live in that city.
	 * Note 1. You must implement your own sort method based on some of the sorted algorithms (such as bubble, sort). 
	 * Note 2: Remember that you cannot modify or extend the StudentsList class. 
	 * Therefore, if you need an auxiliary method that help you to sort the list, 
	 * please include this method into the ManageNetwork class. 
	 * Note 3. The input list cannot be modified. The method must return a new list where the students are sorted.

	 * @param lst
	 * @param city
	 * @return
	 */
	public StudentsList locateByCity(StudentsList lst, String city);
	
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
	public StudentsList getStudentsByDateInterval(StudentsList lst, LocalDate start, LocalDate end);
	
	
}
