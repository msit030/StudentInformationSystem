import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
	
	
	
	/**
	 * @author Meher
	 * Main Execution File
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Welcome to MSIT Student Information System");
			System.out.print("\n\t Login: ");
			String uid = br.readLine();
			System.out.print("\t Password: ");
			String pwd = br.readLine();
			
			if(uid.contains("ST") && pwd.contains("SI")){
				System.out.println("\n\tWelcome to Student Home Page");
				Student crrntStudnt = (Student)getPerson(uid,pwd,"student");
				
				if(crrntStudnt == null){
					System.out.println("\nInvalid Student");
					return;
				}
				System.out.println("Greetings, "+crrntStudnt.firstName);
				
				
			}
			else if(uid.contains("PR") && pwd.contains("SI")){
				System.out.println("\n\tWelcome to Professor Home Page");
				Professor crrntProf = (Professor)getPerson(uid, pwd, "professor");
				
				if(crrntProf == null){
					System.out.println("\nInvalid Professor");
					return;
				}
				System.out.println("Greetings, XYZ");
				handleProfessorLogin(crrntProf);
				
				
			}
			else if(uid.contains("Admin") && pwd.contains("SI")){
				System.out.println("\n\tWelcome to Principal Home Page");
				Principal principal = new Principal();
				System.out.println("Greetings, Princi");
				
			}
			else if(uid.contains("Exam") && pwd.contains("SI")){
				System.out.println("\n\tWelcome to Exam Branch Home Page");
				ExamBranch exambranch = new ExamBranch();
				System.out.println("Greetings, Exam Branch");
				
			}
			else{
				System.out.println("Wrong Credentials. Please Try Again.");
			}
			br.close();
		}
		catch(Exception e){
			System.out.println("Error in Running main Software");
		}

	}

	/**
	 * @author Meher
	 * Handle the Professor Login
	 * @param crrntProf
	 */
	private static void handleProfessorLogin(Professor crrntProf) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DataHelper dh = new DataHelper();
		
		System.out.println("Select the Functionality: ");
		System.out.println("1. View the Courses taken by this Professor");
		System.out.println("2. Update the Course Details");
		System.out.println("3. View Attendance Report of the Course by this Professor");
		System.out.println("4. Get the Student List Under this Professor");
		System.out.println("5. Update Students Attendance");
		System.out.println("6. Set Question Paper of this Course");
		System.out.println("7. View the Question Paper");
		System.out.println("8. Give Marks to Students");
		System.out.println("9. View Marks");
		System.out.println("10. Signout and Exit");
		
		int choice = Integer.parseInt(br.readLine());
		while(choice>=1 && choice<=9){
		switch(choice){
			
		case 1 : {
			System.out.println("Courses Taken by this Professor: ");
			List<Course> cs = crrntProf.viewProfCourses();
			for(Course c : cs){
				System.out.println(c);
			}
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
		
		case 2 : {
			crrntProf.updateCourse(dh.list_Course.get(0));
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
		
		case 3 : {
			crrntProf.viewCourseAttendanceReport();
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
		
		case 4 : {
			System.out.println("Students under this Professor: ");
			List<Student> ss = crrntProf.getStudentListByCourse();
			for(Student c : ss){
				System.out.println(c);
			}
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
		
		case 5 : {
			System.out.println("Students who attended the Lecture: ");
			System.out.println("Just for the sake of Testing we are auto generating the list who attended..");
			List<Student> ss = new ArrayList<Student>();
			ss.add(crrntProf.getStudentListByCourse().get(0));
			ss.add(crrntProf.getStudentListByCourse().get(1));
			crrntProf.updateStudentAttendance(ss);
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
		
		case 6 : {
			crrntProf.setQuestionPaper("");
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
		
		case 7 : {
			System.out.println("Question Paper: ");
			System.out.println(crrntProf.viewQuestionPaper());
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
		
		case 8 : {
			HashMap<Student, Integer> map = crrntProf.viewMarks();
			System.out.println("Enter the Marks for each Student: ");
			System.out.println("!!!!Auto Generating this for simplicity.!!");
			crrntProf.giveMarks(map);
			System.out.println("Marks Awarded..!");
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
		
		case 9 : {
			HashMap<Student, Integer> map = crrntProf.viewMarks();
			System.out.println("Marks for each Student under the Prof: ");
			for(Student s : map.keySet()){
				System.out.println(s + "\t" + map.get(s));
			}
			System.out.println("\nSelect another Option from list above: ");
			choice = Integer.parseInt(br.readLine());
		} break;
				
		}
		}
		System.out.println("Thank You, Bye.");
		
	}

	/**
	 * @author Meher
	 * Get Student from Data Helper.
	 * @param uid
	 * @param pwd
	 * @return
	 */
	private static Object getPerson(String uid, String pwd, String person) {
		
		DataHelper dh = new DataHelper();
		
		if(person.equalsIgnoreCase("student")){
				List<Student> students = dh.list_Student;
				for(Student s : students){
						if(s.studentID.equalsIgnoreCase(uid) && s.password.equalsIgnoreCase(pwd))
							return s;
				}
		}
		else if(person.equalsIgnoreCase("professor")){
			List<Professor> prof = dh.list_Professor;
			for(Professor p : prof){
				if(p.professorID.equalsIgnoreCase(uid) && p.password.equalsIgnoreCase(pwd))
					return p;
			}
		}
		return null;
	}

}
