import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Principal extends Professor {
	
	public String principalID;
	String password;
	String name;
	
	
	
	public List<Course> viewAllCourses()
	{
		Course s;
		DataHelper dh=new DataHelper();
		List<Course> all_course_list = dh.list_Course;
		System.out.println("All Courses  : ");
		System.out.println("Course ID"+"\t"+"Course Name"+"\t\t"+"Credits");
		
		for(int i=0; i<all_course_list.size(); i++)
		{
			s=all_course_list.get(i);
			System.out.println(s.courseID+"\t\t"+s.courseName+"     \t"+s.numOfCredits);
		}
		
		return dh.list_Course;
	}
	
	public void addStaff()
	{
		DataHelper dh=new DataHelper();
		List<Professor> prof_list=dh.list_Professor;
		System.out.println("\nEnter the Staff ID : ");
		Scanner sc=new Scanner(System.in);
		String pid=sc.nextLine();
		Professor pr=new Professor();
		pr.professorID=pid;
		if(prof_list.contains(pr))
		{
			System.out.println("Staff ID already allocated");
		}
		else
		{
			pr.password="SIS123";
			dh.list_Professor.add(pr);
			System.out.println("Staff added successfully !!!");
		}
		
	}
	
	public void removeStaff()
	{
		DataHelper dh=new DataHelper();
		List<Professor> prof_list=dh.list_Professor;
		System.out.println("\nList of staff ID already present :");
		System.out.println(prof_list);
		System.out.println("\nEnter the Staff ID : ");
		Scanner sc=new Scanner(System.in);
		String pid=sc.nextLine();
		Professor pr=new Professor();
		pr.professorID=pid;
		if(prof_list.contains(pr))
		{
			dh.list_Professor.remove(pr);
			System.out.println("Staff removed successfully !!!!");
		}
		else
		{
			System.out.println("Invalid Staff ID !!!");
		}
	}
	
	
	public void scheduleCourseTimeTable()
	{
		DataHelper dh=new DataHelper();
		HashMap<Course,HashMap<String,String>> week_schedule= new HashMap<Course,HashMap<String,String>>();
		HashMap<String,String> course_schedule=new HashMap<String,String>();
		String timing_slot=null;
		Course s;
		
		
		List<Course> all_course_list = dh.list_Course;
		System.out.println("All the Courses available : ");
		System.out.println("Course ID"+"\t"+"Course Name"+"\t\t"+"Credits");
		
		for(int i=0; i<all_course_list.size(); i++)
		{
			s=all_course_list.get(i);
			System.out.println(s.courseID+"\t\t"+s.courseName+"     \t"+s.numOfCredits);
		}
		
		
		
		
		System.out.println("\nEnter the Course ID : ");
		Scanner sc=new Scanner(System.in);
		String cid=sc.nextLine();
		s=new Course();
		s.courseID=cid;
		if(all_course_list.contains(s))
		{
			s = all_course_list.get(all_course_list.indexOf(s));
			System.out.println("enter the timings for (Type No if not required) : ");
			System.out.println("Monday : ");
			sc=new Scanner(System.in);
			if(!(timing_slot=sc.nextLine()).equalsIgnoreCase("NO"))
			{
				course_schedule.put("Monday", timing_slot);
			}
			
			
			System.out.println("Tuesday : ");
			sc=new Scanner(System.in);
			if(!(timing_slot=sc.nextLine()).equalsIgnoreCase("NO"))
			{
				course_schedule.put("Tuesday", timing_slot);
			}
			
			System.out.println("Wednesday : ");
			sc=new Scanner(System.in);
			if(!(timing_slot=sc.nextLine()).equalsIgnoreCase("NO"))
			{
				course_schedule.put("Wednesday", timing_slot);
			}
			
			System.out.println("Thursday : ");
			sc=new Scanner(System.in);
			if(!(timing_slot=sc.nextLine()).equalsIgnoreCase("NO"))
			{
				course_schedule.put("Thursday", timing_slot);
			}
			
			System.out.println("Friday : ");
			sc=new Scanner(System.in);
			if(!(timing_slot=sc.nextLine()).equalsIgnoreCase("NO"))
			{
				course_schedule.put("Friday", timing_slot);
			}
			
			System.out.println("Saturday : ");
			sc=new Scanner(System.in);
			if(!(timing_slot=sc.nextLine()).equalsIgnoreCase("NO"))
			{
				course_schedule.put("Saturday", timing_slot);
			}
			week_schedule.put(s, course_schedule);
			System.out.println("Course Scheduled successfully !!!");
		}
		else
			System.out.println("\nInvalid Course ID !!!");
	}
	
	
	
	public void viewReports()
	{
		int choice=0;
		DataHelper dh=new DataHelper();
		System.out.println("\nWhat type of reports you want to view ?\n1.Attendance \n2.Marks");
		Scanner sc=new Scanner(System.in);
		try
		{
			choice=sc.nextInt();
		}
		catch(Exception e)
		{
			choice=3;
		}
		if(choice == 1)
		{
			AttendanceManager am = new AttendanceManager();
			System.out.println("\n Choose the type of Attendance Report : \n1.attendance by Student\n2.Attendance by Course \n3.Overall Attendance");
			sc=new Scanner(System.in);
			int choice1;
			try
			{
				choice1=sc.nextInt();
			}
			catch(Exception e)
			{
				choice1=4;
			}
			if(choice1 == 1)
			{
				for(int i=0; i<dh.list_Student.size(); i++)
				{
					System.out.println("\nStudent ID : " + dh.list_Student.get(i).studentID);
					dh.list_Student.get(i).viewAttendance();
					System.out.println("------------------------------------------");
				}
			}
			else if( choice1 == 2)
			{
				HashMap<Student,Integer> attndnce_by_crse;
				for(int i=0; i<dh.list_Course.size(); i++)
				{
					attndnce_by_crse=am.getAttendanceByCourse(dh.list_Course.get(i));
					System.out.println("\nCourse ID : " + dh.list_Course.get(i).courseID);
					System.out.println("StudentID" + "\t" + "Attendance");
					for(Map.Entry<Student, Integer> entry : attndnce_by_crse.entrySet() )
					{
						System.out.println(entry.getKey().studentID + "\t\t" + entry.getValue());
					}
					System.out.println("------------------------------------------");
				}
				
			}
			else if( choice1 == 3)
			{
				HashMap<Course,HashMap<Student,Integer>> attndnce = am.getAttendanceReport();
				HashMap<Student,Integer> attndnce_by_crse;
				for(Map.Entry<Course, HashMap<Student, Integer>> entry1 : attndnce.entrySet())
				{
					System.out.println("\n Course ID: " + entry1.getKey().courseID);
					attndnce_by_crse=entry1.getValue();
					System.out.println("StudentID" + "\t" + "Attendance");
					for(Map.Entry<Student, Integer> entry : attndnce_by_crse.entrySet() )
					{
						System.out.println(entry.getKey().studentID + "\t\t" + entry.getValue());
					}
					System.out.println("--------------------------------------------");
				}
			}
			else
				System.out.println("\n Invalid Choice !!!");
		}
		else if (choice == 2)
		{
			MarksManager mm = new MarksManager();
			System.out.println("\n Choose the type of Marks Report : \n1.Marks by Student\n2.Marks by Course \n3.Overall Marks");
			sc=new Scanner(System.in);
			int choice2;
			try
			{
				choice2=sc.nextInt();
			}
			catch(Exception e)
			{
				choice2=4;
			}
			if(choice2 == 1)
			{
				for(int i=0; i<dh.list_Student.size(); i++)
				{
					System.out.println("\nStudent ID : " + dh.list_Student.get(i).studentID);
					dh.list_Student.get(i).viewResults();
					System.out.println("------------------------------------------");
				}
				
			}
			else if( choice2 == 2)
			{
				HashMap<Student,Integer> marks_by_crse;
				
				for(int i=0; i<dh.list_Course.size(); i++)
				{
					marks_by_crse=mm.getMarksByCourse(dh.list_Course.get(i));
					System.out.println("\nCourse ID : " + dh.list_Course.get(i).courseID);
					System.out.println("StudentID" + "\t" + "Marks");
					for(Map.Entry<Student, Integer> entry : marks_by_crse.entrySet() )
					{
						System.out.println(entry.getKey().studentID + "\t\t" + entry.getValue());
					}
					System.out.println("------------------------------------------");
				}
				
				
			}
			else if( choice2 == 3)
			{
				HashMap<Course,HashMap<Student,Integer>> marks = mm.getMarksReport();
				HashMap<Student,Integer> marks_by_crse;
				for(Map.Entry<Course, HashMap<Student, Integer>> entry1 : marks.entrySet())
				{
					System.out.println("\n Course ID: " + entry1.getKey().courseID);
					marks_by_crse=entry1.getValue();
					System.out.println("StudentID" + "\t" + "Marks");
					for(Map.Entry<Student, Integer> entry : marks_by_crse.entrySet() )
					{
						System.out.println(entry.getKey().studentID + "\t\t" + entry.getValue());
					}
					System.out.println("--------------------------------------------");
				}
			}
			else
				System.out.println("\n Invalid Choice !!!");
		}
		else
		{
			System.out.println("\nInvalid Choice !!!");
		}
		
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
	 * @author Meher
	 * hash code for principal is nothing but hash code of principalID.
	 */
	public int hashCode(){
		return principalID.hashCode();
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
