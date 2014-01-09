import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : DataHelper.java
//  @ Date : 1/8/2014
//  @ Author : Meher, Harika, Omair, Nikhila
//
//

//when I push i should push only files and not properties or .project files. (Meher)



/**
 * @author NIKHILA
 *
 */



public class DataHelper {
	
	/**
	 * @nikhila
	 */
	List<Course> list_Course=new ArrayList<Course>(10);
	List<Professor> list_Professor=new ArrayList<Professor>(4);
	List<Student> list_Student=new ArrayList<Student>(10);
	List<String> list_Qstnpaper=new ArrayList<String>(4);
	HashMap<Course,Professor> map = new HashMap<Course,Professor>();
	
	DataHelper() {
		load_Course();
		load_Professor();
		try {
			load_Student();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @ nikhila
	 */
	public void load_Course()
	{
		list_Course.add(new Course("DATA STRUCTURES","BCS101","ABC",4,7,4,"1.what is a data structure?2.what is heap?"));
		list_Course.add(new Course("ALGORITHMS","BCS102","DEF",4,7,4,"1.what is an algorithm 2. explain quick sort"));
		list_Course.add(new Course("OPERATING SYSTEMS","BCS103","GHI",4,7,4,"1.what are the types of os?2.explain threads?"));
		list_Course.add(new Course("COMPUTER NETWORKS","BCS104","JKL",4,7,4,"1.what is a packet2.explain osi model"));
	}
	
	
	/**
	 * @nikhila
	 */
	public void load_Professor()
	{
		list_Professor.add(new Professor("PROF1","SIS123"));
		list_Professor.add(new Professor("PROF2","SIS123"));
		list_Professor.add(new Professor("PROF3","SIS123"));
		list_Professor.add(new Professor("PROF4","SIS123"));
	}
	
	
	/**
	 * @throws ParseException 
	 * @nikhila
	 */
	public void load_Student() throws ParseException
	{
		String testDate = "29-Apr-1990";
		DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy");
		Student s0 = new Student();
		s0.address="address1";s0.bloodGroup="bg1";s0.branch="CSE";s0.year=2013;s0.currentYear=1;
		s0.dob=(Date) formatter.parse(testDate);s0.eduBackground="SSC";s0.firstName="A1";
		s0.lastName="A2";s0.isRegistered=true;s0.phoneNumber=123456;s0.studentID="ST01";s0.password="SIS123";
		
		Student s1 = new Student();
		s1.address="address2";s1.bloodGroup="bg1";s1.branch="ECE";s1.year=2012;s1.currentYear=2;
		s1.dob=(Date) formatter.parse(testDate);s1.eduBackground="SSC";s1.firstName="B1";
		s1.lastName="B2";s1.isRegistered=true;s1.phoneNumber=123456;s1.studentID="ST02";s1.password="SIS123";
		
		Student s2 = new Student();
		s2.address="address3";s2.bloodGroup="bg1";s2.branch="CSE";s2.year=2013;s2.currentYear=1;
		s2.dob=(Date) formatter.parse(testDate);s2.eduBackground="ICSE";s2.firstName="C1";
		s2.lastName="C2";s2.isRegistered=true;s2.phoneNumber=123456;s2.studentID="ST03";s2.password="SIS123";
		
		Student s3 = new Student();
		s3.address="address4";s3.bloodGroup="bg1";s3.branch="ECE";s3.year=2012;s3.currentYear=2;
		s3.dob=(Date) formatter.parse(testDate);s3.eduBackground="CBSE";s3.firstName="D1";
		s3.lastName="D2";s3.isRegistered=true;s3.phoneNumber=123456;s3.studentID="ST04";s3.password="SIS123";

		Student s4 = new Student();
		s4.address="address5";s4.bloodGroup="bg1";s4.branch="CSE";s4.year=2013;s4.currentYear=1;
		s4.dob=(Date) formatter.parse(testDate);s4.eduBackground="SSC";s4.firstName="E1";
		s4.lastName="E2";s4.isRegistered=true;s4.phoneNumber=123456;s4.studentID="ST05";s4.password="SIS123";
		
		Student s5 = new Student();
		s5.address="address6";s5.bloodGroup="bg1";s5.branch="ECE";s5.year=2012;s5.currentYear=2;
		s5.dob=(Date) formatter.parse(testDate);s5.eduBackground="ICSE";s5.firstName="F1";
		s5.lastName="F2";s5.isRegistered=true;s5.phoneNumber=123456;s5.studentID="ST06";s5.password="SIS123";
		
		Student s6 = new Student();
		s6.address="address7";s6.bloodGroup="bg1";s6.branch="CSE";s6.year=2013;s6.currentYear=1;
		s6.dob=(Date) formatter.parse(testDate);s6.eduBackground="SSC";s6.firstName="G1";
		s6.lastName="G2";s6.isRegistered=true;s6.phoneNumber=123456;s6.studentID="ST07";s6.password="SIS123";
		
		Student s7 = new Student();
		s7.address="address8";s7.bloodGroup="bg1";s7.branch="ECE";s7.year=2012;s7.currentYear=2;
		s7.dob=(Date) formatter.parse(testDate);s7.eduBackground="CBSE";s7.firstName="H1";
		s7.lastName="H2";s7.isRegistered=true;s7.phoneNumber=123456;s7.studentID="ST08";s7.password="SIS123";
		
		Student s8 = new Student();
		s8.address="address9";s8.bloodGroup="bg1";s8.branch="CSE";s8.year=2013;s8.currentYear=1;
		s8.dob=(Date) formatter.parse(testDate);s8.eduBackground="SSC";s8.firstName="I1";
		s8.lastName="I2";s8.isRegistered=true;s8.phoneNumber=123456;s8.studentID="ST09";s8.password="SIS123";
		
		Student s9 = new Student();
		s9.address="address10";s9.bloodGroup="bg1";s9.branch="ECE";s9.year=2012;s9.currentYear=2;
		s9.dob=(Date) formatter.parse(testDate);s9.eduBackground="ICSE";s9.firstName="J1";
		s9.lastName="J2";s9.isRegistered=true;s9.phoneNumber=123456;s9.studentID="ST010";s9.password="SIS123";
		
		list_Student.add(s1);list_Student.add(s2);
		list_Student.add(s3);list_Student.add(s4);
		list_Student.add(s5);list_Student.add(s6);
		list_Student.add(s7);list_Student.add(s8);
		list_Student.add(s9);list_Student.add(s0);
		
		
	}
	
	
	/**
	 * 
	 * @nikhila
	 */
	public List<Course> viewAllCourse() {
		return list_Course;
	}
	
	public List<Student> viewAllStudentsByCourse(Course course) 
	{
		List<Student> l=new ArrayList<Student>(10);
		if(course.courseID.equalsIgnoreCase("BCS101"))
		{
			l.add(list_Student.get(0));
			l.add(list_Student.get(1));
		}
		else if(course.courseID.equalsIgnoreCase("BCS102"))
		{
			l.add(list_Student.get(2));
			l.add(list_Student.get(3));
			l.add(list_Student.get(4));
		}
		else if(course.courseID.equalsIgnoreCase("BCS103"))
		{
			l.add(list_Student.get(4));
			l.add(list_Student.get(5));
			l.add(list_Student.get(6));
			l.add(list_Student.get(7));
		}
		else
		{
			l.add(list_Student.get(7));
			l.add(list_Student.get(8));
			l.add(list_Student.get(9));
			
		}
		return l;
	}
	
	
	/**
	 * 
	 * @param course
	 * @nikhila
	 */
	public String getQuestionPaper(Course course) {
		
		for(int i=0;i<list_Course.size();i++)
		{
			if(course.courseID.equalsIgnoreCase(list_Course.get(i).courseID))
			{
				return list_Course.get(i).questionPaper;
			}
		}
		return null;
	}
	
	
	
	/**
	 * @nikhila
	 */
	public List<Professor> viewAllProfessor()
	{
		return list_Professor;
	}
	
	/**
	 * @author Meher
	 * method to map courses to professors.
	 */
	public HashMap<Course,Professor> viewAllCoursesByProfessor(){
		
		
		map.put(list_Course.get(0), list_Professor.get(0));
		map.put(list_Course.get(1), list_Professor.get(1));
		map.put(list_Course.get(2), list_Professor.get(2));
		map.put(list_Course.get(3), list_Professor.get(3));
		return map;
	}
}

