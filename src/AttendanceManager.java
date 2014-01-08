import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : AttendanceManager.java
//  @ Date : 1/8/2014
//  @ Authors : Meher, Nikhila, Omair, Harika 
//
// this is an attendance manager.. 




public class AttendanceManager 
{
	HashMap<Course,HashMap<Student,Integer>> attendance=new HashMap<Course,HashMap<Student,Integer>>();
	HashMap<Student,Integer> ht=new HashMap<Student,Integer> ();
	List<Student> student_list_in_course=new ArrayList<Student>(); 
	DataHelper dh=new DataHelper();
	
	
	/**
	 * @Authors: Nikhila, Harika
	 * 
	 * This is a constructor which creates the hash map of course, student and attendance
	 * which is used in other methods
	 */
	public AttendanceManager()
	{		
		for(int i=0;i<dh.list_Course.size();i++)
		{
			student_list_in_course=dh.viewAllStudentsByCourse(dh.list_Course.get(i));
			for(int j=0;j<student_list_in_course.size();j++)
			{
				ht.put(student_list_in_course.get(j),j+3);
			}
			attendance.put(dh.list_Course.get(i), ht);
		}
	}
	
	
	/**
	 * @Authors: Nikhila, Harika
	 * 
	 * This method gets the attendance of a student for each course
	 * @param student object
	 * @return Map of courses attended by the student and his attendance in that course
	 */
	public HashMap<Course,Integer> getAttendanceByStudent(Student student) 
	{
		int attndnce_cnt=0;
		HashMap<Course,Integer> attndce_of_stdnt = new HashMap<Course,Integer>();
		for(int i=0; i<dh.list_Course.size(); i++)
		{
			ht = attendance.get(dh.list_Course.get(i));
			if(ht!=null && ht.get(student)!=null)
			{
				attndnce_cnt = ht.get(student);
				attndce_of_stdnt.put(dh.list_Course.get(i), attndnce_cnt);
			}
			else
				System.out.println("Cannot retrieve data");
			
		}
		return attndce_of_stdnt;
	
	}
	
	
	/**
	 * @Authors: Nikhila, Harika
	 * 
	 * This method gets the attendance of all students in a particular course
	 * @param course object
	 * @return map of students in a course and their attendance in that course
	 */
	public HashMap<Student,Integer> getAttendanceByCourse(Course course) 
	{
		try
		{
			ht = attendance.get(course);
			if(ht==null)
				throw new Exception();
			return ht;
		}
		catch(Exception e)
		{
			System.out.println("\n Course not valid!!!");
			return null;
		}
	}
	
	
	/**
	 * @Authors: Nikhila, Harika
	 * 
	 * This method returns the major map of course, student and their attendance
	 * @return map of course, student and their attendance
	 */
	public HashMap<Course,HashMap<Student,Integer>> getAttendanceReport() 
	{
		return attendance;
	}
	
	
	/**
	 * @Authors: Nikhila, Harika
	 * 
	 * This method adds attendance to a student in particular course
	 * @param student object to which attendance should be added
	 * @param course in which the attendance of the student has to be added.
	 */
	public void addAttendance(Student student, Course course) 
	{
		try
		{
			ht = attendance.get(course);
			int old_attendance = 0;
			if(ht.containsKey(student))
				old_attendance = ht.get(student);
				ht.put(student, old_attendance+1);
		}
		catch(Exception e)
		{
			System.out.println("\n Course not found!!!");
		}
		return;
	}
}
