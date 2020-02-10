package phase1;

import java.util.Random;

import java.time.LocalDate;


//IMPORTANT:::: YOU CANNOT MODIFY OR EXTEND THIS CLASS. PLEASE, COME WITH YOUR LAB TEACHER ANY CHANGE OR EXTENSION THAT 
// YOU WOULD LIKE TO MAKE, SO SHE WILL ADVISE YOU THE BEST OPTION 

public class Student {
	
	public enum Campus {
	    GETAFE, LEGANES, COLMENAREJO 
	}
	
	/**
	 * object's attributes
	 */
		public String email;
		public String city;
		public Campus campus;
		public int blocks;
		public LocalDate date_sign_in;

		
		public Student(String email, String city, Campus campus, LocalDate date_sign_in) {
			this.email = email;
			this.city = city;
			this.campus = campus;
			this.blocks=0; //by default
			this.date_sign_in=date_sign_in;
		}
		
		/**
		 * Constructors that also initializes the attribute blocks
		 * @param email
		 * @param city
		 * @param campus
		 * @param blocks
		 * @param date_sign_in
		 */
		public Student(String email, String city, Campus campus, int blocks, LocalDate date_sign_in) {
			this.email = email;
			this.city = city;
			this.campus = campus;
			this.blocks=blocks;
			this.date_sign_in=date_sign_in;
		}

		
		@Override
		public String toString() {
			return "Student [email=" + email + ", city=" + city + ", campus=" + campus
					+ ", blocks=" + blocks + ", date_sign_in=" + date_sign_in + "]";
		}

		
		/**
		 * method that checks if the invoking object (this) is equals to the input object obj
		 * @param obj
		 * @return
		 */
		public boolean equals(Student obj) {
			if (this == obj) return true;
			
			if (obj == null) return false;
			
			Student other = (Student) obj;
			
			if (blocks != other.blocks) return false;
			
			if (campus != other.campus) return false;
			
			if (city == null) {
				if (other.city != null) return false;
			} else if (!city.equals(other.city)) return false;
			
			if (date_sign_in == null) { 
				if (other.date_sign_in != null) return false;
			} else if (!date_sign_in.equals(other.date_sign_in)) return false;
			
			
			if (email == null) {
				if (other.email != null) return false;
			} else if (!email.equals(other.email))
				return false;
			
			
			return true;
		}
			
		
		
		
		
	
	//STATIC ATTRIBUTES AND METHODS TO GENERATE RANDOM STUDENTS
		public static final String[] EMAILS={"isa@uc3m.es","pmf@uc3m.es","har@uc3m.es","lou@uc3m.es","cde@uc3m.es",
											"jlm@uc3m.es","brb@uc3m.es","igr@uc3m.es","jpa@uc3m.es","jlm@uc3m.es",
											"ccr@uc3m.es","rva@uc3m.es", "aab@uc3m.3s", "bgg@uc3m.es","dcr@uc3m.es"};
		
		public static final String[] CITIES={"GETAFE", "LEGANES", "COLMENAREJO", "FUENLABRADA", "ALCORCON", "BRUNETE", "MADRID" };
	
		
		/**
		 * Returns a random date between 2010-1-1 and 2019-1-1. 
			ISO-8601 calendar system, such as 2007-12-03. 
		 * @return
		 */
		public static LocalDate randDate() {
			Random random = new Random();
			int minDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
			int maxDay = (int) LocalDate.of(2019, 1, 1).toEpochDay();
			long randomDay = minDay + random.nextInt(maxDay - minDay);
			LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
			return randomDate;
	    }
	
	
			

	/**
	 * Creates and returns random student	
	 * @return
	 */
	public static Student createRandomStudent() {
			Random rn=new Random();
			int index_user=rn.nextInt(EMAILS.length);
			int index_city=rn.nextInt(CITIES.length);
			int index_campus= new Random().nextInt(Campus.values().length);
		    LocalDate randomDate=randDate();
		    return new Student(EMAILS[index_user], CITIES[index_city], Campus.values()[index_campus], randomDate);
	}

	
		
	

	
	
}