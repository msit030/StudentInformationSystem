import java.util.List;


public class Principal extends Professor {
	
	public String principalID;
	String password;
	String name;
	
	public List<Course> viewAllCourses(){
		return null;
	}
	
	public void addStaff(){
		
	}
	
	public void removeStaff(){
		
	}
	
	public void scheduleCourseTimeTable(){
		
	}
	
	public void viewReports(){
		
	}

	/**
	 * @author Omair
	 * 
	 * To string method
	 */
	public String toString() {
		return ""
				+ "Principal ID: "+principalID
				+ "\n"
				+ "Name: "+name
				+ "\n";
	}
	
	/**
	 * @author Omair
	 * 
	 * Equals Method
	 */
	public boolean equals(Object o) {
		Principal p = (Principal) o;
		if(p.principalID.equalsIgnoreCase(this.principalID)) {
			return true;
		}
		else 
			return false;
	}
	
}
